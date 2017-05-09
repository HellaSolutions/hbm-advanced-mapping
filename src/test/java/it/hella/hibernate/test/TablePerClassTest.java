package it.hella.hibernate.test;

import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import it.hella.hibernate.model.tbsc.BankAccountC;
import it.hella.hibernate.model.tbsc.BillingDetailsC;
import it.hella.hibernate.model.tbsc.CreditCardC;

public class TablePerClassTest extends BaseTests {

	@Test
	public void billingDetailsTest() {

		CreditCardC cc = new CreditCardC();
		cc.setNumber("1");
		cc.setOwner("owner_cc");
		cc.setType("type");
		LocalDate expires = LocalDate.now().plusDays(366);
		cc.setExpirationDate(Date.valueOf(expires));
		BankAccountC ba = new BankAccountC();
		ba.setAgency(5);
		ba.setBank("UBI");
		ba.setNumber("2");
		ba.setOwner("owner_ba");
		persistBilllingDetails(cc);
		persistBilllingDetails(ba);

		List<BillingDetailsC> res = entityManager
				.createQuery("select c from CreditCardC c where c.owner = 'owner_cc'", BillingDetailsC.class)
				.getResultList();
		assertTrue(res.size() == 1);
		res = entityManager
				.createQuery("select b from BankAccountC b where b.owner = 'owner_ba'", BillingDetailsC.class)
				.getResultList();
		assertTrue(res.size() == 1);
		// Polymorphic query
		res = entityManager.createQuery("select b from BillingDetailsC b", BillingDetailsC.class).getResultList();
		assertTrue(res.size() == 2);

	}

	private void persistBilllingDetails(BillingDetailsC bd) {
		entityManager.getTransaction().begin();
		entityManager.persist(bd);
		entityManager.getTransaction().commit();
	}

}
