package com.atguigu.mybatis.dao;
import com.atguigu.mybatis.bean.Employee;
//此接口就是用于查询并封装成Employee对象的
public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);

}
