/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mynlp.nlporgfinder.utils;

import com.mynlp.nlporgfinder.NlporgfinderApplication;
import java.nio.file.Paths;
import org.springframework.boot.system.ApplicationHome;

/**
 *
 * @author User
 */
public final class Constants {

    public Constants() {
//        System.out.println(getParentDirectoryFromJar());
    }

    String training_text_path = getParentDirectoryFromJar() + "/training.txt";
    ApplicationHome home = new ApplicationHome(NlporgfinderApplication.class);
    String model_path = home.getDir() + "/orgs-model.bin";
    String token_model = home.getDir() + "/en-token.bin";

    public String getModel_path() {
        return model_path;
    }

    public void setModel_path(String model_path) {
        this.model_path = model_path;
    }

    public String getTraining_text_path() {
        return training_text_path;
    }

    public void setTraining_text_path(String training_text_path) {
        this.training_text_path = training_text_path;
    }

    public String getToken_model() {
        return token_model;
    }

    public void setToken_model(String token_model) {
        this.token_model = token_model;
    }

    public String getParentDirectoryFromJar() {
        String dirtyPath = getClass().getResource("").toString();
        String jarPath = dirtyPath.replaceAll("^.*file:/", ""); //removes file:/ and everything before it
        jarPath = jarPath.replaceAll("jar!.*", "jar"); //removes everything after .jar, if .jar exists in dirtyPath
        jarPath = jarPath.replaceAll("%20", " "); //necessary if path has spaces within
        if (!jarPath.endsWith(".jar")) { // this is needed if you plan to run the app using Spring Tools Suit play button. 
            jarPath = jarPath.replaceAll("/classes/.*", "/classes/");
        }
        String directoryPath = Paths.get(jarPath).getParent().toString(); //Paths - from java 8
        return directoryPath;
    }
}
