package com.hbrnt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.hbrnt.pojo.Orders;
import com.hbrnt.pojo.Orders_Products;
import com.hbrnt.utl.HibernateUtils;

@Repository
public class OrdersDAO implements IOrdersDAO {
	SessionFactory sf;

	public OrdersDAO() {
		sf = HibernateUtils.getSessionFactory();
	}

	@Override
	public boolean createOrder(Orders order, Orders_Products ord) {
		boolean status = false;
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		try {
			session.save(order);
			session.save(ord);
			session.getTransaction().commit();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean deleteOrder(int orderId) {
		boolean status = false;
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Orders order = (Orders) session.load(Orders.class, orderId);
		if (!order.equals(null)) {
			session.delete(order);
			session.getTransaction().commit();
			status = true;
		}
		session.close();
		return status;
	}

	@Override
	public boolean updateOrder(Orders order) {
		boolean status = false;
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		if (!order.equals(null)) {
			session.beginTransaction();
			session.update(order);
			session.getTransaction().commit();
			status = true;
		}

		session.close();
		return status;
	}

	@Override
	public Orders getOrder(int orderId) {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Orders order = (Orders) session.get(Orders.class, orderId);
		session.getTransaction().commit();
		session.close();
		return order;
	}

}
