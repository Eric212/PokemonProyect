package com.ericsospedra.pokemonproyect.utils;

import android.content.Context;
import android.content.res.Resources;

import com.ericsospedra.pokemonproyect.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvatarRecovery {
    public static List<Integer> recuperarAvatares(Context context) {
        List<Integer> avatares = new ArrayList<>();
        Resources res = context.getResources();
        Class<?> drawableClass = R.drawable.class;
        Field[] fields = drawableClass.getFields();
        for (Field field : fields) {
            try {
                String name = field.getName();
                if (name.startsWith("avatar")) {
                    int resourceId = field.getInt(null);
                    avatares.add(resourceId);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return avatares;
    }
    public static int recuperarAvatarParaBot(Context context){
        List<Integer> avatares = recuperarAvatares(context);
        Collections.shuffle(avatares);
        return avatares.get(0);
    }
}
