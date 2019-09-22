package com.atguigu.mybatis.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.EmployeeMapperDynamicSQL;
import com.atguigu.mybatis.dao.EmployeeMapperPlus;

public class MyBatisTest {

	/*根据xml配置文件创建一个SqlSessionFactory对象,全局配置
	 * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
	 * 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。 
	 * 3、将sql映射文件注册在全局配置文件中
	 * 4、写代码：
	 * 		1）、根据全局配置文件得到SqlSessionFactory；
	 * 		2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
	 * 			一个sqlSession就是代表和数据库的一次会话，用完关闭
	 * 		3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
	 * 
	 * */
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void test() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.获取sqlsession实例，能直接执行已经映射的sql语句
		SqlSession openSession=sqlSessionFactory.openSession();
		try {
			Employee employee=openSession.selectOne("com.atguigu.mybatis.EmployeeMapper.selectEmp", 1);
			System.out.println(employee);}
		finally {
			openSession.close();
		}
	}
	@Test
	public void test01() throws IOException {
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.获取sqlSession对象
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.获取接口的实现类对象
		//会为接口自动的创建一个代理对象，代理对象去执行增删改查
		try {
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
			Employee employee=mapper.getEmpById(1);
			System.out.println(employee);
	}finally {
		openSession.close();
	   }
	}
	
	
	/*测试增删改
	 * 1.mybatis允许增删改直接定义以下类型返回值
	 * 	Integer，Long，Boolean
	 * 2.我们需要手动提交数据
	 * sqlSessionFactory.openSession()==>手动提交
	 * sqlSessionFactory.openSession(true)==>自动提交
	 * */
	@Test
	public void test03() throws IOException {
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.获取sqlSession对象
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.获取接口的实现类对象
		//会为接口自动的创建一个代理对象，代理对象去执行增删改查
		try {
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
			
			Employee employee=new Employee(null, "Jerry", "jerry@atguigu","1");
			mapper.addEmp(employee);
			openSession.commit();
	}finally {
		openSession.close();
	   }
	}
	@Test
	public void test04() throws IOException {
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.获取sqlSession对象
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.获取接口的实现类对象
		//会为接口自动的创建一个代理对象，代理对象去执行增删改查
		try {
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
			List<Employee> like=mapper.getEmpsByLastNameLike("%e%");
			for(Employee employee:like) {
				System.out.println(employee);
			}
			System.out.println("++++++++++++++++++++++++");
			Map<String, Object> map =mapper.getEmpByIdReturnMap(1);
			System.out.println(map);
			openSession.commit();
	}finally {
		openSession.close();
	   }
	}
	
	@Test
	public void test05() throws IOException {
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.获取sqlSession对象
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.获取接口的实现类对象
		//会为接口自动的创建一个代理对象，代理对象去执行增删改查
		try {
			EmployeeMapperPlus mapper=openSession.getMapper(EmployeeMapperPlus.class);
			/*Employee empById=mapper.getEmpById(1);
			System.out.println(empById);*/
			Employee empAndDept=mapper.getEmpAndDept(1);
			System.out.println(empAndDept);
			System.out.println(empAndDept.getDept());
			openSession.commit();
	}finally {
		openSession.close();
	   }
	}
	@Test
	public void test06() throws IOException {
		//1.获取sqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.获取sqlSession对象
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.获取接口的实现类对象
		//会为接口自动的创建一个代理对象，代理对象去执行增删改查
		try {
			EmployeeMapperDynamicSQL mapper=openSession.getMapper(EmployeeMapperDynamicSQL.class);
			Employee employee=new Employee(null, "tom", null, null);
			/*List<Employee> emps=mapper.getEmpsByConditionIf(employee);*/
			List<Employee> emps=mapper.getEmpsByConditionChoose(employee);
			
		
			for(Employee emp:emps) {
				System.out.println(emp);
			}
			openSession.commit();
	}finally {
		openSession.close();
	   }
	}
	
	}



