package com.ahfdkun.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.jpa.SpitterRepository;

/**
 * @Description: 借助Hibernate Session实现不依赖与Spring的Repository
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月30日 下午3:26:02
 */
/*@Repository
@Transactional*/
public class HibernateSpitterRepositoryImpl /*implements SpitterRespository*/ {

	public static Logger log = Logger.getLogger(HibernateSpitterRepositoryImpl.class);

	private SessionFactory sessionFactory;

	@Autowired
	public HibernateSpitterRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public int save(Spitter spitter) {
		Serializable id = getSession().save(spitter);
		return ((Long) id).intValue();
	}

	public Spitter findByUsername(String username) {
		List<Spitter> spitters = getSession().createCriteria(Spitter.class).add(Restrictions.eq("username", username)).list();
		if (spitters == null || spitters.isEmpty())
			return null;
		return spitters.get(0);
	}

}
