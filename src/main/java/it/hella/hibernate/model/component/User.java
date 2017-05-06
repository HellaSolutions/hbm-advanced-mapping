package it.hella.hibernate.model.component;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import it.hella.hibernate.embeddable.Address;

/**
 * The Class User.
 * 
 * <p>
 * Illustrates the use of Hibernate Custom Type to control the granularity of
 * the mapping between the database schema and the domain model.
 * </p>
 * 
 * <p>
 * The class declares an attribute as @Embedded which type should be @Embeddable
 * </p>
 * 
 * In this case the @Embeddable class Address is embedded into User and
 * represents a projection of the column of the table USER that holds the
 * address information
 * 
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3210499507098802307L;

	/** The Id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo_sequence_generator")
	@GenericGenerator(name = "hilo_sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "user_sequence", value = "hilo_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "100"),
			@Parameter(name = "optimizer", value = "hilo") })
	private Long Id;

	/** The name. */
	@Column(name = "NAME", nullable = false)
	private String name;

	/** The surname. */
	@Column(name = "SURNAME", nullable = false)
	private String surname;

	/** The home address. */
	@Embedded
	private Address homeAddress;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.Id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname
	 *            the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the home address.
	 *
	 * @return the home address
	 */
	public Address getHomeAddress() {
		return homeAddress;
	}

	/**
	 * Sets the home address.
	 *
	 * @param homeAddress
	 *            the new home address
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

}
