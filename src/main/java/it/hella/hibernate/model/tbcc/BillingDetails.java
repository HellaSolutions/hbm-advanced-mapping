package it.hella.hibernate.model.tbcc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * The Class BillingDetails.
 * 
 * <p>
 * Illustrates the <b>Table per concrete Class</b> inheritance mapping strategy.
 * </p>
 * 
 * <p>
 * By default properties of the superclass are ignored and not persisted. The
 * <b>@MapperSuperclass</b> circumvents this behavior</br>
 * and it is taught as a container of the common fields of the derived classes.
 * In this case the owner name.
 * </p>
 * 
 * <p>
 * The <b>database identifier</b> can also be declared in the superclass with a
 * shared column name and generator strategy for all subclasses
 * </p>
 * 
 * @see #BankAccount
 * @see #CreditCard
 */
@MappedSuperclass
public abstract class BillingDetails implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7677590329364557215L;

	/** The owner. */
	@Column(name = "OWNER", nullable = false)
	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
