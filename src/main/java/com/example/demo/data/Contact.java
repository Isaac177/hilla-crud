package com.example.demo.data;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Contact {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 2, max = 50)
    private String name;
    private String phone;
    @Email
    private String email;


    public Contact() {
    }

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

}
