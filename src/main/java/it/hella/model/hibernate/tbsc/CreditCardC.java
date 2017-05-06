package it.hella.model.hibernate.tbsc;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * The Class CreditCardC.
 * 
 * <p>
 * Illustrates the <b>Table per class (Joined)</b> inheritance mapping strategy
 * that enables polymorphic queries.
 * </p>
 * 
 * <b>Note:</b> Use of the <b>@PrimaryKeyJoinColumn</b> to customize the foreign
 * key column name
 * 
 * @see #BillingDetailsC
 * 
 */
@Entity
@PrimaryKeyJoinColumn(name = "CREDIT_CARD_ID")
public class CreditCardC extends BillingDetailsC {

	/** The number. */
	@Column(name = "NUMBER")
	private String number;

	/** The expiration date. */
	@Column(name = "EXPIRATION_DATE")
	private Date expirationDate;

	/** The type. */
	@Column(name = "CREDIT_CARD_TYPE")
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
