package com.salman;


import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.http.annotation.Produces;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Singleton
public class UserService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final ApplicationConfiguration configuration;
    @Inject UserRepository userRepository;

    public UserService(@CurrentSession EntityManager entityManager, ApplicationConfiguration configuration) {
        this.entityManager = entityManager;
        this.configuration = configuration;
    }

    Optional<User> findByID(int id){
        return userRepository.findById(id);
    }

    List<User> findAll() {
        List<User> userList = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            userList.add(user);
        }
        return userList;
    }

    boolean save(int id,String name, String surname, int age, String email){
        User newUser = new User(id, name, surname, age, email);
        userRepository.save(newUser);
        return true;
    }

    int update(int id, String name, String surname, int age, String email){
       Optional<User> user = findByID(id);
       User u = user.get();
       u.setAge(age);
       u.setEmail(email);
       u.setName(name);
       u.setSurname(surname);
       userRepository.update(u);
       return id;
    }

    void delete(int id){
        userRepository.deleteById(id);
    }

}
