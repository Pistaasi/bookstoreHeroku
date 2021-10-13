package IidaRokka.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import IidaRokka.bookstore.domain.Category;
import IidaRokka.bookstore.domain.categoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTests {
	@Autowired
	private categoryRepository catrepository;

	@Test
	public void findByNameShouldReturCategoryName() {
		List<Category> categories = catrepository.findByName("Horror");

		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Horror");
	}

	@Test
	public void createCategory() {
		catrepository.save(new Category("TEST"));
		assertThat(catrepository.findByName("TEST")).hasSize(1);
	}

	@Test
	public void deleteCategory() {
		Category cat = new Category("TESTCAT");
		catrepository.save(cat);
		catrepository.delete(cat);
		assertThat(catrepository.findByName("TESTCAT")).hasSize(0);
	}
}
