package com.alok91340.securityservice.utils;

import lombok.Data;

/**
 * @author alok91340
 *
 */
@Data
public class JwtAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}