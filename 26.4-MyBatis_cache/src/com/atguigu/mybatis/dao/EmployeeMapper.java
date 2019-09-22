package com.atguigu.mybatis.dao;
import java.util.List;
import java.util.Map;

import com.atguigu.mybatis.bean.Employee;
//�˽ӿھ������ڲ�ѯ����װ��Employee�����
public interface EmployeeMapper {
	//����һ����¼��map��key����������ֵ���Ƕ�Ӧ��ֵ
	public Map<String, Object> getEmpByIdReturnMap(Integer id);	
	//��ȡlist����lastname����ģ����ѯ
	public List<Employee> getEmpsByLastNameLike(String lastName);
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);

}