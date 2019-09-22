package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapperDynamicSQL {
	
	public List<Employee> getEmpsByConditionIf(Employee employee);
	public List<Employee> getEmpsByConditionChoose(Employee employee);
	

}
