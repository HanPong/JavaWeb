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
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);//�����EmployeeMapperҲ��һ����
			Employee employee=mapper.getEmpById(1);
			System.out.println(employee);
	}finally {
		openSession.close();
	   }
	}
	@Test
	public void test03() throws IOException {
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		//1.��Ϊ����������ӻ�ȡ����Sqlsession�����Զ��ύ����
		SqlSession openSession=sqlSessionFactory.openSession();
		//SqlSession openSession=sqlSessionFactory.openSession(true);����Ϊ�Զ��ύ
		
		try {
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
			//1.�������
			/*Employee employee=new Employee(null,"jerry","jerry@atguigu.com","1");
			mapper.addEmp(employee);
			System.out.println("�ò���������IDΪ"+employee.getId());*/
			//2.�����޸�
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
		//1.��Ϊ����������ӻ�ȡ����Sqlsession�����Զ��ύ����
		SqlSession openSession=sqlSessionFactory.openSession();
		//SqlSession openSession=sqlSessionFactory.openSession(true);����Ϊ�Զ��ύ
		
		try {
			EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
			//���Է���list
			/*List<Employee> like=mapper.getEmpsByLastNameLike("%e%");
			for(Employee employee:like) {
				System.out.println(employee);
			}*/
			//���Է���map
			Map<String,Object> map=mapper.getEmpsByIdReturnMap(1);
			System.out.println(map);
			System.out.println("-------------------------�ָ���--------------------------");
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
	public void test06() throws IOException {//�������ϲ�ѯ����ѯ������
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		SqlSession openSession=sqlSessionFactory.openSession();
		try {
			EmployeeMapperPlus mapper=openSession.getMapper(EmployeeMapperPlus.class);
			Employee employee=mapper.getEmpAndDept(1);
			System.out.println(employee);//toString����û��ͬ�������Բ�����ʾ������Ϣ
			System.out.println(employee.getDept());
			
			openSession.commit();
			
		}finally {
			openSession.close();
		}
		
	}
}











