package com.atguigu.spring.tx;

public interface BookShopDao {
	//������Ż�ȡ��ĵ���
	public int findBookPriceByIsbn(String isbn);
	//������Ŀ�棬ʹ��Ŷ�Ӧ�Ŀ��-1
	public void updateBookstock(String isbn);
	//�����û������
	public void updateUserAccount(String username,int price);

}
