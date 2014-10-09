package cn.juke.admin.daoimpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import cn.juke.admin.dao.DealDao;
import cn.juke.bean.Deal;
import cn.juke.util.HibernateUtils;
import cn.juke.util.Page;

public class DealDaoImpl extends GenericHibernateDao<Deal> implements DealDao {
	public DealDaoImpl() {
		super(Deal.class);

	}

	public List<Deal> search(Page page) {
		List<Deal> deals = new ArrayList<Deal>();

		Session session = HibernateUtils.getSession();

		String sql1 = "select a.id,b.name as bname,d.name as dname,a.house_type,c.name as cname,a.deal_time,a.money,a.commision,cstate from deal a,customer b,broker c,house d"
				+ " where a.customer_id=b.id and a.broker_id=c.id and a.house_id = d.id ";

		page.setTotalCount(session.createSQLQuery(sql1).list().size());

		int first = (page.getPageIndex() - 1) * page.getPageSize();

		String sql = "select a.id,b.name as bname,d.name as dname,a.house_type,c.name as cname,a.deal_time,a.money,a.commision,cstate from deal a,customer b,broker c,house d"
				+ " where a.customer_id=b.id and a.broker_id=c.id and a.house_id = d.id limit "
				+ first + " ," + page.getPageSize();

		List list = session.createSQLQuery(sql).list();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Deal db = new Deal(new Long(((BigInteger) objects[0]).intValue()),
					(String) objects[1], (String) objects[2],
					(Integer) objects[3], (String) objects[4],
					(String) objects[5], (Double) objects[6],
					(Double) objects[7], (String) objects[8]);
			db.setHouse_type_name();
			deals.add(db);
		}
		HibernateUtils.closeSession(session);

		return deals;
	}

	public List<Deal> search(Page page, String state) {
		List<Deal> deals = new ArrayList<Deal>();

		Session session = HibernateUtils.getSession();

		String sql1 = "select a.id as aid,b.name as bname,d.name as dname,a.house_type,c.name as cname,a.deal_time,a.money,a.commision,cstate from deal a,customer b,broker c,house d"
				+ " where a.customer_id=b.id and a.broker_id=c.id and a.house_id = d.id  and a.cstate = '"
				+ state + "'";

		page.setTotalCount(session.createSQLQuery(sql1).list().size());

		int first = (page.getPageIndex() - 1) * page.getPageSize();

		String sql = "select a.id as aid,b.name as bname,d.name as dname,a.house_type,c.name as cname,a.deal_time,a.money,a.commision,cstate from deal a,customer b,broker c,house d"
				+ " where a.customer_id=b.id and a.broker_id=c.id and a.house_id = d.id  and a.cstate = '"
				+ state + "' limit " + +first + " ," + page.getPageSize();

		List list = session.createSQLQuery(sql).list();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Deal db = new Deal(new Long(((BigInteger) objects[0]).intValue()),
					(String) objects[1], (String) objects[2],
					(Integer) objects[3], (String) objects[4],
					(String) objects[5], (Double) objects[6],
					(Double) objects[7], (String) objects[8]);
		
			db.setHouse_type_name();
			deals.add(db);
		}
		HibernateUtils.closeSession(session);

		return deals;
	}

	@Override
	public List<Deal> search(Page page, String state, Long comid) {
		List<Deal> deals = new ArrayList<Deal>();

		Session session = HibernateUtils.getSession();

		String sql1 = "select a.id as aid,b.name as bname,d.name as dname,a.house_type,c.name as cname,a.deal_time,a.money,a.commision,cstate from deal a,customer b,broker c,house d"
				+ " where a.customer_id=b.id and a.broker_id=c.id and a.house_id = d.id  and a.cstate = '"
				+ state + "' and a.comid = " + comid;

		page.setTotalCount(session.createSQLQuery(sql1).list().size());

		int first = (page.getPageIndex() - 1) * page.getPageSize();

		String sql = "select a.id as aid,b.name as bname,d.name as dname,a.house_type,c.name as cname,a.deal_time,a.money,a.commision,cstate from deal a,customer b,broker c,house d"
				+ " where a.customer_id=b.id and a.broker_id=c.id and a.house_id = d.id  and a.cstate = '"
				+ state
				+ "' and a.comid = "
				+ comid
				+ " limit "
				+ +first
				+ " ," + page.getPageSize();

		List list = session.createSQLQuery(sql).list();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Deal db = new Deal(new Long(((BigInteger) objects[0]).intValue()),
					(String) objects[1], (String) objects[2],
					(Integer) objects[3], (String) objects[4],
					(String) objects[5], (Double) objects[6],
					(Double) objects[7], (String) objects[8]);
			db.setHouse_type_name();
			deals.add(db);
		}
		HibernateUtils.closeSession(session);

		return deals;
	}

	@Override
	public List<Deal> search(Long comid, Page page) {
		List<Deal> deals = new ArrayList<Deal>();

		Session session = HibernateUtils.getSession();

		String sql1 = "select a.id as aid,b.name as bname,d.name as dname,a.house_type,c.name as cname,a.deal_time,a.money,a.commision,cstate from deal a,customer b,broker c,house d"
				+ " where a.customer_id=b.id and a.broker_id=c.id and a.house_id = d.id and a.comid = "
				+ comid;

		page.setTotalCount(session.createSQLQuery(sql1).list().size());

		int first = (page.getPageIndex() - 1) * page.getPageSize();

		String sql = "select a.id as aid,b.name as bname,d.name as dname,a.house_type,c.name as cname,a.deal_time,a.money,a.commision,cstate from deal a,customer b,broker c,house d"
				+ " where a.customer_id=b.id and a.broker_id=c.id and a.house_id = d.id  and a.comid = "
				+ comid + " limit " + +first + " ," + page.getPageSize();

		List list = session.createSQLQuery(sql).list();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Deal db = new Deal(new Long(((BigInteger) objects[0]).intValue()),
					(String) objects[1], (String) objects[2],
					(Integer) objects[3], (String) objects[4],
					(String) objects[5], (Double) objects[6],
					(Double) objects[7], (String) objects[8]);
		
			db.setHouse_type_name();
			deals.add(db);
		}
		HibernateUtils.closeSession(session);
		return deals;
	}
	
	public List<Deal> searchByBroker(Long broker_id,Page page){
		List<Deal> deals = new ArrayList<Deal>();

		Session session = HibernateUtils.getSession();

		String sql1 = "select b.id as bid,a.name as aname,d.name as dname,b.house_type as house_type,c.name as cname,b.status," +
				"b.money,b.commision,b.create_time as ctime,b.deal_time,b.cstate,b.dealer " +
				" from deal b inner join  broker a on a.id=b.broker_id left join customer c  on  b.customer_id=c.id left join house d on b.house_id=d.id"
				+ " where a.id = "+broker_id;
		
		page.setTotalCount(session.createSQLQuery(sql1).list().size());

		int first = (page.getPageIndex() - 1) * page.getPageSize();

		String sql =  "select b.id as bid,a.name as aname,d.name as dname,b.house_type as house_type,c.name as cname,b.status," +
				"b.money,b.commision,b.create_time as ctime,b.deal_time,b.cstate,b.dealer " +
				" from deal b inner join  broker a on a.id=b.broker_id left join customer c  on  b.customer_id=c.id left join house d on b.house_id=d.id"
				+ " where a.id = "+broker_id + " limit " + +first + " ," + page.getPageSize();
		

		List list = session.createSQLQuery(sql).list();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			Deal db = new Deal(new Long(((BigInteger) objects[0]).intValue()),
					(String) objects[1], (String) objects[2],
					(Integer) objects[3], (String) objects[4],
					(Integer) objects[5], (Double) objects[6],
					(Double) objects[7], (String) objects[8],(String)objects[9],(String)objects[10],(String)objects[11]);
		   
			db.setHouse_type_name();
			db.setStatus_name();
			db.setCstate_name();
			
			deals.add(db);
		}
		HibernateUtils.closeSession(session);
		return deals;
	}
}
