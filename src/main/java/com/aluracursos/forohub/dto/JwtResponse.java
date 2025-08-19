package com.aluracursos.forohub.dto;

public class JwtResponse {
    private String token;
    private String tokenType;
    private long expiresInSeconds;

    public JwtResponse(String token, String tokenType, long expiresInSeconds) {
        this.token = token;
        this.tokenType = tokenType;
        this.expiresInSeconds = expiresInSeconds;
    }

    // ✅ Getters (para que Spring pueda serializar a JSON)
    public String getToken() {
        return token;
    }
    public String getTokenType() {
        return tokenType;
    }
    public long getExpiresInSeconds() {
        return expiresInSeconds;
    }
}
