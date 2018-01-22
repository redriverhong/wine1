package com.cyh.DAO;

import com.cyh.domain.Collectwine;
import com.cyh.domain.Shoppingcart;
import com.cyh.domain.User;
import com.cyh.util.HibernateUtil;

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
 * Collectwine entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cyh.domain.Collectwine
 * @author MyEclipse Persistence Tools
 */
public class CollectwineDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CollectwineDAO.class);

	// property constants

	public void save(Collectwine cw) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(cw);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	public void delete(Collectwine persistentInstance) {
			Session session =getSession();
			Transaction tx = session.beginTransaction();

			log.debug("deleting Collectwine instance");
			try {
				session.delete(persistentInstance);
				tx.commit();

				log.debug("delete successful");
			} catch (RuntimeException re) {
				log.error("delete failed", re);
				tx.commit();

				throw re;
			}finally{
				session.close();
			}

	}

	public Collectwine findById(java.lang.Integer id) {
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		log.debug("getting Collectwine instance with id: " + id);
		try {
			Collectwine instance = (Collectwine) session.get(
					"com.cyh.domain.Collectwine", id);
			tx.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			tx.commit();
			throw re;
		}finally{
			session.close();
		}
	}

	public List<Collectwine> findByExample(Collectwine instance) {
		log.debug("finding Collectwine instance by example");
		try {
			List<Collectwine> results = (List<Collectwine>) getSession()
					.createCriteria("com.cyh.domain.Collectwine")
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
		log.debug("finding Collectwine instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Collectwine as model where model."
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
		log.debug("finding all Collectwine instances");
		try {
			String queryString = "from Collectwine";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Collectwine merge(Collectwine detachedInstance) {
		log.debug("merging Collectwine instance");
		try {
			Collectwine result = (Collectwine) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Collectwine instance) {
		log.debug("attaching dirty Collectwine instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Collectwine instance) {
		log.debug("attaching clean Collectwine instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List<Collectwine> findByUser(User user){
		log.debug("finding all Cartinfo instances");
		try {
			String queryString = "from Collectwine where user.userId=?";
			System.out.println("userId="+user.getUserId());
			List<Collectwine> list = getSession().createQuery(queryString).setInteger(0, user.getUserId()).list();
			System.out.println(list.size());
			return list;
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Collectwine> findByUserId(int userid){
		log.debug("finding all Cartinfo instances");
		try {
			String queryString = "from Collectwine where user.userId=? order by collectId desc";
			System.out.println("userId="+userid);
			List<Collectwine> list = getSession().createQuery(queryString).setInteger(0, userid).list();
			System.out.println(list.size());
			return list;
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}