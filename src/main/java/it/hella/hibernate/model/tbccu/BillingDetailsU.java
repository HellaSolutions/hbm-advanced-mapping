package it.hella.hibernate.model.tbccu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * The Class BillingDetailsU.
 * <p>
 * Illustrates the <b>Table per concrete Class with union</b> inheritance
 * mapping strategy that enables polymorphic queries.
 * 
 * </p>
 * 
 * <p>
 * The classes should have a common Id and it should be declared inside the base
 * class. There is still no relationship between the database tables, except for
 * the fact that they share some similar columns.
 * </p>
 * 
 * @see #BankAccountU
 * @see #CreditCardU
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetailsU {

	/** The id. */
	@Id
	@GeneratedValue
	@Column(name = "BILLING_DETAILS_ID")
	private Long id = null;

	/** The owner. */
	@Column(name = "OWNER", nullable = false)
	private String owner;

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
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owner.
	 *
	 * @param owner
	 *            the new owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

}
