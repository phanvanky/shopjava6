package com.example.shopjava6.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.shopjava6.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

	@Query("select o from Order o where o.account.username=?1 order by o.id desc")
	List<Order> findByUser(String username);

	@Query(value = "select * from Orders where createdate >=?1 and createdate<=?2 and status like ?3"
			+ " order by id desc",nativeQuery = true)
	List<Order> findByDate(String from, String to, String status);

}
