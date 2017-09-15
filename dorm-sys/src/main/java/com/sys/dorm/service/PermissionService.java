/**
 * <pre>
 * Copyright:		Copyright(C) 2015-2016, uxunchina.com
 * Filename:		com.sys.dorm.security.service.PermissionService.java
 * Class:			PermissionService
 * Date:			2013-4-16
 * Author:			<a href="mailto:211450675@qq.com">xupk</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service;

import com.sys.dorm.entity.main.Permission;

/** 
 * 	
 * @author 	<a href="mailto:211450675@qq.com">xupk</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:11:41 
 */

public interface PermissionService {
	
	void save(Permission permission);
	
	Permission get(Long id);
	
	void update(Permission permission);
	
	void delete(Long id);
}
