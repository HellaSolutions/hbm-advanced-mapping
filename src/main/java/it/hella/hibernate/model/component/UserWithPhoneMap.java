package it.hella.hibernate.model.component;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import it.hella.hibernate.embeddable.Address;
import it.hella.hibernate.embeddable.PhoneNumber;
import it.hella.hibernate.embeddable.PhoneNumber.PHONETYPE;

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
 * <p>
 * In this case the @Embeddable class Address is embedded into User and
 * represents a projection of the column of the table USER that holds the
 * address information
 * </p>
 * 
 * <p>
 * An @Embeddable type is also used to save a composition of PhoneNumbers using
 * the @ElementCollection annotation and a Map with an enumerated key, namely
 * the PHONETYPE {MOBILE, HOME .., via the @MapKeyEnumerated annotation.<br/>
 * The other type of MapKey annotations are
 * <ul>
 * <li>
 * 
 * @MapKeyEnumerated: enumerate key</li>
 *                    <li>
 * @MapKeyTemporal: if the Date key type</li>
 *                  <li>
 * @MapKeyJoinColumn/@MapKeyJoinColumns: if the map key type is another entity
 *                                       (not relevant for these case histories)
 *                                       </li>
 *                                       </ul>
 * 
 *                                       <b>@MapKeyColumn</b> if the map key is
 *                                       a basic type. If you don't specify the
 *                                       column name, the name of the property
 *                                       followed by underscore followed by KEY
 *                                       is used (for example orders_KEY),<br/>
 *                                       <b>@AttributeOverride/@AttributeOverrides</b>
 *                                       when the map key is a embeddable
 *                                       object. Use key. as a prefix for your
 *                                       embeddable object property names.
 *                                       </p>
 * 
 */
@Entity
@Table(name = "USER_WITH_PHONEMAP")
public class UserWithPhoneMap implements Serializable {

	private static final long serialVersionUID = -4335609167513090347L;

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

	/**
	 * The home address.
	 * 
	 * Embedded component
	 * 
	 */
	@Embedded
	private Address homeAddress;

	@ElementCollection
	@CollectionTable(name = "USER_PHONE_MAP", joinColumns = @JoinColumn(name = "USER_ID"))
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "PHONE_TYPE")
	private Map<PHONETYPE, PhoneNumber> phonesMap = new EnumMap<>(PHONETYPE.class);

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

	@SuppressWarnings("unused")
	private Map<PHONETYPE, PhoneNumber> getPhonesMap() {
		return phonesMap;
	}

	@SuppressWarnings("unused")
	private void setPhonesMap(Map<PHONETYPE, PhoneNumber> phonesMap) {
		this.phonesMap = phonesMap;
	}

	public Optional<PhoneNumber> getPhone(PHONETYPE phoneType) {
		return Optional.ofNullable(phonesMap.getOrDefault(phoneType, (PhoneNumber) null));
	}

	public void savePhone(PHONETYPE phoneType, PhoneNumber phoneNumber) {
		phonesMap.put(phoneType, phoneNumber);
	}

	public void removePhone(PHONETYPE phoneType) {
		phonesMap.remove(phoneType);
	}

}
