package br.com.ArthurBrandino.rest_with_spring_boot_and_java.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.ArthurBrandino.rest_with_spring_boot_and_java.model.Person;


@Service 
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

        public List<Person> findAll(){
            logger.info("Finding ALL People");
            List<Person> persons = new ArrayList<Person>();

            for(int i = 0; i < 8; i++)
            {
                Person person = mockPerson(i);
                persons.add(person);
            }
            return persons;
        }

        public Person findById(String id){
            logger.info("Finding one Person");

            Person person = new Person();
            person.setId(counter.incrementAndGet());
            person.setFirstName("Leandro");
            person.setLastName("Costa");
            person.setAddress("São Paulo - Brasil");
            person.setGender("Male");

            return person;
        }

        public Person create(Person person){
            logger.info("Creating one Person");

            return person;
        }

        public Person update(Person person){
            logger.info("Updating one Person");
            
            return person;
        }

        public void delete(String id){
            logger.info("Deleting one Person");

        }

        private Person mockPerson(int i) {
            Person person = new Person();
            person.setId(counter.incrementAndGet());
            person.setFirstName("FirstName: " + i);
            person.setLastName("LastName: " + i);
            person.setAddress("São Paulo - Brasil");
            person.setGender("Male");

            return person;
        }
}
