package it.hella.hibernate.model.tbcc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class BankAccount.
 * <p>
 * Illustrates the <b>Table per concrete Class</b> inheritance mapping strategy.
 * </p>
 * 
 * @see #BillingDetails
 */
@Entity
public class BankAccount extends BillingDetails {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8582570787552731528L;

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "BANK_ACCOUNT_ID")
	private Long id = null;

	/** The number. */
	@Column(name = "NUMBER", nullable = false)
	private String number;
	/** The number. */
	@Column(name = "BANK", nullable = false)
	private String bank;
	/** The number. */
	@Column(name = "AGENCY", nullable = false)
	private int agency;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number
	 *            the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Gets the bank.
	 *
	 * @return the bank
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * Sets the bank.
	 *
	 * @param bank
	 *            the new bank
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
	 * Gets the agency.
	 *
	 * @return the agency
	 */
	public int getAgency() {
		return agency;
	}

	/**
	 * Sets the agency.
	 *
	 * @param agency
	 *            the new agency
	 */
	public void setAgency(int agency) {
		this.agency = agency;
	}

}
