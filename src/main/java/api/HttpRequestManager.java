/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import requests.SearchPatientRequest;
import requests.SearchPatientRequestDate;
import responses.PatientEntryListHolder;

/**
 *
 * @author jackw
 */
public class HttpRequestManager {

    private static HttpRequestManager instance;

    private HttpRequestManager() {

    }

    public static HttpRequestManager getInstance() {
        if (instance == null) {
            instance = new HttpRequestManager();
        }

        return instance;
    }

    public Object makeGetRequest(String requestUrl, Class transformer) {

        if (requestUrl == null) return null;
        
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        PropertiesManager propertiesManager = PropertiesManager.getInstance();
        Object searchResults = null;

        HttpGet httpGet = new HttpGet(requestUrl);
        httpGet.addHeader("x-api-key", propertiesManager.API_KEY);
        httpGet.addHeader("Authorization", "Basic " + propertiesManager.BEARER_TOKEN);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(response.getEntity());
            
            ObjectMapper objectMapper = new ObjectMapper();
            searchResults = objectMapper.readValue(responseBody, transformer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException ex) {
                Logger.getLogger(HttpRequestManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return searchResults;
    }

    public String buildPatientSearchUrl(SearchPatientRequest request) {
        
        PropertiesManager propertiesManager = PropertiesManager.getInstance();
        String requestUrl = propertiesManager.BASE_URL + "?";
        
        if (request.getFamilyName() != null && request.getFamilyName().trim().length() > 0) {
            requestUrl += "family=" + request.getFamilyName() + "&";
        }

        if (request.getGivenName() != null && request.getGivenName().trim().length() > 0) {
            requestUrl += "given=" + request.getGivenName() + "&";
        }

        if (request.getNhsNumber() != null && request.getNhsNumber().trim().length() > 0) {
            requestUrl += "identifier=https://fhir.nhs.uk/Id/nhs-number%7C" + request.getNhsNumber() + "&";
        }

        SearchPatientRequestDate dob = request.getDateOfBirth();

        if (dob != null && Integer.valueOf(dob.getYear()) > 0 && Integer.valueOf(dob.getMonth()) > 0 && Integer.valueOf(dob.getYear()) > 0) {
            requestUrl += "birthdate=" + dob.getYear() + "-" + dob.getMonth() + "-" + dob.getDay() + "&";
        }
        
        String url = StringUtils.chop(requestUrl);
        
        if (!url.contains("?")) url = null;

        return url;
    }
}
