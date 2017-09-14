/**
 * <pre>
 * Copyright:		Copyright(C) 2015-2016, uxunchina.com
 * Filename:		com.sys.dorm.security.service.RolePermission.java
 * Class:			RolePermission
 * Date:			2013-4-16
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.RolePermission;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:11:48 
 */

public interface RolePermissionService {
	void save(RolePermission rolePermission);
	
	RolePermission get(Long id);
	
	void update(RolePermission rolePermission);
	
	void delete(Long id);

	List<RolePermission> findByRoleId(Long roleId);
}
