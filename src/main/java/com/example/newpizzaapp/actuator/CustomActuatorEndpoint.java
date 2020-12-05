package com.example.newpizzaapp.actuator;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Zeby dzialal Actuator trzeba uzyc w Additional command line parameters opcji -parameters
@Component
@Endpoint(id = "customEndpoint")
public class CustomActuatorEndpoint {

    private Map customParameters = new ConcurrentHashMap<>();

    public CustomActuatorEndpoint() {
        customParameters.put("lastDeploymentDate", "17.05.2015");
        customParameters.put("lastDeploymentChange", "12.05.2015");
    }

    @ReadOperation
    public Map customParameters() {
        return customParameters;
    }

    @ReadOperation
    public String customParameter(@Selector String name) {
        return (String) customParameters.get(name);
    }

    @WriteOperation
    public void addParameter(@Selector String name, String value) {
        customParameters.put(name, value);
    }

    @DeleteOperation
    public void deleteParameter(@Selector String name) {
        customParameters.remove(name);
    }


}
