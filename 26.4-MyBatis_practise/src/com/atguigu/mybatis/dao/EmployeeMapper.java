package com.atguigu.mybatis.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;
//�˽ӿھ������ڲ�ѯ����װ��Employee�����
public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
	//public Employee getEmpByIdAndLastName(Integer id,String lastName);
	public Employee getEmpByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);
    //public Employee getEmpByMap(Map<String, Object> map);
	public List<Employee> getEmpsByLastNameLike(String lastName);//����һ��list
	public Map<String, Object> getEmpsByIdReturnMap(Integer id);//����һ����¼��map��key����������ֵ���Ƕ�Ӧ��ֵ
	
	@MapKey("id")//����mybatis��װ��map��ʱ���ĸ���Ϊmap��key
	public Map<String, Employee> getEmpsByLastNameLikeReturnMap(String lastName);
	// ���ض�����¼��map������������¼��������ֵ�Ǽ�¼��װ���javabean

}
