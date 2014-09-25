package cn.juke.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateUtils {
	private static SessionFactory factory;
	private static HibernateTemplate ht;
	static {
		try {
			AnnotationConfiguration con = new AnnotationConfiguration();
			factory = con.configure().buildSessionFactory();
			ht = new HibernateTemplate(factory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Session getSession() {
		return factory.openSession();
	}

	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	public static SessionFactory getSessionFactory() {
		return factory;
	}

	public static HibernateTemplate getHibernateTemplate() {
		return ht;
	}
	public static void main(String[] args) {
		HibernateUtils.getHibernateTemplate();
	}
}
