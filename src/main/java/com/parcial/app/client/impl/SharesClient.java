package com.parcial.app.client.impl;

import com.parcial.app.client.Client;
import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Implementation of http client for shares API
 * @author sebastianGalvis
 */
@Primary
@Component("sClient")
public class SharesClient implements Client {

    /**
     * APIKEY: temporally we'll use the 'demo' apikey, real apikey is on "DONTREADME.txt" (not uploaded archive).
     */
    private static final String API_KEY = "demo";
    private static final String API_URL = "https://www.alphavantage.co/query?";
    private OkHttpClient client;

    /**
     * Creates the instance
     */
    public SharesClient() {
        this.client = new OkHttpClient();
    }

    /**
     * Get the history of a share using its identifier (i.e "MCFT")
     * @param identifier share's identifier
     * @return Share's history
     * @throws JSONException if something was wrong with API or API KEY
     */
    public JSONObject getHistoryByIdentifier(String identifier) throws JSONException {
        String FUNCTION = "TIME_SERIES_INTRADAY";
        String SYMBOL = identifier;
        String INTERVAL = "5min";
        String url = API_URL
                + "function="+FUNCTION
                + "&symbol="+SYMBOL
                + "&inverval="+INTERVAL
                + "&apikey="+API_KEY;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Error en API: " + response);
            }
            String respuesta = response.body().string();
            JSONObject obj = new JSONObject(respuesta);
            return obj;
        } catch (Exception e){
            throw new JSONException("Error en API generando la solicitud");
        }

    }

}
