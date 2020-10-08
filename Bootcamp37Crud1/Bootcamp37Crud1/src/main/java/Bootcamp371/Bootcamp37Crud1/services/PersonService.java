/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bootcamp371.Bootcamp37Crud1.services;

import Bootcamp371.Bootcamp37Crud1.entities.Person;
import Bootcamp371.Bootcamp37Crud1.repositories.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laila
 */
@Service
public class PersonService {
  
    @Autowired
    PersonRepository personRepository;
    
    //read
 public List<Person> getAll(){
     return personRepository.findAll();
 }
 //create/update
 public Person save(Person person){
//     Person save = personRepository.save(person);
    return personRepository.save(person);
     
 }
 public List <Person> saveAll(){
     List<Person> persons = new ArrayList<>();
     persons.add(new Person("P02", "Joko", "jokos@gmail.com", "MALE", 35));
//     persons.add(new Person("P02", "Aqira", "aqira@gmail.com", "MALE", 23));
     persons.add(new Person("P03", "Fikri", "fikri@gmail.com", "MALE", 23));
     persons.add(new Person("P04", "Iqwal", "iqwal@gmail.com", "MALE", 23));
     persons.add(new Person("P05", "Zakky", "zakky@gmail.com", "MALE", 23));
     persons.add(new Person("P06", "Nisa", "nisa@gmail.com", "FEMALE", 23));
    return personRepository.saveAll(persons);
 }
 //delete
 public void delete (String id){
     personRepository.delete(new Person(id));
 }
 public Optional<Person> getById(String id){
     return personRepository.findById(id);
 }

    
//    public Optional<Region> findById(int id) {
//    return regionRepository.findById(id);
//    }
public List<Person> listAll(String keyword){
    if(keyword !=null){
        return personRepository.search(keyword);
    }
    return personRepository.findAll();
}

    public List<Person> search(String keyword) {
        List<Person> persons = (List<Person>) personRepository.search(keyword);
        return persons;
  
    }
    public boolean update (Person person){
        Optional<Person> personOptional= getById(person.getId());
        if(personOptional.isPresent()){
//            personOptional.get().setAge(person.getAge());
            personOptional.get().setEmail(person.getEmail());
            personOptional.get().setName(person.getName());
            personOptional.get().setGender(person.getGender());
            personRepository.save(personOptional.get());
            return true;
        }
        return false;
    }
}
