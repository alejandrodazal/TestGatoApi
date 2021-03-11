package com.co.elondono.Services;

import com.co.elondono.Modelos.Gato;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GatoService {

    public static void verGatos() throws IOException {
        OkHttpClient client = new OkHttpClient()
                //.newBuilder()
                //.build();
        ;
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String mensaje = response.body().string();
        mensaje = mensaje.substring(1, mensaje.length());
        mensaje = mensaje.substring(0, mensaje.length()-1);

        Gson gato = new Gson();
        Gato g = gato.fromJson(mensaje, Gato.class);

        // redimenzionar
        Image image = null;
        try {
            URL url = new URL(g.getUrl());
            image = ImageIO.read(url);
            ImageIcon fondoGato = new ImageIcon(image);
            if (fondoGato.getIconWidth() > 800) {
                Image fondo = fondoGato.getImage();
                Image fondoModificado = fondo.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(fondoModificado);
            }
        }catch (IOException e){
            System.out.println(e);
        }

    }
}
