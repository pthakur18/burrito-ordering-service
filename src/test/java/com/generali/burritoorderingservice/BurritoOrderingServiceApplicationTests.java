package com.generali.burritoorderingservice;

import com.generali.burritoorderingservice.model.*;
import com.generali.burritoorderingservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BurritoOrderingServiceApplicationTests {


	@Autowired
	OrderRepository orderRepo;

	@Test
	public void createOrder(){

		Vegetable vegetable = new Vegetable();
		vegetable.setName("Corn");
		HashSet hs = new HashSet();
		hs.add(vegetable);

		Extras extras = new Extras();
		extras.setName("Avacado");
		HashSet ex = new HashSet();
		ex.add(extras);

		Order order = Order.builder()
				.salsa(Salsa.Medium
				)
				.protein(Protein.Bean)
				.tortilla(Tortilla.Corn)
				.vegetables(hs)
				.extras(ex)
				.build();

		orderRepo.save(order);
		assertNotNull(orderRepo.findById(order.getOrderId()));

	}

	@Test
	public void getOrder(){

		long orderId=1;
		assertNotNull(orderRepo.findById(orderId));

	}

	@Test
	public void getAllOrder(){

		assertNotNull(orderRepo.findAll());

	}
}
