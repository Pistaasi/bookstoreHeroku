package IidaRokka.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface bookRepository extends CrudRepository<bookEntity, Long> {

	List<bookEntity> findByTitle(String title);
}
