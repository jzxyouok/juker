package cn.juke.admin.daoimpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import cn.juke.admin.dao.BrokerDao;
import cn.juke.bean.Broker;
import cn.juke.util.HibernateUtils;
import cn.juke.util.Page;

public class BrokerDaoImpl extends GenericHibernateDao<Broker> implements
		BrokerDao {
	public BrokerDaoImpl() {
		super(Broker.class);

	}
    
     public List<Broker> search(String name,Page page,Long comid){
    	 List<Broker> brokers = new ArrayList<Broker>();

 		Session session = HibernateUtils.getSession();
 		
 		String sql1="select a.id as aid,a.phone as aphone,a.name as aname,sum(case when b.status >= 0 then 1 else 0 end) as recNum,sum(case when b.status > 2 then 1 else 0 end) as ariNum,"
 				+ "sum(case when b.status = 5 then 1 else 0 end) as dealNum,a.account as bcount ,a.create_time as actime from broker a left join deal b " +
 				"on a.id = b.broker_id where a.state='1' and b.comid = "+comid+" and a.name = '"+name+"' group by a.id ";
 		
 		page.setTotalCount(session.createSQLQuery(sql1).list().size());
 		
 		int first= (page.getPageIndex() - 1)* page.getPageSize();
 		String sql = "select a.id as aid,a.phone as aphone,a.name as aname,sum(case when b.status >= 0 then 1 else 0 end) as recNum,sum(case when b.status > 2 then 1 else 0 end) as ariNum,"
 				+ "sum(case when b.status = 5 then 1 else 0 end) as dealNum,a.account as bcount ,a.create_time as actime from broker a left join deal b " +
 				"on a.id = b.broker_id where a.state='1' and b.comid = "+comid+" and a.name = '"+name+"' group by a.id  limit "
 				+ first  + " ," + page.getPageSize();

 		System.out.println(sql);
 		List list = session.createSQLQuery(sql).list();
 		
 		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
 			Object[] objects = (Object[]) iterator.next();
 			brokers.add(new Broker(new Long(((BigInteger)objects[0]).intValue()), (String) objects[1],
 					(String) objects[2], ((BigDecimal) objects[3]).intValue(),
 					((BigDecimal) objects[4]).intValue(),
 					((BigDecimal) objects[5]).intValue(),
 					(String) objects[6],(String)objects[7])
 );
 		}
 		HibernateUtils.closeSession(session);
 		
 		return brokers;
     }
	 

	public List<Broker> search(Page page,Long comid) {
		List<Broker> brokers = new ArrayList<Broker>();

		Session session = HibernateUtils.getSession();

 		String sql1="select a.id as aid,a.phone as aphone,a.name as aname,sum(case when b.status >= 0 then 1 else 0 end) as recNum,sum(case when b.status > 2 then 1 else 0 end) as ariNum,"
 				+ "sum(case when b.status = 5 then 1 else 0 end) as dealNum,a.account as bcount ,a.create_time as actime from broker a left join deal b " +
 				"on a.id = b.broker_id where a.state='1' and b.comid = "+comid+" group by a.id ";
 				
 		int size=session.createSQLQuery(sql1).list().size();
		page.setTotalCount(size);
		
		int first= (page.getPageIndex() - 1)* page.getPageSize();
		
 		String sql = "select a.id as aid,a.phone as aphone,a.name as aname,sum(case when b.status >= 0 then 1 else 0 end) as recNum,sum(case when b.status > 2 then 1 else 0 end) as ariNum,"
 				+ "sum(case when b.status = 5 then 1 else 0 end) as dealNum,a.account as bcount ,a.create_time as actime from broker a left join deal b " +
 				"on a.id = b.broker_id where a.state='1' and b.comid = "+comid+" group by a.id limit "
 				+ first  + " ," + page.getPageSize();

		System.out.println(sql);
		
		List list = session.createSQLQuery(sql).list();
				
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			brokers.add(new Broker(new Long(((BigInteger)objects[0]).intValue()), (String) objects[1],
					(String) objects[2], ((BigDecimal) objects[3]).intValue(),
					((BigDecimal) objects[4]).intValue(),
					((BigDecimal) objects[5]).intValue(),
					(String) objects[6],(String)objects[7])
);
		}
		HibernateUtils.closeSession(session);
		
		return brokers;
	}
	
	public List<Broker> search(Page page) {
		List<Broker> brokers = new ArrayList<Broker>();

		Session session = HibernateUtils.getSession();

 		String sql1="select a.id as aid,a.phone as aphone,a.name as aname,sum(case when b.status >= 0 then 1 else 0 end) as recNum,sum(case when b.status > 2 then 1 else 0 end) as ariNum,"
 				+ "sum(case when b.status = 5 then 1 else 0 end) as dealNum,a.account as bcount ,a.create_time as actime from broker a left join deal b " +
 				"on a.id = b.broker_id where a.state='1' group by a.id ";
 		
 		page.setTotalCount(session.createSQLQuery(sql1).list().size());
 		
 		int first= (page.getPageIndex() - 1)* page.getPageSize();

 		String sql = "select a.id as aid,a.phone as aphone,a.name as aname,sum(case when b.status >= 0 then 1 else 0 end) as recNum,sum(case when b.status > 2 then 1 else 0 end) as ariNum,"
 				+ "sum(case when b.status = 5 then 1 else 0 end) as dealNum,a.account as bcount ,a.create_time as actime from broker a left join deal b " +
 				"on a.id = b.broker_id where a.state='1' group by a.id limit "
 				+ first  + " ," + page.getPageSize();

		System.out.println(sql);
		
		List list = session.createSQLQuery(sql).list();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			brokers.add(new Broker(new Long(((BigInteger)objects[0]).intValue()), (String) objects[1],
					(String) objects[2], ((BigDecimal) objects[3]).intValue(),
					((BigDecimal) objects[4]).intValue(),
					((BigDecimal) objects[5]).intValue(),
					(String) objects[6],(String)objects[7])
);
		}
		HibernateUtils.closeSession(session);
		
		return brokers;
	}
	
	public List<Broker> search(String name,Page page) {
		List<Broker> brokers = new ArrayList<Broker>();

		Session session = HibernateUtils.getSession();

 		String sql1="select a.id as aid,a.phone as aphone,a.name as aname,sum(case when b.status >= 0 then 1 else 0 end) as recNum,sum(case when b.status > 2 then 1 else 0 end) as ariNum,"
 				+ "sum(case when b.status = 5 then 1 else 0 end) as dealNum,a.account as bcount ,a.create_time as actime from broker a left join deal b " +
 				"on a.id = b.broker_id where a.state='1' and a.name = '"+name+"' group by a.id ";
 				
 		page.setTotalCount(session.createSQLQuery(sql1).list().size());
 		
 		int first= (page.getPageIndex() - 1)* page.getPageSize();
 		
 		String sql = "select a.id as aid,a.phone as aphone,a.name as aname,sum(case when b.status >= 0 then 1 else 0 end) as recNum,sum(case when b.status > 2 then 1 else 0 end) as ariNum,"
 				+ "sum(case when b.status = 5 then 1 else 0 end) as dealNum,a.account as bcount ,a.create_time as actime from broker a left join deal b " +
 				"on a.id = b.broker_id where a.state='1' and a.name = '"+name+"' group by a.id limit "
 				+ first  + " ," + page.getPageSize();
        
		System.out.println(sql);
		
		List list = session.createSQLQuery(sql).list();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			brokers.add(new Broker(new Long(((BigInteger)objects[0]).intValue()), (String) objects[1],
					(String) objects[2], ((BigDecimal) objects[3]).intValue(),
					((BigDecimal) objects[4]).intValue(),
					((BigDecimal) objects[5]).intValue(),
					(String) objects[6],(String)objects[7])
);
		}
		HibernateUtils.closeSession(session);
		
		return brokers;
	}
	
}
