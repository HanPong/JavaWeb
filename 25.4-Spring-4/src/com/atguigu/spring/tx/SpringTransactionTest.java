package com.atguigu.spring.tx;


import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {
	private ApplicationContext ctx=null;
	private BookShopDao bookShopDao=null;
	private BookShopService bookShopService=null;
	private Cashier cashier=null;
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao=(BookShopDao)ctx.getBean("bookShopDao");
		bookShopService=(BookShopService)ctx.getBean("bookShopService");
		cashier=ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testTranscationPropagation() {
		cashier.checkout("AA", Arrays.asList("1001","1002"));
	}
	
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}	
	
	@Test
	public void testBookShopDaoUpdateBookStock() {
		bookShopDao.updateBookstock("1001");
	}
    @Test
    public void testBookShopDaoUpdateUserAccount() {
    	bookShopDao.updateUserAccount("AA", 100);
    }
    @Test
    public void testBookshopService() {
    	bookShopService.purchase("AA", "1001");
    }
}
