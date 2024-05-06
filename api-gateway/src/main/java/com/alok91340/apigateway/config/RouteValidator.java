package com.alok91340.apigateway.config;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteValidator {

    public static final List<String> openApiEndPoints = List.of(
            "/auth/register",
            "/auth/token",
            "/eureka"
    );

}
