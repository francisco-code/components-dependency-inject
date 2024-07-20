package com.franciscode.components;

import com.franciscode.components.entities.OrderEntity;
import com.franciscode.components.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ComponentsApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ComponentsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter order code: ");
			int code = sc.nextInt();

			System.out.print("Enter basic amount: ");
			double basic = sc.nextDouble();

			System.out.print("Enter discount percentage: ");
			double discount = sc.nextDouble();

			OrderEntity orderEntity = new OrderEntity(code, basic, discount);

			double total = orderService.total(orderEntity);
			System.out.println("Pedido código " + code);
			System.out.printf("Valor total: R$ %.2f%n", total);
		}
	}
}
