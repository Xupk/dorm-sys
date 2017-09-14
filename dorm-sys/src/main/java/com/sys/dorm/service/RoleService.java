/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.service.RoleService.java
 * Class:			RoleService
 * Date:			2015-8-7
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.Role;
import com.sys.dorm.util.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-7 下午5:04:05 
 */

public interface RoleService {
	
	List<Role> find(Page page, String name);

	void save(Role role);

	Role get(Long id);

	void update(Role role);

	void delete(Long id);

	List<Role> findAll(Page page);
}
