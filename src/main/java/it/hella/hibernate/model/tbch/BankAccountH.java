package it.hella.hibernate.model.tbch;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * The Class BankAccountH.
 * <p>
 * Illustrates the <b>Table per class Hierarchy</b> inheritance mapping
 * strategy.
 * </p>
 * 
 * @see #BillingDetailsH
 */
@Entity
@DiscriminatorValue("BA")
public class BankAccountH extends BillingDetailsH {

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
