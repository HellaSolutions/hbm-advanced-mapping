package it.hella.hibernate.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import it.hella.hibernate.embeddable.Address;
import it.hella.hibernate.model.component.User;

public class MappingGranularityTests extends BaseTests {

	@Test
	public void insertUserTest() {

		Address address = new Address();
		address.setCity("Rome");
		address.setStreet("via Cristoforo Colombo");
		address.setZipcode("00100");
		User user = new User();
		user.setHomeAddress(address);
		user.setName("Pilla");
		user.setSurname("Polla");
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

		User fetchedUser = entityManager.find(User.class, user.getId());
		assertNotNull(fetchedUser.getHomeAddress());

	}

}
