package com.cyh.DAO;

import com.cyh.domain.Orderq;
import com.cyh.domain.Shoppingcart;
import com.cyh.util.HibernateUtil;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Orderq entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cyh.domain.Orderq
 * @author MyEclipse Persistence Tools
 */
public class OrderqDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(OrderqDAO.class);
	// property constants
	public static final String UNAME = "uname";
	public static final String PAYORNO = "payorno";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String YOUBIAN = "youbian";

	public void save(Orderq transientInstance) {
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		log.debug("saving Orderq instance");
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

	public void delete(Orderq persistentInstance) {
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		log.debug("deleting Orderq instance");
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

	public Orderq findById(java.lang.Long id) {
//		Session session =getSession();
//		Transaction tx = session.beginTransaction();
		log.debug("getting Orderq instance with id: " + id);
		try {
			Orderq instance = (Orderq)getSession().get(
					"com.cyh.domain.Orderq", id);
//			tx.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
//			tx.commit();
			throw re;
		}
//		finally{
//			session.close();
//		}
	}

	public List<Orderq> findByExample(Orderq instance) {
		log.debug("finding Orderq instance by example");
		try {
			List<Orderq> results = (List<Orderq>) getSession()
					.createCriteria("com.cyh.domain.Orderq")
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
		log.debug("finding Orderq instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Orderq as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Orderq> findByUname(Object uname) {
		return findByProperty(UNAME, uname);
	}

	public List<Orderq> findByPayorno(Object payorno) {
		return findByProperty(PAYORNO, payorno);
	}

	public List<Orderq> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<Orderq> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<Orderq> findByYoubian(Object youbian) {
		return findByProperty(YOUBIAN, youbian);
	}

	public List findAll() {
		log.debug("finding all Orderq instances");
		try {
			String queryString = "from Orderq";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Orderq merge(Orderq detachedInstance) {
		log.debug("merging Orderq instance");
		try {
			Orderq result = (Orderq) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Orderq instance) {
		log.debug("attaching dirty Orderq instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Orderq instance) {
		log.debug("attaching clean Orderq instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public Orderq findByUserId(int userid){
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		String sql="from Orderq oq where oq.user.userId=? and payorno=?";
		System.out.println("7777"+userid);
		log.debug("getting userid instance with id: " + userid);
		try {
			Orderq orderq=(Orderq) session.createQuery(sql).setInteger(0, userid).setInteger(1, 0).uniqueResult();
			tx.commit();
			System.out.println("orderqlist=");
			return orderq;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			tx.commit();
			throw re;
		}finally{
			session.close();
		}
	}
	
	public void updateOrderq(Long orderId,String uname,String address,int phone,int youbian){
		log.debug("finding all Cartinfo instances");
		try {
			
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String queryString = "update Orderq oq set oq.uname=? , oq.address=? , oq.phone=? , oq.youbian=? where oq.orderId=?";
		System.out.println("orderId="+orderId+"uname="+uname+"address"+address+"phone"+phone);
		session.createQuery(queryString).setString(0, uname)
		.setString(1, address).setInteger(2, phone)
		.setInteger(3, youbian).setLong(4, orderId).executeUpdate();
		tx.commit();	
		session.close();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public void updateById(Long orderId){
		log.debug("finding all Cartinfo instances");
		try {
			Session session = HibernateUtil.getSession();
			Transaction tx = session.beginTransaction();
			String queryString = "update Orderq oq set oq.payorno=? where oq.orderId=?";
			session.createQuery(queryString).setInteger(0, 1).setLong(1, orderId).executeUpdate();
			tx.commit();
			session.close();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Orderq> findByUserId1(int userid){
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		String sql="from Orderq oq where oq.user.userId=? and payorno=?";
		System.out.println("7777"+userid);
		log.debug("getting userid instance with id: " + userid);
		try {
			List<Orderq> list=session.createQuery(sql).setInteger(0, userid).setInteger(1, 1).list();
			tx.commit();
			System.out.println("orderqlist=");
			return list;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			tx.commit();
			throw re;
		}finally{
			session.close();
		}
	}
	public List<Orderq> findByUserId2(int userid){
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		String sql="from Orderq oq where oq.user.userId=? order by oq.orderId desc";
		System.out.println("7777"+userid);
		log.debug("getting userid instance with id: " + userid);
		try {
			List<Orderq> list=session.createQuery(sql).setInteger(0, userid).list();
			tx.commit();
			System.out.println("orderqlist=");
			return list;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			tx.commit();
			throw re;
		}finally{
			session.close();
		}
	}
	
	public void delete1(int orderid) {
		String hql="from Orderq oq where oq.orderId=?";
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		log.debug("saving Orderq instance");
		try {
			session.createQuery(hql).setInteger(0, orderid).executeUpdate();
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
	
	public Orderq findById2(java.lang.Long id) {
		Session session =getSession();
		Transaction tx = session.beginTransaction();
		log.debug("getting Orderq instance with id: " + id);
		try {
			Orderq instance = (Orderq)session.get(
					"com.cyh.domain.Orderq", id);
			tx.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			tx.commit();
			throw re;
		}
		finally{
			session.close();
		}
	}
	
}