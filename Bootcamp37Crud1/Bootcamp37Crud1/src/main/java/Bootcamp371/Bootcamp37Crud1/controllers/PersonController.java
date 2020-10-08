/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bootcamp371.Bootcamp37Crud1.controllers;

import Bootcamp371.Bootcamp37Crud1.entities.Person;
import Bootcamp371.Bootcamp37Crud1.repositories.PersonRepository;
import Bootcamp371.Bootcamp37Crud1.services.PersonService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Laila
 */
@Controller
public class PersonController {
   @Autowired
    private PersonService personService;
    
@Autowired
    PersonRepository personRepository;
    
        @GetMapping("")
    public String awal() {
            System.out.println(personService.getAll());
        return "index";
    }
//  @GetMapping("")
//public String index( Model model){
//   model.addAttribute("person", new Person());
////    model.addAttribute("persons", personService.getAll());
//   
//    return "coba";
//}
    @ResponseBody
@GetMapping("/insertall")
public List<Person> saveAll(){
    Person person = new Person();
//    personService.save(person);
//    System.out.println(personService.getAll().toString());
personService.saveAll();
        System.out.println(personService.getAll().toString());
    return personService.saveAll();
    
    
}

    @ResponseBody
@GetMapping("/insert")
public Person save(){
    Person person = new Person();
    person.setAge(23);
    person.setEmail("aqira@gmail.com");
    person.setName("aqiraa");
    person.setGender("MALE");
    person.setId("P02");
//    personService.save(person);
//    System.out.println(personService.getAll().toString());
//personService.saveAll();
        System.out.println(personService.getAll().toString());
    return personService.save(person);
    
    
}


    @ResponseBody
@GetMapping("/update")
public boolean update(){
    Person person = new Person();
    person.setId("P02");
    person.setEmail("aqira@gmail.com");
    person.setName("aqira");        
    person.setGender("MALE");
//        person.setAge(23);
//    personService.save(person);
//    System.out.println(personService.getAll().toString());
//personService.saveAll();
        System.out.println(personService.getAll().toString());
    return personService.update(person);
    
    
}
@RequestMapping("/delete/{id}")
public String delete(@PathVariable String id){
    System.out.println(personService.getAll().toString());
    personService.delete(id);
    
    return "redirect:/";
    
}
@ResponseBody
@RequestMapping("/getById/{id}")
public Optional<Person> getById(@PathVariable @Valid String id){
//    Optional<Person> person= personRepository.findAllById(id);
//person.addAttribute("person", new Person()); 
return personService.getById(id);
//     return "index";
//    if (person.isPresent()) {
//      return new ResponseEntity<>(person.get(), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
  }
@ResponseBody
@RequestMapping("/search/{keyword}")
public List<Person> search (@PathVariable @Valid String keyword){
    return personService.search(keyword);
}
//@RequestMapping("/search")
//public String viewHomePage(Model model){
//String keyword="a";
//    List<Person> listPersons= personService.listAll(keyword);
//    model.addAttribute("listPersons", listPersons);
////    model.addAttribute("keyword", keyword);
//    return "index";
//}

//@GetMapping("/search")
//public String search (Model model, @RequestParam String keyword){
//        List<Person> persons = (List<Person>) personRepository.search(keyword);
//    model.addAttribute("persons", persons);
//    return "showSearch";
//}

}
