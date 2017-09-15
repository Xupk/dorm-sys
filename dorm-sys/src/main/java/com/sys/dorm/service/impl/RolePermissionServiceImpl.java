/**
 * <pre>
 * Copyright:		Copyright(C) 2015-2016, uxunchina.com
 * Filename:		com.sys.dorm.security.service.impl.RolePermissionServiceImpl.java
 * Class:			RolePermissionServiceImpl
 * Date:			2013-4-16
 * Author:			<a href="mailto:211450675@qq.com">xupk</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dorm.dao.RolePermissionDao;
import com.sys.dorm.entity.main.RolePermission;
import com.sys.dorm.service.RolePermissionService;

/** 
 * 	
 * @author 	<a href="mailto:211450675@qq.com">xupk</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:14:10 
 */
@Service
@Transactional(readOnly=true)
public class RolePermissionServiceImpl implements RolePermissionService {
	
	@Autowired
	private RolePermissionDao rolePermissionDao;

	/**   
	 * @param rolePermission  
	 * @see com.sys.dorm.service.RolePermissionService#save(com.sys.dorm.entity.main.RolePermission)  
	 */
	@Transactional
	@Override
	public void save(RolePermission rolePermission) {
		rolePermissionDao.save(rolePermission);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.sys.dorm.service.RolePermissionService#get(java.lang.Long)  
	 */
	@Override
	public RolePermission get(Long id) {
		return rolePermissionDao.findOne(id);
	}

	/**   
	 * @param rolePermission  
	 * @see com.sys.dorm.service.RolePermissionService#update(com.sys.dorm.entity.main.RolePermission)  
	 */
	@Transactional
	@Override
	public void update(RolePermission rolePermission) {
		rolePermissionDao.save(rolePermission);
	}

	/**   
	 * @param id  
	 * @see com.sys.dorm.service.RolePermissionService#delete(java.lang.Long)  
	 */
	@Transactional
	@Override
	public void delete(Long id) {
		rolePermissionDao.delete(id);
	}

	/**   
	 * @param roleId
	 * @return  
	 * @see com.sys.dorm.service.RolePermissionService#findByRoleId(java.lang.Long)  
	 */
	@Override
	public List<RolePermission> findByRoleId(Long roleId) {
		return rolePermissionDao.findByRoleId(roleId);
	}

}
