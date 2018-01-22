package com.cyh.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sf;
	private static Session session;

	static {
		//�������ö���
				Configuration cfg = new Configuration().configure();
				//�����������ö���
				ServiceRegistry srg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
				//�����Ự��������
				sf = cfg.buildSessionFactory(srg);
	}
	
	//SessionFactory
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	
	//����Session
	public static Session getSession(){
		session=sf.openSession();
		return session;
	}
	
	//�ر�Session
	public static void closeSession(Session session){
		if(session!=null){
			session.close();
		}
	}
}
