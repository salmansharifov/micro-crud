package com.salman;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void getByIdTest(){
        HttpRequest request = HttpRequest.GET("/user/11");
        User user = (User) client.toBlocking().exchange(request);
        assertEquals("salman", user.getName());
    }
}