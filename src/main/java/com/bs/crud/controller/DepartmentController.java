package com.bs.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bs.crud.bean.Department;
import com.bs.crud.bean.Msg;
import com.bs.crud.service.DepartmentService;

/**
 * 澶勭悊鍜岄儴闂ㄦ湁鍏崇殑璇锋眰
 * @author lfy
 *
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 杩斿洖鎵�鏈夌殑閮ㄩ棬淇℃伅
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		//鏌ュ嚭鐨勬墍鏈夐儴闂ㄤ俊鎭�
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}

}
