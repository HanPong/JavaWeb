package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
@Service
public class EmployeeService {
	
	//service����Ҫ����DAO�㣬Ҳ�ǲ���autowired�Զ�װ��
	@Autowired
	EmployeeMapper employeeMapper;
	//��ѯ����Ա��
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}

}
