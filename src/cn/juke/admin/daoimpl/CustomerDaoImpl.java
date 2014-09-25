package cn.juke.admin.daoimpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import cn.juke.admin.dao.CustomerDao;
import cn.juke.bean.Customer;
import cn.juke.util.HibernateUtils;
import cn.juke.util.Page;

public class CustomerDaoImpl extends GenericHibernateDao<Customer> implements CustomerDao
{
    public CustomerDaoImpl() {
        super(Customer.class);

    }

    public List<Customer> search(String customerName,Page page,Long comid)
    {
    	List<Customer> custs = new ArrayList<Customer>();

		Session session = HibernateUtils.getSession();
		
		String sql1 = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +			
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and b.name = "+customerName+" and a.comid = "+comid;
		
		page.setTotalCount(session.createSQLQuery(sql1).list().size());
		
		int first = (page.getPageIndex() - 1) * page.getPageSize();
		
		String sql = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +			
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and b.name = "+customerName+" and a.comid = "+comid+" limit "+first+","+page.getPageSize();
		System.out.println(sql);

 		List list = session.createSQLQuery(sql).list();
 		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Customer db=new Customer(new Long(((BigInteger)objects[0]).intValue()),(String)objects[1],
					(String)objects[2],(String)objects[3],(String)objects[4],(Integer)objects[5],
					(String)objects[6],(String)objects[7],(String)objects[8],(String)objects[9]);
			db.setStatusName();
			
			custs.add(db);
		}
		HibernateUtils.closeSession(session);
		
		return custs;
    }
    
    public List<Customer> search(Page page, int status,Long comid)
    {
    	List<Customer> custs = new ArrayList<Customer>();

		Session session = HibernateUtils.getSession();
		
		String sql="";
		String sql1="";
		if(status>=0){
	    sql1 = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +		
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and a.status = "+status+" and a.comid = "+comid;
		
		page.setTotalCount(session.createSQLQuery(sql1).list().size());
		
		int first = (page.getPageIndex() - 1) * page.getPageSize();
		
		 sql = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +			
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and a.status = "+status+" and a.comid = "+comid+" limit "+first+","+page.getPageSize();
		}
		else {
			sql1 = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
					"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +	
					"  from deal a,customer b,broker c,house d " +
					" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and a.comid = "+comid;
			
			page.setTotalCount(session.createSQLQuery(sql1).list().size());
			
			int first = (page.getPageIndex() - 1) * page.getPageSize();
			
		  sql = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
					"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +			
					"  from deal a,customer b,broker c,house d " +
					" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and a.comid = "+comid+" limit "+first+","+page.getPageSize();
			}
        System.out.println(sql);
 		List list = session.createSQLQuery(sql).list();
 		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Customer db=new Customer(new Long(((BigInteger)objects[0]).intValue()),(String)objects[1],
					(String)objects[2],(String)objects[3],(String)objects[4],(Integer)objects[5],
					(String)objects[6],(String)objects[7],(String)objects[8],(String)objects[9]);
			db.setStatusName();
			
			custs.add(db);
		}
		HibernateUtils.closeSession(session);
		
		return custs;
    }
    
    public List<Customer> search(Page page) {
    	List<Customer> custs = new ArrayList<Customer>();

		Session session = HibernateUtils.getSession();
		
		String sql1 = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +	
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id";
		
		page.setTotalCount(session.createSQLQuery(sql1).list().size());
		
		int first = (page.getPageIndex() - 1) * page.getPageSize();
		
		String sql = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +			
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id limit "+first+","+page.getPageSize();
		System.out.println(sql);

 		List list = session.createSQLQuery(sql).list();
 		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Customer db=new Customer(new Long(((BigInteger)objects[0]).intValue()),(String)objects[1],
					(String)objects[2],(String)objects[3],(String)objects[4],(Integer)objects[5],
					(String)objects[6],(String)objects[7],(String)objects[8],(String)objects[9]);
			db.setStatusName();
			
			custs.add(db);
		}
		HibernateUtils.closeSession(session);
		
		return custs;
    }

	@Override
	public List<Customer> search(String customerName, Page page) {
		List<Customer> custs = new ArrayList<Customer>();

		Session session = HibernateUtils.getSession();
		
		String sql1 ="select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and b.name = "+customerName+"";
		
		page.setTotalCount(session.createSQLQuery(sql1).list().size());
		
		int first = (page.getPageIndex() - 1) * page.getPageSize();
		
		String sql = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +			
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and b.name = "+customerName+" limit "+first+","+page.getPageSize();
		System.out.println(sql);

 		List list = session.createSQLQuery(sql).list();
 		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Customer db=new Customer(new Long(((BigInteger)objects[0]).intValue()),(String)objects[1],
					(String)objects[2],(String)objects[3],(String)objects[4],(Integer)objects[5],
					(String)objects[6],(String)objects[7],(String)objects[8],(String)objects[9]);
			db.setStatusName();
			
			custs.add(db);
		}
		HibernateUtils.closeSession(session);
		
		return custs;
	}

	@Override
	public List<Customer> search(Page page, int status) {
		List<Customer> custs = new ArrayList<Customer>();

		Session session = HibernateUtils.getSession();
		
		String sql="";
		String sql1="";
		if(status>=0){
	    sql1 = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +		
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and a.status = "+status;
		
		page.setTotalCount(session.createSQLQuery(sql1).list().size());
		
		int first = (page.getPageIndex() - 1) * page.getPageSize();
		
		 sql = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
				"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +			
				"  from deal a,customer b,broker c,house d " +
				" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id and a.status = "+status+" limit "+first+","+page.getPageSize();
		}
		else {
			sql1 = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
					"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +	
					"  from deal a,customer b,broker c,house d " +
					" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id ";
			
			page.setTotalCount(session.createSQLQuery(sql1).list().size());
			
			int first = (page.getPageIndex() - 1) * page.getPageSize();
			
		  sql = "select a.id as bid,b.name as bname,b.phone as bphone,b.weixin as bweixin,b.qq as bqq," +
					"a.status ,d.name as dname,c.name as cname,a.create_time as actime,a.dealer as dealer " +			
					"  from deal a,customer b,broker c,house d " +
					" where a.customer_id = b.id and a.broker_id=c.id and a.house_id = d.id  limit "+first+","+page.getPageSize();
			}
        System.out.println(sql);
 		List list = session.createSQLQuery(sql).list();
 		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Customer db=new Customer(new Long(((BigInteger)objects[0]).intValue()),(String)objects[1],
					(String)objects[2],(String)objects[3],(String)objects[4],(Integer)objects[5],
					(String)objects[6],(String)objects[7],(String)objects[8],(String)objects[9]);
			db.setStatusName();
			
			custs.add(db);
		}
		HibernateUtils.closeSession(session);
		
		return custs;
	}
}
