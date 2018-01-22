package com.cyh.DAO;

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
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cyh.domain.User
 * @author MyEclipse Persistence Tools
 */
public class UserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASS_WORD = "passWord";
	public static final String PHOTO = "photo";
	public static final String PHONE = "phone";
	public static final String ADDRESS = "address";
	public static final String USER_TYPE = "userType";
	public static final String BALANCE = "balance";
	public static final String YOUBIAN = "youbian";
	public static final String TRUE_NAME = "trueName";

	public void save(User u) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		HibernateUtil.closeSession(session);
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getSession().get("com.cyh.domain.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<User> findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List<User> results = (List<User>) getSession()
					.createCriteria("com.cyh.domain.User")
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
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<User> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}
	public List<User> findByTrueName(Object trueName) {
		return findByProperty(TRUE_NAME, trueName);
	}
	public List<User> findByPassWord(Object passWord) {
		return findByProperty(PASS_WORD, passWord);
	}

	public List<User> findByPhoto(Object photo) {
		return findByProperty(PHOTO, photo);
	}

	public List<User> findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List<User> findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List<User> findByUserType(Object userType) {
		return findByProperty(USER_TYPE, userType);
	}

	public List<User> findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}
	public List<User> findByYoubian(Object youbian) {
		return findByProperty(YOUBIAN, youbian);
	}


	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public User findByLogin(User user){
		try {
			String queryString = "from User u where u.userName = ? and u.passWord = ?";
			user = (User) getSession().createQuery(queryString)
					.setParameter(0, user.getUserName())
					.setParameter(1, user.getPassWord())
					.uniqueResult();
			return user;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
		
	}
	
	public void update(String address,int youbian,int phone,int userid) {
		String hql="update User u set u.address=? , u.youbian=? , u.phone=? where userid=?";
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.createQuery(hql).setString(0, address)
		.setInteger(1, youbian)
		.setInteger(2, phone)
		.setInteger(3, userid)
		.executeUpdate();
		tx.commit();
		
		HibernateUtil.closeSession(session);
	}
}