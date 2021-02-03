package net.thegreshams.firebase4j;

import java.io.IOException;

import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirebaseMain {

	public static void main(String[] args) throws FirebaseException, JsonParseException, JsonMappingException, IOException, JacksonUtilityException {
		SpringApplication.run(FirebaseMain.class, args);
	}
}




