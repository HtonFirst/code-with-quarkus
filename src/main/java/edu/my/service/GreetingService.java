package edu.my.service;

import io.vertx.core.json.impl.JsonUtil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {

    public String greeting(String name) {
        return "hello " + name;
    }


}
