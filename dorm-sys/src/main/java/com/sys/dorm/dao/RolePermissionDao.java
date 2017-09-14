/**
 * <pre>
 * Copyright:		Copyright(C) 2015-2016, uxunchina.com
 * Filename:		com.sys.dorm.security.dao.RolePermissionDao.java
 * Class:			RolePermissionDao
 * Date:			2013-4-16
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.dorm.entity.main.RolePermission;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:10:57 
 */

public interface RolePermissionDao extends JpaRepository<RolePermission, Long> {
	List<RolePermission> findByRoleId(Long roleId);
}
