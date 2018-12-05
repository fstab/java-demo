package de.fstab.helloworld;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello() {
        String result = "ENVIRONMENT\n";
        result = result + "===========\n\n";
        for (Map.Entry<String, String> e : new TreeMap<>(System.getenv()).entrySet()) {
            result = result + "| " + format(20, e.getKey()) + " | " + format(50, e.getValue()) + " |\n";
        }
        return result;
    }

    private String format(int n, String s) {
        if (s == null) {
            s = "null";
        }
        s = s.replaceAll("\\s+", " "); // replace newlines and tabs with spaces
        if (s.length() > n) {
            s = s.substring(0, n - 3) + "..."; // truncate string
        }
        return String.format("%-" + n + "s", s); // make n chars long, padded with spaces.
    }
}