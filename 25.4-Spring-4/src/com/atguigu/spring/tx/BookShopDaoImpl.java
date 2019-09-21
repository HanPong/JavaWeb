package com.atguigu.spring.tx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	@Override
	public int findBookPriceByIsbn(String isbn) {
		String sql="select price from book where isbn=?";
		return jdbctemplate.queryForObject(sql, Integer.class,isbn);
	}

	@Override
	public void updateBookstock(String isbn) {
		//检查书的库存是否足够，若不够则抛出异常
		String sql2="select stock from book_stock where isbn=?";
		int stock=jdbctemplate.queryForObject(sql2,Integer.class,isbn);
		if(stock==0) {
			throw new BookStockException("库存不足");
		}
		String sql="update book_stock set stock = stock -1 where isbn=?";
		jdbctemplate.update(sql,isbn);

	}

	@Override
	public void updateUserAccount(String username, int price) {
		String sql="update account set balance = balance -? where username = ?";
		jdbctemplate.update(sql,price,username);
	}

}
