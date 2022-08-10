package com.mustafa.eurekaclient;

import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {
    @RequestMapping("/greeting")
    String greeting();

    @RequestMapping("/name")
    String name();

}
