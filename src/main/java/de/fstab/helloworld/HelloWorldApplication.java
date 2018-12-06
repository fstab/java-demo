package de.fstab.helloworld;

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
        String result = "";
        result = result + "ENVIRONMENT\n";
        result = result + "-----------\n";
        for (var e : new TreeMap<>(System.getenv()).entrySet()) {
            // key length 30 so that KUBERNETES_SERVICE_PORT_HTTPS fits in
            // value length 42 so that the overall table fits in an 80 char terminal window
            result = result + String.format("| %-30s | %-42s |\n", stripAndTruncate(30, e.getKey()), stripAndTruncate(42, e.getValue()));
        }
        return result;
    }

    private String stripAndTruncate(int length, String s) {
        return truncate(length, stripNewlinesAndTabs(s));
    }

    private String stripNewlinesAndTabs(String s) {
        if (s == null) {
            return s;
        }
        return s.replaceAll("\\s+", " ");
    }

    private String truncate(int length, String s) {
        if (s != null && s.length() > length) {
            return s.substring(0, length - 3) + "...";
        }
        return s;
    }
}
