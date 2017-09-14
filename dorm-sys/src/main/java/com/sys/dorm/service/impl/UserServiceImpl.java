/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.service.impl.UserServiceImpl.java
 * Class:			UserServiceImpl
 * Date:			2015-8-7
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/

package com.sys.dorm.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sys.dorm.dao.UserDao;
import com.sys.dorm.entity.main.User;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.UserService;
import com.sys.dorm.shiro.ShiroDbRealm;
import com.sys.dorm.shiro.ShiroDbRealm.HashPassword;
import com.sys.dorm.util.dwz.Page;
import com.sys.dorm.util.dwz.PageUtils;

/**
 * 
 * @author <a href="mailto:xupk@uxunchina.com">xupk</a> Version 1.1.0
 * @since 2015-8-7 下午3:14:29
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	private UserDao userDao;

	@Autowired
	private ShiroDbRealm shiroRealm;

	/**
	 * 构造函数
	 * 
	 * @param jpaRepository
	 */
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User get(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public List<User> findAll(Page page) {
		org.springframework.data.domain.Page<User> springDataPage = userDao
				.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	@Override
	public List<User> findByOrgId(Long orgId) {
		
		List<User> users = null;
		
		users = userDao.findByOrganizationId(orgId);
		
		return users;
	};

	/**
	 * 
	 * @param user
	 * @throws ExistedException
	 * @see com.sys.dorm.service.UserService#save(com.sys.dorm.entity.main.User)
	 */
	@Transactional
	public void save(User user) throws ExistedException {
		if (userDao.findByUsername(user.getUsername()) != null) {
			throw new ExistedException("用户添加失败，登录名：" + user.getUsername()
					+ "已存在。");
		}

		if (userDao.findByRealname(user.getRealname()) != null) {
			throw new ExistedException("用户添加失败，真实名：" + user.getRealname()
					+ "已存在。");
		}

		// 设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash
		if (StringUtils.isNotBlank(user.getPlainPassword())
				&& shiroRealm != null) {
			HashPassword hashPassword = shiroRealm.encrypt(user
					.getPlainPassword());
			user.setSalt(hashPassword.salt);
			user.setPassword(hashPassword.password);
		}

		userDao.save(user);
		shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
	}

	/**
	 * @param user
	 * @see com.sys.dorm.service.UserService#update(com.sys.dorm.entity.main.User)
	 */
	@Transactional
	public void update(User user) {
		// if (isSupervisor(user.getId())) {
		// logger.warn("操作员{},尝试修改超级管理员用户",
		// SecurityUtils.getSubject().getPrincipal());
		// throw new ServiceException("不能修改超级管理员用户");
		// }
		// 设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash

		if (StringUtils.isNotBlank(user.getPlainPassword())
				&& shiroRealm != null) {
			HashPassword hashPassword = shiroRealm.encrypt(user
					.getPlainPassword());
			user.setSalt(hashPassword.salt);
			user.setPassword(hashPassword.password);
		}

		userDao.save(user);
		shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
	}

	/**
	 * @param id
	 * @see com.sys.dorm.service.UserService#delete(java.lang.Long)
	 */
	@Transactional
	public void delete(Long id) throws ServiceException {
		if (isSupervisor(id)) {
			logger.warn("操作员{}，尝试删除超级管理员用户", SecurityUtils.getSubject()
					.getPrincipal() + "。");
			throw new ServiceException("不能删除超级管理员用户。");
		}
		userDao.delete(id);
	}

	/**
	 * @param username
	 * @return
	 * @see com.sys.dorm.service.UserService#get(java.lang.String)
	 */
	public User get(String username) {
		return userDao.findByUsername(username);
	}

	/**
	 * @param page
	 * @param name
	 * @return
	 * @see com.sys.dorm.service.UserService#find(com.sys.dorm.util.dwz.Page,
	 *      java.lang.String)
	 */
	public List<User> find(Page page, String name) {
		org.springframework.data.domain.Page<User> springDataPage = userDao
				.findByUsernameContaining(name, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	/**
	 * 判断是否超级管理员.
	 */
	private boolean isSupervisor(Long id) {
		return id == 1;
	}
}
