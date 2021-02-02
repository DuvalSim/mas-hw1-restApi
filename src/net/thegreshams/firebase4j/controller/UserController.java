package net.thegreshams.firebase4j.controller;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController()
@RequestMapping("/users")
public class UserController {

    String firebase_baseUrl = "https://mas-hw1-default-rtdb.firebaseio.com/users";
    //String firebase_apiKey = "AIzaSyAQXySEkoPmkUhXsebjLbRv7Ri9NeS4RWo";
    Firebase firebase = new Firebase( firebase_baseUrl );

    public UserController() throws FirebaseException {
    }

    @GetMapping()
    public void getUsers() throws UnsupportedEncodingException, FirebaseException {
        FirebaseResponse response = firebase.get();
        System.out.println( "\n\nResult of GET ALL :\n" + response );
        System.out.println("\n");
    }

    @GetMapping("/{username}")
    public void getUser(@PathVariable String username) throws UnsupportedEncodingException, FirebaseException {
        FirebaseResponse response = firebase.get(username);
        System.out.println( "\n\nResult of GET user :\n" + response );
        System.out.println("\n");
    }

    @PostMapping()
    public void newUser(@RequestBody String user) throws JacksonUtilityException, UnsupportedEncodingException, FirebaseException {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        dataMap.put( user, "POST" );
        FirebaseResponse response = firebase.post( "test-POST", dataMap );
        System.out.println( "\n\nResult of POST (for the test-POST):\n" + response );
        System.out.println("\n");
    }

    @PutMapping()
    public void updateUser(@RequestBody String user) throws JacksonUtilityException, UnsupportedEncodingException, FirebaseException {
        Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
        dataMap.put( user, "PUT" );
        FirebaseResponse response = firebase.put( dataMap );
        System.out.println( "\n\nResult of PUT (for the test-PUT to fb4jDemo-root):\n" + response );
        System.out.println("\n");
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) throws UnsupportedEncodingException, FirebaseException {
        FirebaseResponse response = firebase.delete(username);
        System.out.println( "\n\n Deleted \n" );
    }
}