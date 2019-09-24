package com.atguigu.crud.test;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;

//����DAO��Ĺ���
/*����ʹ��spring�ĵ�Ԫ���ԣ��Զ�ע��
 * 1.����SpringTestģ��
 * 2.@ContextConfigurationָ��spring�����ļ���λ��
 * 3.ֱ��autowiredҪʹ�õ��������
 * 
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	//����DepartmentMapper
	@Autowired
	DepartmentMapper departmentMapper;
	//�Զ�ע��mapper
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD() {
		//1.����SpringIOC����
		//ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.�������л�ȡmapper
		//DepartmentMapper departmentMapper=ioc.getBean(DepartmentMapper.class);
		System.out.println(departmentMapper);
		//1.���뼸������
		//departmentMapper.insertSelective(new Department(null,"KaifaBu"));
		//departmentMapper.insertSelective(new Department(null,"CeshiBu"));
		
		//2.����Ա������,����Ա������
		System.out.println(employeeMapper);
		//employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@atguigu.com",1));
		
		//3.����������Ա��
		//���Դ���һ�����ϣ�Ҳ���Դ���һ������������sqlSession
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++)
		{   
			String uid=UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@atguigu.com",1));
		}
		System.out.println("������ɣ�");

		
	}


}
