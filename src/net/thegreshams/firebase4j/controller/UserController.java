package net.thegreshams.firebase4j.controller;

import com.google.gson.Gson;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
import net.thegreshams.firebase4j.model.FirebaseResponse;
import net.thegreshams.firebase4j.service.Firebase;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.thegreshams.firebase4j.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    String firebase_baseUrl = "https://mas-hw1-default-rtdb.firebaseio.com/users";
    //String firebase_apiKey = "AIzaSyAQXySEkoPmkUhXsebjLbRv7Ri9NeS4RWo";
    Firebase firebase = new Firebase( firebase_baseUrl );

    public UserController() throws FirebaseException {
    }

    @GetMapping()
    public String getUsers() throws UnsupportedEncodingException, FirebaseException {
        FirebaseResponse response = firebase.get();

        return response.getRawBody();
    }

    @GetMapping("/{username}")
    public String getUser(@PathVariable String username) throws UnsupportedEncodingException, FirebaseException {
        String usersString = getUsers();
        Gson gson = new Gson();

        List<User> userList = gson.fromJson(usersString, ArrayList.class);

        for (int i = 0; i < userList.size(); ++i) {

            User currentUser = gson.fromJson(String.valueOf(userList.get(i)), (Type) User.class);
            System.out.println(currentUser.getUsername());
            if (currentUser.getUsername().equals(username)) {
                System.out.println("User Found");
                return currentUser.toString();
            }
        }
        return "{}";
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