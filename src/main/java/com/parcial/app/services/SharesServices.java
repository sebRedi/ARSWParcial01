package com.parcial.app.services;


import com.parcial.app.client.Client;
import com.parcial.app.client.impl.SharesClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Service class for Shares API
 * @author sebastianGalvis
 */
@Service
public class SharesServices {

    /**
     * Injected httpClient
     */
    @Qualifier("sClient")
    private final Client client;

    @Autowired
    public SharesServices(SharesClient client){
        this.client = client;
    }


    /**
     * Obtains the body from the api key
     * @param identifier share's identifier
     * @return share's history
     */
    public JSONObject getHistoryByIdentifier(String identifier) throws Exception {
        try{
            return client.getHistoryByIdentifier(identifier);
        } catch (JSONException e){
            throw e;
        }
    }
}
