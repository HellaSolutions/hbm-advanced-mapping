package it.hella.model.tbsc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * The Class BillingDetailsC.
 * <p>
 * Illustrates the <b>Table per class (Joined)</b> inheritance mapping strategy
 * that enables polymorphic queries.
 * </p>
 * 
 * <p>
 * The classes Id <b>should</b> be declared inside the base class which contains
 * also the common columns of the concrete subclasses. The concrete subclasses
 * declare the fields relative to the their own type version.
 * </p>
 * <p>
 * Both base and concrete classes are mapped to tables. Each subtype will be
 * mapped to a table that contains a foreign key to the primary key of the
 * superclass table.<br/>
 * The default foreign key name coincides with the name of the superclass
 * primary key. To force a different name you should use the
 * <b>@PrimaryKeyJoinColumn</b><br/>
 * at the class level of the concrete class.
 * </p>
 * <b>Tradeoff:</b> Normalized but less performing
 * 
 * @see #BankAccountC
 * @see #CreditCardC
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetailsC {

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
