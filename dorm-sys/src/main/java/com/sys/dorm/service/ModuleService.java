/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.service.ModuleService.java
 * Class:			ModuleService
 * Date:			2015-8-6
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service;

import java.util.List;

import com.sys.dorm.entity.main.Module;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.util.dwz.Page;


/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-6 上午9:32:17 
 */

public interface ModuleService {
	void save(Module module) throws ExistedException;
	
	Module get(Long id);
	
	void update(Module module);
	
	void delete(Long id) throws ServiceException;
	
	Module getTree();
	
	List<Module> findAll();
	
	List<Module> find(Long parentId, Page page);
	
	List<Module> find(Long parentId, String name, Page page);
}
