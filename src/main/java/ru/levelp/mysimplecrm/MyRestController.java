package ru.levelp.mysimplecrm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/greeting")
public class MyRestController {

    @GetMapping("/{name}")
    public String sayHello(@PathVariable(value = "name", required = false) String name) {
        return "Hello, " + ofNullable(name).orElse("world!");
    }

}
