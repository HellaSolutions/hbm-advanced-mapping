package it.hella.hibernate.model;

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

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 3210499507098802307L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo_sequence_generator")
	@GenericGenerator(name = "hilo_sequence_generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "user_sequence", value = "hilo_sequence"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "100"),
			@Parameter(name = "optimizer", value = "hilo") })
	private Long Id;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "SURNAME", nullable = false)
	private String surname;
	@Embedded
	private Address homeAddress;

	public Long getId() {
		return Id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

}
