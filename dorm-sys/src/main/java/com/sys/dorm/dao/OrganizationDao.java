/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.dao.OrganizationDao.java
 * Class:			OrganizationDao
 * Date:			2015-8-27
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.sys.dorm.entity.main.Organization;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-27 下午3:55:47 
 */

public interface OrganizationDao extends JpaRepository<Organization, Long>{
	Page<Organization> findByParentId(Long parentId, Pageable pageable);
	
	Page<Organization> findByParentIdAndNameContaining(Long parentId, String name, Pageable pageable);
	
	@QueryHints(value={
			@QueryHint(name="org.hibernate.cacheable",value="true"),
			@QueryHint(name="org.hibernate.cacheRegion",value="com.sys.dorm.entity.main")
		}
	)
	@Query("from Organization")
	List<Organization> findAllWithCache();
}
