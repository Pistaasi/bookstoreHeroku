package IidaRokka.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import IidaRokka.bookstore.domain.bookEntity;
import IidaRokka.bookstore.domain.bookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	private bookRepository repository;

	@Test
	public void findByTitleShouldReturBook() {
		List<bookEntity> books = repository.findByTitle("Noituri1");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Andrzej Sapkowski");
	}

	@Test
	public void createBook() {
		bookEntity book = new bookEntity("Päiväkirja", "Iida Rokka", "ISBN", 2021, 999.99);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void deleteBook() {
		bookEntity book2 = new bookEntity("Shrek2", "Shrek", "ISBNWOW", 2012, 100.00);
		repository.save(book2);
		repository.delete(book2);
		assertThat(repository.findByTitle("Shrek2")).hasSize(0);
	}

}
