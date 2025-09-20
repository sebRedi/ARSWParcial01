package com.parcial.app.client.impl;

import okhttp3.*;
import org.json.JSONObject;

public class ChatGPTClient {
    private static final String API_KEY = "API_KEY";
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private OkHttpClient client;

    public ChatGPTClient() {
        this.client = new OkHttpClient();
    }

    public String enviarMensaje(String mensaje) throws Exception {
        JSONObject json = new JSONObject();
        json.put("model", "gpt-4o-mini"); // o el modelo que se use
        json.put("messages", new org.json.JSONArray()
                .put(new JSONObject().put("role", "user").put("content", mensaje))
        );

        RequestBody body = RequestBody.create(
                json.toString(),
                MediaType.parse("application/json")
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .post(body)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Error en API: " + response);
            }
            String respuesta = response.body().string();
            JSONObject obj = new JSONObject(respuesta);
            return obj.getJSONArray("choices")
                    .getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");
        }
    }
}