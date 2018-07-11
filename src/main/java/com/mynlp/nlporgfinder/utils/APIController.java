/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynlp.nlporgfinder.utils;

import com.mynlp.nlporgfinder.core.NLPOrgFinder;
import com.mynlp.nlporgfinder.core.ONLPTrainer;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by
 */
@RequestMapping("/api")
@RestController
public class APIController {

    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, path="/findOrgs")
    public ResponseBuilder findOrganizations(@Valid @RequestBody String text) {
        ResponseBuilder responseBuilder = new ResponseBuilder();
        responseBuilder.setStatus(Boolean.TRUE);
        NLPOrgFinder nlpOrgFinder = new NLPOrgFinder();
        responseBuilder.setData(nlpOrgFinder.initOrgFinder(text));
        return responseBuilder;
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, path="/trainModel")
    public ResponseBuilder trainModel(@Valid @RequestBody String text) throws FileNotFoundException, UnsupportedEncodingException {
        ResponseBuilder responseBuilder = new ResponseBuilder();
        responseBuilder.setStatus(Boolean.TRUE);
        ONLPTrainer onlpTrainer = new ONLPTrainer();
        onlpTrainer.trainModel(text);
        return responseBuilder;
    }
}
