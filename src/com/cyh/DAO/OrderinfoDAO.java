package com.cyh.DAO;

import com.cyh.domain.Orderinfo;
import com.cyh.domain.Orderq;

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
 * Orderinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cyh.domain.Orderinfo
 * @author MyEclipse Persistence Tools
 */
public class OrderinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OrderinfoDAO.class);
	// property constants
	public static final String ORDER_COUNT = "orderCount";

	public void save(Orderinfo transientInstance) {
		System.out.println("orderCount="+ORDER_COUNT);
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		log.debug("saving Orderinfo instance");
		try {
			session.save(transientInstance);
			tx.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			tx.commit();
			throw re;
		}finally{
			session.close();
		}
	}

	public void delete(Orderinfo persistentInstance) {
		log.debug("deleting Orderinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Orderinfo findById(java.lang.Integer id) {
		log.debug("getting Orderinfo instance with id: " + id);
		try {
			Orderinfo instance = (Orderinfo) getSession().get(
					"com.cyh.domain.Orderinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Orderinfo> findByExample(Orderinfo instance) {
		log.debug("finding Orderinfo instance by example");
		try {
			List<Orderinfo> results = (List<Orderinfo>) getSession()
					.createCriteria("com.cyh.domain.Orderinfo")
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
		log.debug("finding Orderinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Orderinfo> findByOrderCount(Object orderCount) {
		return findByProperty(ORDER_COUNT, orderCount);
	}

	public List findAll() {
		log.debug("finding all Orderinfo instances");
		try {
			String queryString = "from Orderinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderinfo merge(Orderinfo detachedInstance) {
		log.debug("merging Orderinfo instance");
		try {
			Orderinfo result = (Orderinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderinfo instance) {
		log.debug("attaching dirty Orderinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderinfo instance) {
		log.debug("attaching clean Orderinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List<Orderinfo> findByOrderId(Long orderid){
		
		System.out.println("888888888"+orderid);
		log.debug("getting userid instance with id: " + orderid);
		try {
			String sql="from Orderinfo where orderq.orderId=?";
			List<Orderinfo> list=getSession().createQuery(sql).setLong(0, orderid).list();
			System.out.println("orderqlist="+list.size());
			
			return list;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	public void saveOrder(Long orderid,int wineid,int cartcount){
		Session session =getSession();
		Transaction tx = session.beginTransaction();
	}
}