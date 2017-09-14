/**
 * @Copyright:           Copyright© 2009-2016 UXUNCHINA
 * @Company:             深圳市优讯信息技术有限公司
 * @Project:             dorm-sys
 * @see                  com.sys.dorm.controller                              
 */
package com.sys.dorm.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
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

import com.sys.dorm.entity.main.Room;
import com.sys.dorm.entity.main.Student;
import com.sys.dorm.exception.ExistedException;
import com.sys.dorm.exception.ServiceException;
import com.sys.dorm.service.RoomService;
import com.sys.dorm.service.StudentService;
import com.sys.dorm.util.dwz.AjaxObject;
import com.sys.dorm.util.dwz.Page;

/**
 * <p>
 * <b>Title: </b>RoomController.java
 * <p>
 * <b>Description: </b>房间管理Controller
 * 
 * @author Xupk
 * @version V1.0
 *          <p>
 *          2016年4月7日 Xupk 创建类 <br>
 * 
 */

@Controller
@RequestMapping("/management/security/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private Validator validator;

	private static final String CREATE = "management/security/student/create";
	private static final String UPDATE = "management/security/student/update";
	private static final String LIST = "management/security/student/list";
	private static final String LOOK_ROOM = "management/security/student/lookup_room";

	@RequiresPermissions("Student:view")
	@RequestMapping(value = "/list", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String list(Page page, String keywords, Map<String, Object> map) {
		List<Student> students;
		if (StringUtils.isNotBlank(keywords)) {
			students = studentService.find(page, keywords);
		} else {
			students = studentService.findAll(page);
		}
		map.put("page", page);
		map.put("students", students);
		map.put("keywords", keywords);
		return LIST;
	}

	@RequiresPermissions("Student:save")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String preCreate() {
		return CREATE;
	}

	@RequiresPermissions("Student:save")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public @ResponseBody
	String create(Student student) {
		BeanValidators.validateWithException(validator, student);
		try {
			studentService.save(student);
			return AjaxObject.newOk("入住成功！").toString();
		} catch (ExistedException e) {
			AjaxObject ajaxObject = new AjaxObject(e.getMessage());
			ajaxObject.setCallbackType("");
			ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_FAILURE);
			return ajaxObject.toString();
		}
	}

	@RequiresPermissions(value = { "Student:edit", "Student:save" }, logical = Logical.OR)
	@RequestMapping(value = "/lookup2room", method = { RequestMethod.GET })
	public String lookup(Map<String, Object> map) {

		List<Room> rooms = roomService.findAll();
		map.put("rooms", rooms);
		return LOOK_ROOM;
	}

	@ModelAttribute("preloadStudent")
	public Student getOne(@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			Student student = studentService.get(id);
			return student;
		}
		return null;
	}

	@RequiresPermissions("Student:edit")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Student student = studentService.get(id);

		map.put("student", student);
		return UPDATE;
	}

	@RequiresPermissions("Student:edit")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	String update(@ModelAttribute("preloadStudent") Student student) {
		BeanValidators.validateWithException(validator, student);
		studentService.update(student);
		return AjaxObject.newOk("修改成功！").toString();
	}

	@RequiresPermissions("Student:delete")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody
	String delete(@PathVariable Long id) {
		AjaxObject ajaxObject = new AjaxObject("退宿成功！");
		studentService.delete(id);

		ajaxObject.setCallbackType("");
		return ajaxObject.toString();
	}
}