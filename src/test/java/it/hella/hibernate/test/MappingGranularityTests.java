package it.hella.hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;
import java.util.Set;

import org.junit.Test;

import it.hella.hibernate.embeddable.Address;
import it.hella.hibernate.embeddable.PhoneNumber;
import it.hella.hibernate.embeddable.PhoneNumber.PHONETYPE;
import it.hella.hibernate.model.component.User;
import it.hella.hibernate.model.component.UserWithPhoneMap;

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

		PhoneNumber phoneA = new PhoneNumber();
		phoneA.setCountry("IT");
		phoneA.setNumber("34277567490");
		user.addPhone(phoneA);
		PhoneNumber phoneB = new PhoneNumber();
		phoneB.setCountry("CH");
		phoneB.setNumber("80808008090");
		user.addPhone(phoneB);

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

		User fetchedUser = entityManager.find(User.class, user.getId());
		assertNotNull(fetchedUser.getHomeAddress());

		Set<PhoneNumber> userPhones = fetchedUser.getPhones();
		assertEquals(2, userPhones.size());

		user.removePhone(phoneB);
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		userPhones = fetchedUser.getPhones();
		assertEquals(1, userPhones.size());
		assertTrue(userPhones.contains(phoneA));

	}

	@Test
	public void insertUserWithPhoneMapTest() {

		Address address = new Address();
		address.setCity("Rome");
		address.setStreet("via Cristoforo Colombo");
		address.setZipcode("00100");
		UserWithPhoneMap user = new UserWithPhoneMap();
		user.setHomeAddress(address);
		user.setName("Pilla");
		user.setSurname("Polla");

		PhoneNumber phoneA = new PhoneNumber();
		phoneA.setCountry("IT");
		phoneA.setNumber("34277567490");
		user.savePhone(PHONETYPE.HOME, phoneA);
		PhoneNumber phoneB = new PhoneNumber();
		phoneB.setCountry("CH");
		phoneB.setNumber("80808008090");
		user.savePhone(PHONETYPE.MOBILE, phoneB);

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

		UserWithPhoneMap fetchedUser = entityManager.find(UserWithPhoneMap.class, user.getId());
		assertNotNull(fetchedUser.getHomeAddress());

		Optional<PhoneNumber> homeNumber = fetchedUser.getPhone(PHONETYPE.HOME);
		assertTrue(homeNumber.isPresent());
		Optional<PhoneNumber> mobileNumber = fetchedUser.getPhone(PHONETYPE.MOBILE);
		assertTrue(mobileNumber.isPresent());

		user.removePhone(PHONETYPE.HOME);
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

		homeNumber = fetchedUser.getPhone(PHONETYPE.HOME);
		assertFalse(homeNumber.isPresent());
		mobileNumber = fetchedUser.getPhone(PHONETYPE.MOBILE);
		assertTrue(mobileNumber.isPresent());

	}

}
