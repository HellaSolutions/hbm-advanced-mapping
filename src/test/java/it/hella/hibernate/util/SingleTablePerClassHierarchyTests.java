package it.hella.hibernate.util;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import it.hella.hibernate.model.tbch.BankAccountH;
import it.hella.hibernate.model.tbch.BillingDetailsH;
import it.hella.hibernate.model.tbch.CreditCardH;

public class SingleTablePerClassHierarchyTests extends BaseTests {

	@Test
	public void billingDetailsTest() {

		CreditCardH cc = new CreditCardH();
		cc.setNumber("1");
		cc.setOwner("owner_cc");
		cc.setType("type");
		LocalDate expires = LocalDate.now().plusDays(366);
		cc.setExpirationDate(Date.valueOf(expires));
		BankAccountH ba = new BankAccountH();
		ba.setAgency(5);
		ba.setBank("UBI");
		ba.setNumber("2");
		ba.setOwner("owner_ba");
		persistBilllingDetails(cc);
		persistBilllingDetails(ba);

		List<BillingDetailsH> res = entityManager
				.createQuery("select c from CreditCardH c where c.owner = 'owner_cc'", BillingDetailsH.class)
				.getResultList();
		assertTrue(res.size() == 1);
		res = entityManager
				.createQuery("select b from BankAccountH b where b.owner = 'owner_ba'", BillingDetailsH.class)
				.getResultList();
		assertTrue(res.size() == 1);
		// Polymorphic query
		res = entityManager.createQuery("select b from BillingDetailsH b", BillingDetailsH.class).getResultList();
		assertTrue(res.size() == 2);

	}

	private void persistBilllingDetails(BillingDetailsH bd) {
		entityManager.getTransaction().begin();
		entityManager.persist(bd);
		entityManager.getTransaction().commit();
	}

}
