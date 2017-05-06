package it.hella.hibernate.model.tbccu;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * The Class CreditCardU.
 * 
 * <p>
 * Illustrates the <b>Table per concrete Class with Union</b> inheritance
 * mapping strategy.
 * </p>
 * 
 * @see #BillingDetailsU
 * 
 */
@Entity
public class CreditCardU extends BillingDetailsU {

	/** The number. */
	@Column(name = "NUMBER", nullable = false)
	private String number;

	/** The expiration date. */
	@Column(name = "EXPIRATION_DATE", nullable = false)
	private Date expirationDate;

	/** The type. */
	@Column(name = "CREDIT_CARD_TYPE", nullable = false)
	private String type;

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
	 * Gets the expiration date.
	 *
	 * @return the expiration date
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Sets the expiration date.
	 *
	 * @param expirationDate
	 *            the new expiration date
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

}
