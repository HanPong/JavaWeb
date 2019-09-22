package com.atguigu.mybatis.dao;
import java.util.List;
import java.util.Map;

import com.atguigu.mybatis.bean.Employee;
//此接口就是用于查询并封装成Employee对象的
public interface EmployeeMapper {
	//返回一条记录的map，key就是列名，值就是对应的值
	public Map<String, Object> getEmpByIdReturnMap(Integer id);	
	//获取list根据lastname进行模糊查询
	public List<Employee> getEmpsByLastNameLike(String lastName);
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);

}