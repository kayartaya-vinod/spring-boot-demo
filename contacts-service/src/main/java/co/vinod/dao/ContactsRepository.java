package co.vinod.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.vinod.model.Contact;

@Repository
public interface ContactsRepository
extends CrudRepository<Contact, Integer>{

}
