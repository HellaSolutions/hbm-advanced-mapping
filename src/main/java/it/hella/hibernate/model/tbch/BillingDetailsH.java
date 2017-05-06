package it.hella.hibernate.model.tbch;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * The Class BillingDetailsH.
 * <p>
 * Illustrates the <b>Table per class Hierarchy</b> inheritance mapping strategy
 * that enables polymorphic queries.
 * 
 * </p>
 * 
 * <p>
 * The classes Id <b>should</b> be declared inside the base class which contains
 * also the common columns and a <b>@DiscriminatoColumn</b> declared at the
 * class level.<br/>
 * The discriminator possibile values range over all the possible concrete
 * subclasses and should be declared at class level for each of them via
 * the<br/>
 * <b>@DicriminatorValue</b> annotation
 * </p>
 * <p>
 * <b>Tradeoff:</b>: The most performing strategy but not normalized (3rd normal
 * form violated)
 * </p>
 * <p>
 * <b>Important: </b>You cannot constrain the columns of the concrete classes to
 * be not-nullable as these classes represent a partition of the different<br/>
 * sub-types all represented on a single table
 * </p>
 * 
 * @see #BankAccountH
 * @see #CreditCardH
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BILLING_DETAILS_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class BillingDetailsH {

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
