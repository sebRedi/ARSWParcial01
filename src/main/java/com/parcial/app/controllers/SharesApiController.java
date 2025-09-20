package com.parcial.app.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.parcial.app.services.SharesServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for Shares Api REST
 * @author sebastianGalvis
 */
@RestController
@RequestMapping("/shares")
public class SharesApiController {

    @Autowired
    private SharesServices sharesServices;

    /**
     * Get history of a share using its identifier
     * @param identifier share's identifier (i.e. "MSFT")
     * @return share's history on a JSON body
     */
    @GetMapping("/{identifier}")
    public ResponseEntity<JSONObject> getHistoryByIdentifier(@PathVariable("identifier") String identifier){
        try {
            JSONObject body = sharesServices.getHistoryByIdentifier(identifier);
            return  ResponseEntity.ok(body);
        } catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
