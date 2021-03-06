/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.dao.UserRoleDao.java
 * Class:			UserRoleDao
 * Date:			2015-8-7
 * Author:			<a href="mailto:211450675@qq.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.dorm.entity.main.UserRole;

/** 
 * 	
 * @author 	<a href="mailto:211450675@qq.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-7 下午5:08:15 
 */

public interface UserRoleDao extends JpaRepository<UserRole, Long> {
	List<UserRole> findByUserId(Long userId);
}
