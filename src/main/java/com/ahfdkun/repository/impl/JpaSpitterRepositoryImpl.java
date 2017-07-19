package com.ahfdkun.repository.impl;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ahfdkun.domain.Spitter;
import com.ahfdkun.repository.SpitterRespository;

/**
 * @Description: 不使用Spring模版的JPA Repository
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月30日 下午3:26:02
 */
@Repository
@Transactional
public class JpaSpitterRepositoryImpl implements SpitterRespository {

	public static Logger log = Logger.getLogger(JpaSpitterRepositoryImpl.class);

	@PersistenceUnit
	private EntityManagerFactory emf; // 注入EntityManagerFactory

	@Override
	public int save(Spitter spitter) {
		emf.createEntityManager().persist(spitter);
		return 0;
	}

	@Override
	public Spitter findByUsername(String username) {
		Query query = emf.createEntityManager().createQuery("select p from Spitter p where p.username=?1", Spitter.class);
		query.setParameter(1, username);
		List<Spitter> spitters = query.getResultList();
		if (spitters == null || spitters.isEmpty())
			return null;
		return spitters.get(0);
	}

}
