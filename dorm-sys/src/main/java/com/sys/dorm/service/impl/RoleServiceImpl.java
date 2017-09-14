/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.service.impl.RoleServiceImpl.java
 * Class:			RoleServiceImpl
 * Date:			2015-8-7
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dorm.dao.RoleDao;
import com.sys.dorm.entity.main.Role;
import com.sys.dorm.service.RoleService;
import com.sys.dorm.shiro.ShiroDbRealm;
import com.sys.dorm.util.dwz.Page;
import com.sys.dorm.util.dwz.PageUtils;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  1.1.0
 * @since   2015-8-7 下午5:04:52 
 */
@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	
	@Autowired(required = false)
	private ShiroDbRealm shiroRealm;
	
	@Transactional
	@Override
	public void save(Role role) {
		roleDao.save(role);
	}

	@Override
	public Role get(Long id) {
		return roleDao.findOne(id);
	}
	
	@Override
	public List<Role> findAll(Page page) {
		org.springframework.data.domain.Page<Role> springDataPage = roleDao.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	/**   
	 * @param role  
	 * @see com.sys.dorm.service.RoleService#update(com.sys.dorm.entity.main.Role)  
	 */
	@Transactional
	public void update(Role role) {
		roleDao.save(role);
		shiroRealm.clearAllCachedAuthorizationInfo();
	}

	/**   
	 * @param id  
	 * @see com.sys.dorm.service.RoleService#delete(java.lang.Long)  
	 */
	@Transactional
	public void delete(Long id) {
		roleDao.delete(id);
		shiroRealm.clearAllCachedAuthorizationInfo();
	}

	/**   
	 * @param page
	 * @param name
	 * @return  
	 * @see com.sys.dorm.service.RoleService#find(com.sys.dorm.util.dwz.Page, java.lang.String)  
	 */
	public List<Role> find(Page page, String name) {
		org.springframework.data.domain.Page<Role> springDataPage = 
				(org.springframework.data.domain.Page<Role>)roleDao.findByNameContaining(name, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

}
