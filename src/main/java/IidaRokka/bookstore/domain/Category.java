package IidaRokka.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<bookEntity> books;

	// KONSTRUKTORI

	public Category() {
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	// GET SET

	public Long getId() {
		return id;
	}

	public List<bookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<bookEntity> books) {
		this.books = books;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// TO STRING

	@Override
	public String toString() {
		return name;
	}

}
