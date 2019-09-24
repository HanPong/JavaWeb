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

//测试DAO层的工作
/*尝试使用spring的单元测试，自动注入
 * 1.导入SpringTest模块
 * 2.@ContextConfiguration指定spring配置文件的位置
 * 3.直接autowired要使用的组件即可
 * 
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	//测试DepartmentMapper
	@Autowired
	DepartmentMapper departmentMapper;
	//自动注入mapper
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD() {
		//1.创建SpringIOC容器
		//ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从容器中获取mapper
		//DepartmentMapper departmentMapper=ioc.getBean(DepartmentMapper.class);
		System.out.println(departmentMapper);
		//1.插入几个部门
		//departmentMapper.insertSelective(new Department(null,"KaifaBu"));
		//departmentMapper.insertSelective(new Department(null,"CeshiBu"));
		
		//2.生成员工数据,测试员工插入
		System.out.println(employeeMapper);
		//employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@atguigu.com",1));
		
		//3.批量插入多个员工
		//可以传入一个集合，也可以传入一个批量操作的sqlSession
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<1000;i++)
		{   
			String uid=UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null,uid,"M",uid+"@atguigu.com",1));
		}
		System.out.println("批量完成！");

		
	}


}
