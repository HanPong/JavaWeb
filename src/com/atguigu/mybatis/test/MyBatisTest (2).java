package com.atguigu.mybatis.test;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

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
	 * 5��ԭ�ȵ�dao��Ҫдһ��ʵ����daoImpl�����ڵĽӿ�mapper��Ӧһ��xml�ļ�
	 * 6��SqlSession�����ź����ݿ��һ�λỰ���������ر�
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
			//��һ������sql��Ψһ��ʶ���ڶ���������ִ��sqlҪ�õĲ���
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
}
