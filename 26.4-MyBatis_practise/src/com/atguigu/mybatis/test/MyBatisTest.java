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
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);//这里的EmployeeMapper也是一个类
			Employee employee=mapper.getEmpById(1);
			System.out.println(employee);
	}finally {
		openSession.close();
	   }
	}
	@Test
	public void test03() throws IOException {
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//1.因为下面这个句子获取到的Sqlsession不会自动提交数据
		SqlSession openSession=sqlSessionFactory.openSession();
		//SqlSession openSession=sqlSessionFactory.openSession(true);设置为自动提交
		
		try {
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
			//1.测试添加
			/*Employee employee=new Employee(null,"jerry","jerry@atguigu.com","1");
			mapper.addEmp(employee);
			System.out.println("该操作自增的ID为"+employee.getId());*/
			//2.测试修改
			/*Employee employee=new Employee(1,"HanFayoo","kanhou98@gmail.com","1");
			mapper.updateEmp(employee);*/
			Employee employee=mapper.getEmpByIdAndLastName(1,"HanFayoo");
			System.out.println(employee);
			
			openSession.commit();
			
		}finally {
			openSession.close();
		}
		
	}
	@Test
	public void test04() throws IOException {
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//1.因为下面这个句子获取到的Sqlsession不会自动提交数据
		SqlSession openSession=sqlSessionFactory.openSession();
		//SqlSession openSession=sqlSessionFactory.openSession(true);设置为自动提交
		
		try {
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
			//测试返回list
			/*List<Employee> like=mapper.getEmpsByLastNameLike("%e%");
			for(Employee employee:like) {
				System.out.println(employee);
			}*/
			//测试返回map
			Map<String,Object> map=mapper.getEmpsByIdReturnMap(1);
			System.out.println(map);
			System.out.println("-------------------------分割线--------------------------");
			Map<String,Employee> map1=mapper.getEmpsByLastNameLikeReturnMap("%e%");
			System.out.println(map1);

			
			openSession.commit();
			
		}finally {
			openSession.close();
		}
		
	}
	@Test
	public void test05() throws IOException {
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		SqlSession openSession=sqlSessionFactory.openSession();
		try {
			EmployeeMapperPlus mapper=openSession.getMapper(EmployeeMapperPlus.class);
			Employee employee=mapper.getEmpById(1);
			System.out.println(employee);
			
			openSession.commit();
			
		}finally {
			openSession.close();
		}
		
	}
	@Test
	public void test06() throws IOException {//测试联合查询，查询两个表
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		SqlSession openSession=sqlSessionFactory.openSession();
		try {
			EmployeeMapperPlus mapper=openSession.getMapper(EmployeeMapperPlus.class);
			Employee employee=mapper.getEmpAndDept(1);
			System.out.println(employee);//toString这里没有同步，所以不会显示部门信息
			System.out.println(employee.getDept());
			
			openSession.commit();
			
		}finally {
			openSession.close();
		}
		
	}
}











