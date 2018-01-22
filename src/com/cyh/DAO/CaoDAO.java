package com.cyh.DAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cyh.domain.Cao;

/**
 * A data access object (DAO) providing persistence and search support for Cao
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cyh.domain.Cao
 * @author MyEclipse Persistence Tools
 */
public class CaoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CaoDAO.class);

	public void save(Cao transientInstance) {
		log.debug("saving Cao instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			
			throw re;
		}
	}

	public void delete(Cao persistentInstance) {
		log.debug("deleting Cao instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cao findById(java.lang.Integer id) {
		log.debug("getting Cao instance with id: " + id);
		try {
			Cao instance = (Cao) getSession().get("com.cyh.domain.Cao", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cao> findByExample(Cao instance) {
		log.debug("finding Cao instance by example");
		try {
			List<Cao> results = (List<Cao>) getSession()
					.createCriteria("com.cyh.domain.Cao").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cao instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cao as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Cao instances");
		try {
			String queryString = "from Cao";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public Cao findByLogin(Cao cao){
		try {
			String queryString = "from Cao c where c.userName = ? and c.password = ?";
			cao = (Cao) getSession().createQuery(queryString)
					.setParameter(0, cao.getUserName())
					.setParameter(1, cao.getPassword())
					.uniqueResult();
			return cao;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}

	public Cao merge(Cao detachedInstance) {
		log.debug("merging Cao instance");
		try {
			Cao result = (Cao) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cao instance) {
		log.debug("attaching dirty Cao instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cao instance) {
		log.debug("attaching clean Cao instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}