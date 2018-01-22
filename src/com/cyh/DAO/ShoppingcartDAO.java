package com.cyh.DAO;

import com.cyh.domain.Shoppingcart;
import com.cyh.domain.User;
import com.cyh.util.HibernateUtil;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Shoppingcart entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cyh.domain.Shoppingcart
 * @author MyEclipse Persistence Tools
 */
public class ShoppingcartDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ShoppingcartDAO.class);
	// property constants
	public static final String CART_COUNT = "cartCount";

	public void save(Shoppingcart sc) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(sc);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	public void delete(Shoppingcart persistentInstance) {
		Session session =getSession();
		Transaction tx = session.beginTransaction();

		log.debug("deleting Shoppingcart instance");
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

	public Shoppingcart findById(java.lang.Integer id) {
		Session session =getSession();
		Transaction tx = session.beginTransaction();

		log.debug("getting Shoppingcart instance with id: " + id);
		try {
			Shoppingcart instance = (Shoppingcart) session.get(
					"com.cyh.domain.Shoppingcart", id);
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

	public List<Shoppingcart> findByExample(Shoppingcart instance) {
		log.debug("finding Shoppingcart instance by example");
		try {
			List<Shoppingcart> results = (List<Shoppingcart>) getSession()
					.createCriteria("com.cyh.domain.Shoppingcart")
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
		log.debug("finding Shoppingcart instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Shoppingcart as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Shoppingcart> findByCartCount(Object cartCount) {
		return findByProperty(CART_COUNT, cartCount);
	}

	public List findAll() {
		log.debug("finding all Shoppingcart instances");
		try {
			String queryString = "from Shoppingcart";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shoppingcart merge(Shoppingcart detachedInstance) {
		log.debug("merging Shoppingcart instance");
		try {
			Shoppingcart result = (Shoppingcart) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shoppingcart instance) {
		log.debug("attaching dirty Shoppingcart instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shoppingcart instance) {
		log.debug("attaching clean Shoppingcart instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List<Shoppingcart> findByUserId(User user){
		log.debug("finding all Cartinfo instances");
		try {
			String queryString = "from Shoppingcart where user.userId=?";
			System.out.println("userId="+user.getUserId());
			List<Shoppingcart> list = getSession().createQuery(queryString).setInteger(0, user.getUserId()).list();
			System.out.println(list.size());
			return list;
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List<Shoppingcart> findByUserId1(int id){
		log.debug("finding all Cartinfo instances");
		try {
			String queryString = "from Shoppingcart where user.userId=? order by cartId desc";
			System.out.println("userId="+id);
			List<Shoppingcart> list = getSession().createQuery(queryString).setInteger(0, id).list();
			System.out.println(list.size());
			return list;
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void updateCart(int id,int count){
		log.debug("finding all Cartinfo instances");
		try {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String queryString = "update Shoppingcart sc set sc.cartCount=? where sc.cartId=?";
		System.out.println("CartId="+id);
		session.createQuery(queryString).setInteger(0, count).setInteger(1, id).executeUpdate();
		tx.commit();
		HibernateUtil.closeSession(session);
		
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public void delete1(Integer cartId) {
		String queryString ="from Shoppingcart where cartId=?";
		System.out.println("delete    delete"+cartId);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.createQuery(queryString).setInteger(0, cartId).executeUpdate();
		tx.commit();
		HibernateUtil.closeSession(session);
		System.out.println("delete    delete   delete  "+cartId);
	}
	public void deleteByuserid(int userid) {
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		String sql="delete Shoppingcart sc where sc.user.userId=?";
		log.debug("deleting Shoppingcart instance");
		try {
			session.createQuery(sql).setInteger(0, userid).executeUpdate();
			System.out.println("******delete*****");
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
   
   
   

}