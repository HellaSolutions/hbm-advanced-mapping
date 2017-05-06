package it.hella.hibernate.model.tbccu;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * The Class BankAccountU.
 * <p>
 * Illustrates the <b>Table per concrete Class</b> inheritance mapping strategy.
 * </p>
 * 
 * @see #BillingDetailsU
 */
@Entity
public class BankAccountU extends BillingDetailsU {

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
