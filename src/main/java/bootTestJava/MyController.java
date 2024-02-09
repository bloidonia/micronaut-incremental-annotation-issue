package bootTestJava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MyController {

    @GetMapping
    String hello() {
        return "hallo";
    }
}