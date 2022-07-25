package Microservices.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data generates all the boilerplate that is normally associated with simple POJOs (Plain Old Java Objects) and beans: getters for all fields, setters for all non-final fields, 

//he @Builder annotation produces complex builder APIs for your classes.

//@Builder lets you automatically produce the code required to have your class be instantiable with code such as:

//Person.builder()
//.name("Adam Savage")
//.city("San Francisco")
//.job("Mythbusters")
//.job("Unchained Reaction")
//.build();

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	
	@Id
	@SequenceGenerator(
			name="customer_id_sequence",
			sequenceName="customer_id_sequence"
			)
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="customer_id_sequence"
			)
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
