package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
@Service
public class EmployeeService {
	
	//service层需要调用DAO层，也是采用autowired自动装配
	@Autowired
	EmployeeMapper employeeMapper;
	//查询所有员工
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}

}
