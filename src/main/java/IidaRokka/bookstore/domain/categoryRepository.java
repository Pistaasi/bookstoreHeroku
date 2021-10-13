package IidaRokka.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface categoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByName(String name);
}
