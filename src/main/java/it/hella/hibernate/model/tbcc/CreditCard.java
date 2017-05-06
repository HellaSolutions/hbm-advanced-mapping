package it.hella.hibernate.model.tbcc;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The Class CreditCard.
 * 
 * <p>
 * Illustrates the <b>Table per concrete Class</b> inheritance mapping strategy.
 * </p>
 * 
 * @see #BillingDetails
 * 
 */
@Entity
@AttributeOverride(name = "owner", column = @Column(name = "CC_OWNER", nullable = false))
public class CreditCard extends BillingDetails {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4370406107960555412L;

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "CREDIT_CARD_ID")
	private Long id = null;

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
