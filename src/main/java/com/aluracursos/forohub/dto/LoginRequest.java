package com.aluracursos.forohub.dto;

public class LoginRequest {
    private String username;
    private String password;

    // ✅ Getters y setters (para que .username y .password funcionen)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}