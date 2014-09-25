package cn.juke.admin.daoimpl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.juke.util.HibernateUtils;
import cn.juke.util.Page;

public abstract class GenericHibernateDao<T>
{
	private final Class<T> clazz;
	
	protected HibernateTemplate ht=HibernateUtils.getHibernateTemplate();
	
	public GenericHibernateDao(Class<T> clazz)
	{
		this.clazz = clazz;
	}
		
	  @SuppressWarnings("unchecked")
	public T query(Serializable id)
	{
		
		T t = (T) ht.get(clazz, id);
		if (t == null)
			throw new DataRetrievalFailureException("Object not found");
		return t;
	}
	

	public void create(T t)
	{
		ht.save(t);
	}
	

	public void delete(T t)
	{
		ht.delete(t);
	}
	

	public void update(T t)
	{
		ht.update(t);
	}
	

	protected Object queryForObject(final String select, final Object[] values)
	{
		HibernateCallback selectCallBack = new HibernateCallback()
		{
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException
			{
				Query query = session.createQuery(select);
				if (values != null)
					for (int i = 0; i < values.length; i++)
						query.setParameter(i, values[i]);
				return query.uniqueResult();
			}
		};
		return ht.execute(selectCallBack);
	}
	
	
	protected List queryForList(final String select, final Object[] values)
    {
        HibernateCallback selectCallBack = new HibernateCallback()
        {
            public Object doInHibernate(Session session)
                    throws HibernateException, SQLException
            {
                Query query = session.createQuery(select);
                if (values != null)
                    for (int i = 0; i < values.length; i++)
                        query.setParameter(i, values[i]);
                return query.list();
            }
        };
        return ht.executeFind(selectCallBack);
    }
	
		
		  @SuppressWarnings("unchecked")
		protected List<T> queryForList(final String select, final Object[] values,
				final Page page)
		{
			String selectCount="select count(*) "+select;
			Long count = (Long) queryForObject(selectCount, values);
			page.setTotalCount(count.intValue());
			
			HibernateCallback selectCallBack = new HibernateCallback()
			{
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException
				{
					Query query = session.createQuery(select);
					if (values != null)
						for (int i = 0; i < values.length; i++)
							query.setParameter(i, values[i]);
					return query.setFirstResult(page.getFirstResult()).setMaxResults(
							page.getPageSize()).list();
				}
			};
			return (List<T>) ht.executeFind(selectCallBack);
		}
		
		protected List<T> queryForList(final String selectCount, final String select,
				final Object[] values, final Page page)
		{
			Long count = (Long) queryForObject(selectCount, values);
			page.setTotalCount(count.intValue());
			return queryForList(select, values, page);
		}
		  @SuppressWarnings("unchecked")
		protected List<T> queryForList(final String select)
		{
			return ht.find(select);
		}
		
		
}
