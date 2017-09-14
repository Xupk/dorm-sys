/**
 * <pre>
 * Copyright:		Copyright(C) 2015-2016, uxunchina.com
 * Filename:		com.sys.dorm.security.dao.PermissionDao.java
 * Class:			PermissionDao
 * Date:			2013-4-16
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sys.dorm.entity.main.Permission;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:10:16 
 */

public interface PermissionDao extends JpaRepository<Permission, Long> {

}
