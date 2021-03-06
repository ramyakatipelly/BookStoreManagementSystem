package edu.rk.bookstore.test.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.rk.bookstore.dao.OrderDao;
import edu.rk.bookstore.domain.Customer;
import edu.rk.bookstore.domain.Order;
import edu.rk.bookstore.domain.OrderItem;
import edu.rk.bookstore.domain.Product;

@ContextConfiguration("classpath:bookstore-test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderDAOTest {
	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void testOrderCount() {
		int cnt = orderDao.getOrdersCount();
		System.out.println(cnt);
	}

	/* verify that an order and corresponding orderItems are saved properly to database */
	@Test
	public void testSaveOrder(){
		Order order;
		Product product;
		OrderItem orderItem;
		List<OrderItem> oiList;
		product = new Product();
		Customer cust;
		orderItem = new OrderItem();
		oiList = new ArrayList<OrderItem>();
		product.setCatId(1);
		product.setPrice(19.25);
		product.setProdId(1);
		orderItem.setProduct(product);
		orderItem.setQuantity(10);
		oiList.add(orderItem);
		order = new Order();
		order.setOiList(oiList);
		cust = new Customer();
		cust.setId(1);
		cust.setName("JOHN");
		cust.setState("CA");
		order.setCustomer(cust);
		order.setSubtotal(202.54);
		order.setTax(22.5);
		order.setTotal(1200.98);
		
		int oldCnt = orderDao.getOrdersCount();
		orderDao.saveOrder(order);
		int newCnt = orderDao.getOrdersCount();
		assertEquals(oldCnt+1 , newCnt);
	}
	
}
