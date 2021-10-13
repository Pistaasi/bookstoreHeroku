package IidaRokka.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface userRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

	List<User> findByUName(String name);

	List<User> findByRole(String role);
}
