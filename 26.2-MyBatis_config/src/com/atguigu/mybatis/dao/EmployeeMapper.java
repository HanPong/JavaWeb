package com.atguigu.mybatis.dao;
import com.atguigu.mybatis.bean.Employee;
//�˽ӿھ������ڲ�ѯ����װ��Employee�����
public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);

}
