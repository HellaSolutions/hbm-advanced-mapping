package it.hella.model.hibernate.tbsc;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * The Class BankAccountC.
 * <p>
 * Illustrates the <b>Table per class (Joined)</b> inheritance mapping strategy
 * that enables polymorphic queries.
 * </p>
 * 
 * @see #BillingDetailsC
 */
@Entity
public class BankAccountC extends BillingDetailsC {

	/** The number. */
	@Column(name = "NUMBER")
	private String number;
	/** The number. */
	@Column(name = "BANK")
	private String bank;
	/** The number. */
	@Column(name = "AGENCY")
	private int agency;

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
