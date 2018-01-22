package com.cyh.DAO;


import org.hibernate.Session;

import com.cyh.util.HibernateUtil;


/**
 * Data access object (DAO) for domain model
 * @author MyEclipse Persistence Tools
 */
public class BaseHibernateDAO implements IBaseHibernateDAO {
	
	public Session getSession() {
		return HibernateUtil.getSession();
	}
	
}