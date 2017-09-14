/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.controller                              
 */
package com.sys.dorm.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.beanvalidator.BeanValidators;

import com.sys.dorm.entity.main.User;
import com.sys.dorm.entity.main.Violation;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.ViolationService;
import com.sys.dorm.util.dwz.AjaxObject;
import com.sys.dorm.util.dwz.Page;

/**
 * <p>
 * <b>Title: </b>ViolationController.java
 * <p>
 * <b>Description: </b>TODO
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年4月23日 Xupk 创建类 <br>
 * 
 */

@Controller
@RequestMapping("/management/security/violation")
public class ViolationController {

	@Autowired
	private Validator validator;

	@Autowired
	private ViolationService violationService;

	private static final String CREATE = "management/security/violation/create";
	private static final String UPDATE = "management/security/violation/update";
	private static final String LIST = "management/security/violation/list";

	@RequiresPermissions("Violation:view")
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String list(Page page, String keywords, Map<String, Object> map) {
		List<Violation> violations;
		if (StringUtils.isNotBlank(keywords)) {
			violations = violationService.find(page, keywords);
		} else {
			violations = violationService.findAll(page);
		}

		map.put("page", page);
		map.put("violations", violations);
		map.put("keywords", keywords);
		return LIST;
	}

	@RequiresPermissions("Violation:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String preCreate() {
		return CREATE;
	}

	@RequiresPermissions("Violation:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	String create(Violation violation) {
		BeanValidators.validateWithException(validator, violation);

		try {
			violationService.save(violation);
		} catch (ExistedException e) {
			AjaxObject ajaxObject = new AjaxObject(e.getMessage());
			ajaxObject.setCallbackType("");
			ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_FAILURE);
			return ajaxObject.toString();
		}
		return AjaxObject.newOk("添加记录成功！").toString();
	}

	@ModelAttribute("preloadViolation")
	public Violation getOne(
			@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			Violation violation = violationService.get(id);
			return violation;
		}
		return null;
	}

	@RequiresPermissions("Violation:edit")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Violation violation = violationService.get(id);

		map.put("violation", violation);
		return UPDATE;
	}

	@RequiresPermissions("Violation:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	String update(@ModelAttribute("preloadViolation") Violation violation) {
		BeanValidators.validateWithException(validator, violation);
		violationService.update(violation);

		return AjaxObject.newOk("修改记录成功！").toString();
	}

	@RequiresPermissions("Violation:delete")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody
	String delete(@PathVariable Long id) {
		AjaxObject ajaxObject = new AjaxObject("删除记录成功！");
		try {
			violationService.delete(id);
		} catch (ServiceException e) {
			ajaxObject.setMessage(e.getMessage());
		}

		ajaxObject.setCallbackType("");
		return ajaxObject.toString();
	}

	@RequiresPermissions("Violation:reset")
	@RequestMapping(value = "/reset/status/{id}", method = RequestMethod.POST)
	public @ResponseBody
	String reset(@PathVariable Long id) {
		Violation violation = violationService.get(id);
		AjaxObject ajaxObject = new AjaxObject();
		if (violation.getStatus().equals("enabled")) {
			violation.setStatus("disabled");
		} else {
			violation.setStatus("enabled");
		}

		ajaxObject.setMessage("修改状态成功，当前为"
				+ (violation.getStatus().equals("enabled") ? "未处理" : "已处理"));

		violationService.update(violation);
		ajaxObject.setCallbackType("");
		return ajaxObject.toString();
	}

}
