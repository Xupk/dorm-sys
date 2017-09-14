/**
 * <pre>
 * Copyright:		Copyright(C) 2015-2016, uxunchina.com
 * Filename:		com.sys.dorm.security.service.impl.OrganizationRoleServiceImpl.java
 * Class:			OrganizationRoleServiceImpl
 * Date:			2013-4-15
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
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

import com.sys.dorm.dao.OrganizationRoleDao;
import com.sys.dorm.entity.main.OrganizationRole;
import com.sys.dorm.service.OrganizationRoleService;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  2.0.0
 * @since   2013-4-15 下午4:16:04 
 */
@Service
@Transactional(readOnly=true)
public class OrganizationRoleServiceImpl implements OrganizationRoleService {
	
	private OrganizationRoleDao organizationRoleDao;
	
	/**
	 * 
	 * 构造函数
	 * @param organizationRoleDao
	 */
	@Autowired
	public OrganizationRoleServiceImpl(OrganizationRoleDao organizationRoleDao) {
		this.organizationRoleDao = organizationRoleDao;
	}

	/**   
	 * @param organizationId
	 * @return  
	 * @see com.sys.dorm.service.OrganizationRoleService#find(java.lang.Long)  
	 */
	@Override
	public List<OrganizationRole> find(Long organizationId) {
		return organizationRoleDao.findByOrganizationId(organizationId);
	}

	/**   
	 * @param organizationRole  
	 * @see com.sys.dorm.service.OrganizationRoleService#save(com.sys.dorm.entity.main.OrganizationRole)  
	 */
	@Transactional
	@Override
	public void save(OrganizationRole organizationRole) {
		organizationRoleDao.save(organizationRole);
	}

	/**   
	 * @param organizationRoleId  
	 * @see com.sys.dorm.service.OrganizationRoleService#delete(java.lang.Long)  
	 */
	@Transactional
	@Override
	public void delete(Long organizationRoleId) {
		organizationRoleDao.delete(organizationRoleId);
	}

}
