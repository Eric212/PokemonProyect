package com.ericsospedra.pokemonproyect.models;

import com.ericsospedra.pokemonproyect.interfaces.IApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static String ip;
    private static String puerto;
    private static IApiService instance;
    private RestClient(){
    }
    public synchronized static IApiService getInstance(){
        if(instance == null){
            ip = "192.168.3.47";
            puerto = "8080";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://"+ip+":"+puerto+"/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = retrofit.create(IApiService.class);
        }
        return instance;
    }

    public static String getIp() {
        return ip;
    }

    public static String getPuerto() {
        return puerto;
    }

    public static void setIp(String ip) {
        RestClient.ip = ip;
    }

    public static void setPuerto(String puerto) {
        RestClient.puerto = puerto;
    }
}
