/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.service.OrganizationService.java
 * Class:			OrganizationService
 * Date:			2015-8-27
 * Author:			<a href="mailto:211450675@qq.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.Organization;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.util.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:211450675@qq.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-27 下午3:56:25 
 */

public interface OrganizationService {
	
	List<Organization> find(Long parentId, Page page);
	
	List<Organization> find(Long parentId, String name, Page page);
	
	Organization getTree();

	void save(Organization organization);

	Organization get(Long id);

	void update(Organization organization);

	void delete(Long id) throws ServiceException;
}
