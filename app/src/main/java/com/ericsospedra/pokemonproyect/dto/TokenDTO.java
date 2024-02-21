package com.ericsospedra.pokemonproyect.dto;

import com.ericsospedra.pokemonproyect.models.Token;

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

    @Override
    public String toString() {
        return "TokenDTO{" +
                "token='" + token + '\'' +
                '}';
    }
}
