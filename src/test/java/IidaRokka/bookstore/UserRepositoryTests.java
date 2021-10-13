package IidaRokka.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import IidaRokka.bookstore.domain.User;
import IidaRokka.bookstore.domain.userRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTests {
	@Autowired
	private userRepository urepository;

	@Test
	public void findByUsernameShouldReturn() {
		List<User> users = urepository.findByUName("admin");

		assertThat(users).hasSize(1);
		assertThat(users.get(0).getUsername()).isEqualTo("admin");
	}

	@Test
	public void createUser() {
		urepository
				.save(new User("test", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3U", "TESTER", "iida.rokka@hotmail.fi"));
		assertThat(urepository.findByUName("TEST")).hasSize(1);
		assertThat(urepository.findByRole("TESTER")).hasSize(1);
	}

	@Test
	public void deleteUser() {
		User testUser = new User("test", "$2a$06$3jYRJrg0ghaaypjZ/.g4Setho", "TESTER", "iida.rokka@hotmail.fi");
		urepository.save(testUser);
		urepository.delete(testUser);
		assertThat(urepository.findByUName("test")).hasSize(0);
	}
}
