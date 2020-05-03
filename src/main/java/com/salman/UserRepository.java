package com.salman;

import io.micronaut.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository <User, Integer>{


}
