/**
 * <pre>
 * Copyright:		Copyright(C) 2015-2016, uxunchina.com
 * Filename:		com.sys.dorm.security.service.impl.RolePermissionImpl.java
 * Class:			RolePermissionImpl
 * Date:			2013-4-16
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dorm.dao.PermissionDao;
import com.sys.dorm.entity.main.Permission;
import com.sys.dorm.service.PermissionService;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:12:41 
 */
@Service
@Transactional(readOnly=true)
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionDao permissionDao;

	/**   
	 * @param permission  
	 * @see com.sys.dorm.service.PermissionService#save(com.sys.dorm.entity.main.Permission)  
	 */
	@Transactional
	@Override
	public void save(Permission permission) {
		permissionDao.save(permission);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.sys.dorm.service.PermissionService#get(java.lang.Long)  
	 */
	@Override
	public Permission get(Long id) {
		return permissionDao.findOne(id);
	}

	/**   
	 * @param permission  
	 * @see com.sys.dorm.service.PermissionService#update(com.sys.dorm.entity.main.Permission)  
	 */
	@Transactional
	@Override
	public void update(Permission permission) {
		permissionDao.save(permission);
	}

	/**   
	 * @param id  
	 * @see com.sys.dorm.service.PermissionService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		permissionDao.delete(id);
	}
}
