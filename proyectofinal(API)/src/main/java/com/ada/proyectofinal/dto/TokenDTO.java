package com.ada.proyectofinal.dto;

import com.ada.proyectofinal.entities.Token;

public class TokenDTO {
    private String token;

    public TokenDTO() {
    }

    public static TokenDTO fromToken(Token token){
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token.getToken());
        return tokenDTO;
    }

    public TokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
