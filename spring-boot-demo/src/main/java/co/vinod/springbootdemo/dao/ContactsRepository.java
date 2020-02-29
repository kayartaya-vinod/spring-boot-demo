package co.vinod.springbootdemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.vinod.springbootdemo.model.Contact;

@Repository
public interface ContactsRepository
extends CrudRepository<Contact, Integer>{

}
