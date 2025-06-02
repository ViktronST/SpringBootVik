package es.cursojava.springboot.springbootvik.ejercicios.customer.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import es.cursojava.springboot.springbootvik.ejercicios.customer.beans.Customer;

@Service
@Scope("singleton") 
public class RegistrarCustomer {

	public RegistrarCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void registraCustomer (Customer cust){
		System.out.println("Registrando Customer " + cust);
	}
}
