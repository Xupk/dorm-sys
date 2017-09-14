/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.controller.CacheManageController.java
 * Class:			CacheManageController
 * Date:			2015-9-14
 * Author:			<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.sys.dorm.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sys.dorm.service.CacheService;
import com.sys.dorm.util.dwz.AjaxObject;

/** 
 * 	
 * @author 	<a href="mailto:xupk@uxunchina.com">xupk</a>
 * Version  1.1.0
 * @since   2015-9-14 上午11:08:15 
 */
@Controller
@RequestMapping("/management/security/cacheManage")
public class CacheManageController {
	@Autowired
	private CacheService cacheService;
	
	private static final String INDEX = "management/security/cacheManage/index";
	
	@RequiresPermissions("CacheManage:view")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index() {
		return INDEX;
	}
	
	@RequiresPermissions("CacheManage:edit")
	@RequestMapping(value="/clear", method=RequestMethod.POST)
	public @ResponseBody String clear() {
		cacheService.clearAllCache();
		
		AjaxObject ajaxObject = new AjaxObject("清除缓存成功！");
		ajaxObject.setCallbackType("");
		return ajaxObject.toString();
	}
}
