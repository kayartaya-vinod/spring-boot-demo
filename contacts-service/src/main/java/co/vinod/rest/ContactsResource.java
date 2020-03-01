package co.vinod.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.vinod.dao.ContactsRepository;
import co.vinod.model.Contact;

@RestController
@RequestMapping("/api/contacts")
public class ContactsResource {

	@Autowired
	ContactsRepository repo;

	@DeleteMapping("/{id}")
	public Contact deleteById(@PathVariable Integer id) {
		Contact contact = this.getById(id);
		repo.delete(contact);
		return contact;
	}

	@PutMapping("/{id}")
	public Contact update(@PathVariable Integer id, @RequestBody Contact contact) {
		contact.setId(id);
		return repo.save(contact);
	}

	@PostMapping
	public Contact addNew(@RequestBody Contact contact) {
		contact.setId(null);
		return repo.save(contact);
	}

	@GetMapping("/{id}")
	public Contact getById(@PathVariable Integer id) {
		return repo.findById(id).get();
	}

	@GetMapping
	public Iterable<Contact> getAll() {
		return repo.findAll();
	}

}
