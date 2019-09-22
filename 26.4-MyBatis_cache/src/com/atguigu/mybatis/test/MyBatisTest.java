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
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	/*������������
	 * һ�����棨���ػ��棩�������ݿ�ͬһ�λỰ�ڼ��ѯ�������ݻ���ڱ��ػ�����
	 * �Ժ������Ҫ��ȡ��ͬ�����ݣ�ֱ�Ӵӻ����л�ȡ��û��Ҫ��ȥ�����ݿ�
	 * sqlSssion����Ļ��棬һ��������һֱ������
	 * */
	public void testFirstLevelCache() throws IOException {
		SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
		SqlSession opensession=sqlSessionFactory.openSession();
		try {
			EmployeeMapper mapper=opensession.getMapper(EmployeeMapper.class);
			
		}finally {
			
		}
		
		
	}
	

	
	}



