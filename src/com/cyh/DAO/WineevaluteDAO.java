package com.cyh.DAO;

import com.cyh.DAO.BaseHibernateDAO;
import com.cyh.domain.Wineevalute;
import com.cyh.util.HibernateUtil;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Wineevalute entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cyh.domain.Wineevalute
 * @author MyEclipse Persistence Tools
 */
public class WineevaluteDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(WineevaluteDAO.class);
	// property constants
	public static final String EVALUTE = "evalute";
	public static final String EORNO = "eorno";

	public void save(Wineevalute we) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(we);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	public void delete(Wineevalute persistentInstance) {
		log.debug("deleting Wineevalute instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Wineevalute findById(java.lang.Integer id) {
		log.debug("getting Wineevalute instance with id: " + id);
		try {
			Wineevalute instance = (Wineevalute) getSession().get(
					"com.cyh.domain.Wineevalute", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Wineevalute> findByExample(Wineevalute instance) {
		log.debug("finding Wineevalute instance by example");
		try {
			List<Wineevalute> results = (List<Wineevalute>) getSession()
					.createCriteria("com.cyh.domain.Wineevalute")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Wineevalute instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Wineevalute as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Wineevalute> findByEvalute(Object evalute) {
		return findByProperty(EVALUTE, evalute);
	}

	public List<Wineevalute> findByEorno(Object eorno) {
		return findByProperty(EORNO, eorno);
	}

	public List findAll() {
		log.debug("finding all Wineevalute instances");
		try {
			String queryString = "from Wineevalute";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Wineevalute merge(Wineevalute detachedInstance) {
		log.debug("merging Wineevalute instance");
		try {
			Wineevalute result = (Wineevalute) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Wineevalute instance) {
		log.debug("attaching dirty Wineevalute instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Wineevalute instance) {
		log.debug("attaching clean Wineevalute instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
public List<Wineevalute> findByWineId(int wineid) {
		
		String hql="from Wineevalute we where we.wine.wineId=? and we.eorno=?";
		log.debug("merging Wineevalute instance");
		try {
			List<Wineevalute> list = getSession().createQuery(hql).setInteger(0, wineid).setString(1, "1").list();
			System.out.println("ggggggggggggggggggggggg"+list.size());
			log.debug("merge successful");
			return list;
		} catch (RuntimeException re) {
			
			log.error("merge failed", re);
			throw re;
		}
	}

	 public List<Wineevalute> findByUserId(int userid) {
			
			String hql="from Wineevalute we where we.user.userId=? and we.eorno=? order by we.evaluteId desc";
			log.debug("merging Wineevalute instance");
			try {
				List<Wineevalute> list = getSession().createQuery(hql).setInteger(0, userid).setString(1, "0").list();
				System.out.println("lllllllllist="+list.size());
				log.debug("merge successful");
				return list;
			} catch (RuntimeException re) {
				
				log.error("merge failed", re);
				throw re;
				
			}
		}
	 public void updateEvalute(Date date,String eorno,String evalute,int evaluteid){
		 String hql="update Wineevalute we set we.date=? , we.eorno=? , we.evalute=? where we.evaluteId=?";
		 Session session = HibernateUtil.getSession();
		 Transaction tx = session.beginTransaction();
		 session.createQuery(hql).setDate(0, date).setString(1, eorno).setString(2, evalute).setInteger(3, evaluteid).executeUpdate();
		 tx.commit();
		 session.close();
	 }
}