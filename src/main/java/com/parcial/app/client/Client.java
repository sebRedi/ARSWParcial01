package com.parcial.app.client;


import org.json.JSONException;
import org.json.JSONObject;

/**
 * Injectable interface for http client
 * @author sebastianGalvis
 */
public interface Client{
    public JSONObject getHistoryByIdentifier(String identifier) throws JSONException;
}