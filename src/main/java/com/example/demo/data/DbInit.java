package com.example.demo.data;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DbInit implements ApplicationRunner {

    private final ContactRepository contactRepository;

    public DbInit(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // generate 20 first and last names, then use them to create and save 100 contacts

        String[] firstNames = {"John", "Jane", "Mike", "Sara", "Tom", "Tim", "Kim", "Jim", "Sam", "Sue", "Bob", "Ann", "Joe", "Eva", "Max", "Amy", "Lee", "Ron", "Jen", "Ben"};

        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson"};

        for (int i = 0; i < 100; i++) {
            String name = firstNames[(int) (Math.random() * firstNames.length)] + " " + lastNames[(int) (Math.random() * lastNames.length)];
            String phone = "555-" + (int) (Math.random() * 1000) + "-" + (int) (Math.random() * 10000);
            String email = name.replaceAll(" ", ".").toLowerCase() + "@example.com";
            contactRepository.save(new Contact(name, phone, email));
        }
    }
}
