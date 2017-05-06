package it.hella.hibernate.util;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import it.hella.hibernate.model.tbcc.BankAccount;
import it.hella.hibernate.model.tbcc.BillingDetails;
import it.hella.hibernate.model.tbcc.CreditCard;

public class TablePerConcreteClassTests extends BaseTests {

	@Test
	public void billingDetailsTest() {

		CreditCard cc = new CreditCard();
		cc.setNumber("1");
		cc.setOwner("owner_cc");
		cc.setType("type");
		LocalDate expires = LocalDate.now().plusDays(366);
		cc.setExpirationDate(Date.valueOf(expires));
		BankAccount ba = new BankAccount();
		ba.setAgency(5);
		ba.setBank("UBI");
		ba.setNumber("2");
		ba.setOwner("owner_ba");
		persistBilllingDetails(cc);
		persistBilllingDetails(ba);

		List<BillingDetails> res = entityManager
				.createQuery("select c from CreditCard c where c.owner = 'owner_cc'", BillingDetails.class)
				.getResultList();
		assertTrue(res.size() == 1);
		res = entityManager.createQuery("select b from BankAccount b where b.owner = 'owner_ba'", BillingDetails.class)
				.getResultList();
		assertTrue(res.size() == 1);

	}

	private void persistBilllingDetails(BillingDetails bd) {
		entityManager.getTransaction().begin();
		entityManager.persist(bd);
		entityManager.getTransaction().commit();
	}

}
