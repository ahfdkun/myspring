package com.ahfdkun.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ahfdkun.repository.SpitterSweeper;

/**
 * @Description: 借助Hibernate Session实现不依赖与Spring的Repository
 * 
 * @author: yakun.zhao
 * 
 * @date: 2017年6月30日 下午3:26:02
 */
@Repository
@Transactional
public class SpitterRepositoryImpl implements SpitterSweeper {

	public static Logger log = Logger.getLogger(SpitterRepositoryImpl.class);

	@PersistenceContext
	EntityManager em;
	
	@Override
	public int slitSweep() {
		String update = "UPDATE Spitter SET firstName='Elite' WHERE username='ahfdkun1'";
		return em.createQuery(update).executeUpdate();
	}

}
