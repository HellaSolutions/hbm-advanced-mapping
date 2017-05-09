package it.hella.hibernate.test;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import it.hella.hibernate.model.tbccu.BankAccountU;
import it.hella.hibernate.model.tbccu.BillingDetailsU;
import it.hella.hibernate.model.tbccu.CreditCardU;

public class TablePerConcreteClassWithUnionTests extends BaseTests {

	@Test
	public void billingDetailsTest() {

		CreditCardU cc = new CreditCardU();
		cc.setNumber("1");
		cc.setOwner("owner_cc");
		cc.setType("type");
		LocalDate expires = LocalDate.now().plusDays(366);
		cc.setExpirationDate(Date.valueOf(expires));
		BankAccountU ba = new BankAccountU();
		ba.setAgency(5);
		ba.setBank("UBI");
		ba.setNumber("2");
		ba.setOwner("owner_ba");
		persistBilllingDetails(cc);
		persistBilllingDetails(ba);

		List<BillingDetailsU> res = entityManager
				.createQuery("select c from CreditCardU c where c.owner = 'owner_cc'", BillingDetailsU.class)
				.getResultList();
		assertTrue(res.size() == 1);
		res = entityManager
				.createQuery("select b from BankAccountU b where b.owner = 'owner_ba'", BillingDetailsU.class)
				.getResultList();
		assertTrue(res.size() == 1);
		// Polymorphic query
		res = entityManager.createQuery("select b from BillingDetailsU b", BillingDetailsU.class).getResultList();
		assertTrue(res.size() == 2);

	}

	private void persistBilllingDetails(BillingDetailsU bd) {

		entityManager.getTransaction().begin();
		entityManager.persist(bd);
		entityManager.getTransaction().commit();

	}

}
