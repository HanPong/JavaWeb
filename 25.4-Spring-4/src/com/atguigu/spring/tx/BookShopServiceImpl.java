package com.atguigu.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {
	@Autowired
	private BookShopDao bookShopDao;
	@Transactional
	@Override
	public void purchase(String username, String isbn) {
		//1.��ȡ��ĵ���
		int price=bookShopDao.findBookPriceByIsbn(isbn);
		//2.������Ŀ��
		bookShopDao.updateBookstock(isbn);
		//3.�����û����
		bookShopDao.updateUserAccount(username, price);
		

	}

}
