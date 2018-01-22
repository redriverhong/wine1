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
		//创建配置对象
				Configuration cfg = new Configuration().configure();
				//创建服务配置对象
				ServiceRegistry srg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
				//创建会话工厂对象
				sf = cfg.buildSessionFactory(srg);
	}
	
	//SessionFactory
	public static SessionFactory getSessionFactory(){
		return sf;
	}
	
	//开启Session
	public static Session getSession(){
		session=sf.openSession();
		return session;
	}
	
	//关闭Session
	public static void closeSession(Session session){
		if(session!=null){
			session.close();
		}
	}
}
