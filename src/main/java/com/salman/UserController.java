package com.salman;

import io.micronaut.http.annotation.*;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller("/user")
public class UserController {


    @Inject UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get("/{id}")
    Optional<User> findByID(int id) {
        return userService.findByID(id);
    }

    @Get
    List<User> findAll() {
        return userService.findAll();
    }

    @Post("/{id}&{name}&{surname}&{age}&{email}")
    boolean save(@PathVariable("id") int id, @PathVariable("name")String name, @PathVariable("surname") String surname,
                 @PathVariable("age") int age, @PathVariable("email") String email){
        userService.save(id, name, surname, age, email);
        return true;
    }

    @Put("/{id}&{name}&{surname}&{age}&{email}")
    int update(@PathVariable("id") int id, @PathVariable("name")String name, @PathVariable("surname") String surname,
               @PathVariable("age") int age, @PathVariable("email") String email){
        return userService.update(id, name, surname, age, email);

    }

    @Delete("/{id}")
    void delete(@PathVariable("id") int id){
        userService.delete(id);
    }
}
