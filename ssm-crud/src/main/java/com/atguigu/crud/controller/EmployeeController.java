package com.atguigu.crud.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
//处理员工增删改查的功能
@Controller
public class EmployeeController {
	//autowired自动装配service层逻辑组件
	@Autowired
	EmployeeService employeeService;
	
	//用json形式返回数据,ResponseBody能自动地把返回的对象变成json字符串形式
	@RequestMapping("/emps")
	@ResponseBody//ResponseBody要正常使用需要导入jackson包
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {//页面请求时要知道请求第几页的数据
		PageHelper.startPage(pn, 5);
		List<Employee> emps=employeeService.getAll();
		PageInfo page =new PageInfo(emps,5);
		return Msg.success().add("pageInfo", page);
	}
	
	
	
	
	//处理的就是emps的请求
	//查询员工数据，分页查询
	//@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		
		
		//这不是一个分页查询
		//引入PageHelper分页插件
		//在查询之前只需要调用
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的这个查询就是一个分页查询
		List<Employee> emps=employeeService.getAll();
		//使用PageInfo包装查询后的结果，只需要将pageInfo交给页面
		//封装了详细的分页信息和数据
		PageInfo page =new PageInfo(emps,5);//这个5代表连续显示的页数
		model.addAttribute("pageInfo",page);
		return "list";
	}

}
