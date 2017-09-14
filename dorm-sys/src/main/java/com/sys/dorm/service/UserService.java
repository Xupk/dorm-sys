/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.service.UserService.java
 * Class:			UserService
 * Date:			2015-8-7
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.User;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.util.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-7 下午3:03:59 
 */

public interface UserService {
	
	User get(String username);
	
	List<User> find(Page page, String name);

	void update(User user);

	void save(User user) throws ExistedException;

	User get(Long id);

	void delete(Long id) throws ServiceException;

	List<User> findAll(Page page);
	
	List<User> findByOrgId(Long orgId);
}
