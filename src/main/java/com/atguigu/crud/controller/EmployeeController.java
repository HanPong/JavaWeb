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
//����Ա����ɾ�Ĳ�Ĺ���
@Controller
public class EmployeeController {
	//autowired�Զ�װ��service���߼����
	@Autowired
	EmployeeService employeeService;
	
	//��json��ʽ��������,ResponseBody���Զ��ذѷ��صĶ�����json�ַ�����ʽ
	@RequestMapping("/emps")
	@ResponseBody//ResponseBodyҪ����ʹ����Ҫ����jackson��
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {//ҳ������ʱҪ֪������ڼ�ҳ������
		PageHelper.startPage(pn, 5);
		List<Employee> emps=employeeService.getAll();
		PageInfo page =new PageInfo(emps,5);
		return Msg.success().add("pageInfo", page);
	}
	
	
	
	
	//����ľ���emps������
	//��ѯԱ�����ݣ���ҳ��ѯ
	//@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		
		
		//�ⲻ��һ����ҳ��ѯ
		//����PageHelper��ҳ���
		//�ڲ�ѯ֮ǰֻ��Ҫ����
		PageHelper.startPage(pn, 5);
		//startPage��������������ѯ����һ����ҳ��ѯ
		List<Employee> emps=employeeService.getAll();
		//ʹ��PageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ��
		//��װ����ϸ�ķ�ҳ��Ϣ������
		PageInfo page =new PageInfo(emps,5);//���5����������ʾ��ҳ��
		model.addAttribute("pageInfo",page);
		return "list";
	}

}
