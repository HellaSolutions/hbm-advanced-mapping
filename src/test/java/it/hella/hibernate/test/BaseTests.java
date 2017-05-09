package it.hella.hibernate.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import it.hella.hibernate.model.component.User;

public class BaseTests {

	protected static EntityManagerFactory entityManagerFactory;
	/** The thrown. */
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	protected EntityManager entityManager;

	@BeforeClass
	public static void beforeClass() {

		entityManagerFactory = Persistence.createEntityManagerFactory("ecommerceTest");
		List<User> users = entityManagerFactory.createEntityManager().createQuery("select  u from User u", User.class)
				.getResultList();
		assertTrue(users.isEmpty());

	}

	@AfterClass
	public static void afterClass() {

		entityManagerFactory.close();

	}

	@Before
	public void before() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@After
	public void after() {
		entityManager.close();
	}

}
