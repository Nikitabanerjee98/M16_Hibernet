package com.cg.association;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class Test {

	public static void main(String[] args) {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("JPA-PU");
			EntityManager em=factory.createEntityManager();
			em.getTransaction().begin();
				
		
				Employee emp=new Employee();
				emp.setName("Umesh");
				em.persist(emp);
			
				Address adr=new Address ();
				adr.setAddressId(1);
				adr.setStreet("Sinhgad road");
				adr.setCity("Pune");
				adr.setState("MAHARASHTRA");
				adr.setZipcode("411041");
				emp.setAddress(adr);
				em.persist(adr);
				
				em.getTransaction().commit();
				System.out.println("Added Employees and Address Successfully");
				em.close();
				factory.close();
	}

}
