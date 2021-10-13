package IidaRokka.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import IidaRokka.bookstore.domain.bookEntity;
import IidaRokka.bookstore.domain.bookRepository;
import IidaRokka.bookstore.domain.categoryRepository;

@Controller
public class BookController {
	@Autowired
	private bookRepository repository;

	@Autowired
	private categoryRepository catrepository;

	// Listaa kirjat
	@GetMapping("/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Listaa kirjat REST
	@GetMapping(value = "/books")
	public @ResponseBody List<bookEntity> bookListRest() {
		return (List<bookEntity>) repository.findAll();
	}

	// Listaa kirjat id:n mukaan REST
	@GetMapping(value = "/book/{id}")
	public @ResponseBody Optional<bookEntity> findBookRest(@PathVariable("id") Long BookId) {
		return repository.findById(BookId);
	}

	// Lisaa kirja
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new bookEntity());
		model.addAttribute("categories", catrepository.findAll());
		return "addbook";
	}

	// Tallentaa kirjan
	@PostMapping("/save")
	public String save(bookEntity book) {
		repository.save(book);
		return "redirect:booklist";
	}

	// Poistaa kirjan
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long BookId, Model model) {
		repository.deleteById(BookId);
		return "redirect:../booklist";
	}

	// Editoi kirjan tietoja
	@RequestMapping(value = "/edit/{id}")
	public String editBook(@PathVariable("id") Long BookId, Model model) {
		model.addAttribute("book", repository.findById(BookId));
		model.addAttribute("categories", catrepository.findAll());
		return "editbook";
	}

	// TESTI
	@GetMapping("/index")
	public String test() {
		return "booklist";
	}

}
