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

	/*����xml�����ļ�����һ��SqlSessionFactory����,ȫ������
	 * 1������xml�����ļ���ȫ�������ļ�������һ��SqlSessionFactory���� ������ԴһЩ���л�����Ϣ
	 * 2��sqlӳ���ļ���������ÿһ��sql���Լ�sql�ķ�װ����ȡ� 
	 * 3����sqlӳ���ļ�ע����ȫ�������ļ���
	 * 4��д���룺
	 * 		1��������ȫ�������ļ��õ�SqlSessionFactory��
	 * 		2����ʹ��sqlSession��������ȡ��sqlSession����ʹ������ִ����ɾ�Ĳ�
	 * 			һ��sqlSession���Ǵ�������ݿ��һ�λỰ������ر�
	 * 		3����ʹ��sql��Ψһ��־������MyBatisִ���ĸ�sql��sql���Ǳ�����sqlӳ���ļ��еġ�
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
		
		//2.��ȡsqlsessionʵ������ֱ��ִ���Ѿ�ӳ���sql���
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
		//1.��ȡsqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.��ȡsqlSession����
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.��ȡ�ӿڵ�ʵ�������
		//��Ϊ�ӿ��Զ��Ĵ���һ��������󣬴������ȥִ����ɾ�Ĳ�
		try {
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
			Employee employee=mapper.getEmpById(1);
			System.out.println(employee);
	}finally {
		openSession.close();
	   }
	}
	
	
	/*������ɾ��
	 * 1.mybatis������ɾ��ֱ�Ӷ����������ͷ���ֵ
	 * 	Integer��Long��Boolean
	 * 2.������Ҫ�ֶ��ύ����
	 * sqlSessionFactory.openSession()==>�ֶ��ύ
	 * sqlSessionFactory.openSession(true)==>�Զ��ύ
	 * */
	@Test
	public void test03() throws IOException {
		//1.��ȡsqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.��ȡsqlSession����
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.��ȡ�ӿڵ�ʵ�������
		//��Ϊ�ӿ��Զ��Ĵ���һ��������󣬴������ȥִ����ɾ�Ĳ�
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
		//1.��ȡsqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.��ȡsqlSession����
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.��ȡ�ӿڵ�ʵ�������
		//��Ϊ�ӿ��Զ��Ĵ���һ��������󣬴������ȥִ����ɾ�Ĳ�
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
		//1.��ȡsqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.��ȡsqlSession����
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.��ȡ�ӿڵ�ʵ�������
		//��Ϊ�ӿ��Զ��Ĵ���һ��������󣬴������ȥִ����ɾ�Ĳ�
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
		//1.��ȡsqlSessionFactory
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//2.��ȡsqlSession����
		SqlSession openSession=sqlSessionFactory.openSession();
		//3.��ȡ�ӿڵ�ʵ�������
		//��Ϊ�ӿ��Զ��Ĵ���һ��������󣬴������ȥִ����ɾ�Ĳ�
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



