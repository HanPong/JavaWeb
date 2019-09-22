package com.atguigu.mybatis.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;
//此接口就是用于查询并封装成Employee对象的
public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
	//public Employee getEmpByIdAndLastName(Integer id,String lastName);
	public Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
    //public Employee getEmpByMap(Map<String, Object> map);
	public List<Employee> getEmpsByLastNameLike(String lastName);//返回一个list
	public Map<String, Object> getEmpsByIdReturnMap(Integer id);//返回一条记录的map，key就是列名，值就是对应的值
	
	@MapKey("id")//告诉mybatis封装成map的时候哪个作为map的key
	public Map<String, Employee> getEmpsByLastNameLikeReturnMap(String lastName);
	// 返回多条记录的map，键是这条记录的主键，值是记录封装后的javabean

}
