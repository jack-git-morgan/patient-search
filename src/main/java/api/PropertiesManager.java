/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author jackw
 */
public class PropertiesManager {

    // Note - if this were a "real" project I would read the properties in from a file and have this singleton manage them 
    // instead of declaring them here. 
    public String BASE_URL = "https://59ae2c9240f849f6ac.develop.eu-west-2.quickfhir.cloud/FHIR/Patient";
    public String API_KEY = "eXyaAcJ9fhpLuhB42YwKQOJ7XgmVYOaP";
    public String BEARER_TOKEN = "dGVzdHVzZXJAYmxhY2twZWFyLmNvbTphcmVxdWVzdA";

    private static PropertiesManager instance;

    public static PropertiesManager getInstance() {
        if (instance == null) {
            instance = new PropertiesManager();
        }

        return instance;
    }
}
