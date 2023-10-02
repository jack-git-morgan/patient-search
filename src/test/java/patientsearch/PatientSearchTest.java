/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientsearch;

import api.HttpRequestManager;
import javax.ws.rs.core.Response;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import requests.SearchPatientRequest;
import requests.SearchPatientRequestDate;
import responses.PatientEntryListHolder;
import responses.PatientEntryResource;

/**
 *
 * @author jackw
 */
public class PatientSearchTest {
    
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSearchByDateOfBirth() {

        SearchPatientRequest request = new SearchPatientRequest();
        SearchPatientRequestDate dob = new SearchPatientRequestDate();

        dob.setDay("20");
        dob.setMonth("09");
        dob.setYear("2008");

        request.setDateOfBirth(dob);

        PatientEntryListHolder result = (PatientEntryListHolder) HttpRequestManager.getInstance().
                makeGetRequest(HttpRequestManager.getInstance()
                        .buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(result.getEntry().size(), 1);

        PatientEntryResource resource = result.getEntry().get(0).getResource();

        assertEquals(resource.getBirthDate(), "2008-09-20");
        assertEquals(resource.getName().get(0).getFamily().get(0), "CHISLETT");
        assertEquals(resource.getName().get(0).getGiven().get(0), "OCTAVIA");
        assertEquals(resource.getIdentifier().get(0).getValue(), "9449305552");
    }

    @Test
    public void testSearchByNhsNumber() {

        SearchPatientRequest request = new SearchPatientRequest();
        request.setNhsNumber("9449305501");

        PatientEntryListHolder result = (PatientEntryListHolder) HttpRequestManager.getInstance().
                makeGetRequest(HttpRequestManager.getInstance()
                        .buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(result.getEntry().size(), 1);

        PatientEntryResource resource = result.getEntry().get(0).getResource();

        assertEquals(resource.getBirthDate(), "2009-05-21");
        assertEquals(resource.getName().get(0).getFamily().get(0), "HODGE");
        assertEquals(resource.getName().get(0).getGiven().get(0), "DONNA");
        assertEquals(resource.getIdentifier().get(0).getValue(), "9449305501");
    }

    @Test
    public void testSearchByFamilyName() {

        SearchPatientRequest request = new SearchPatientRequest();
        request.setFamilyName("VINECOMBE");

        PatientEntryListHolder result = (PatientEntryListHolder) HttpRequestManager.getInstance().
                makeGetRequest(HttpRequestManager.getInstance()
                        .buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(result.getEntry().size(), 1);

        PatientEntryResource resource = result.getEntry().get(0).getResource();

        assertEquals(resource.getBirthDate(), "2003-09-01");
        assertEquals(resource.getName().get(0).getFamily().get(0), "VINECOMBE");
        assertEquals(resource.getName().get(0).getGiven().get(0), "GARNET");
        assertEquals(resource.getIdentifier().get(0).getValue(), "9449303517");
    }

    @Test
    public void testSearchByGivenName() {

        SearchPatientRequest request = new SearchPatientRequest();
        request.setGivenName("TRAVION");

        PatientEntryListHolder result = (PatientEntryListHolder) HttpRequestManager.getInstance().
                makeGetRequest(HttpRequestManager.getInstance()
                        .buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(result.getEntry().size(), 1);

        PatientEntryResource resource = result.getEntry().get(0).getResource();

        assertEquals(resource.getBirthDate(), "2006-12-22");
        assertEquals(resource.getName().get(0).getFamily().get(0), "IVER");
        assertEquals(resource.getName().get(0).getGiven().get(0), "TRAVION");
        assertEquals(resource.getIdentifier().get(0).getValue(), "9449304599");
    }

    @Test
    public void testSearchTwoFieldsInCombination() {

        SearchPatientRequest request = new SearchPatientRequest();
        request.setFamilyName("DOUBLE");
        request.setGivenName("SPIKE");

        PatientEntryListHolder result = (PatientEntryListHolder) HttpRequestManager.getInstance().
                makeGetRequest(HttpRequestManager.getInstance()
                        .buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(result.getEntry().size(), 1);

        PatientEntryResource resource = result.getEntry().get(0).getResource();

        assertEquals(resource.getBirthDate(), "1933-09-10");
        assertEquals(resource.getName().get(0).getFamily().get(0), "DOUBLE");
        assertEquals(resource.getName().get(0).getGiven().get(0), "SPIKE");
        assertEquals(resource.getIdentifier().get(0).getValue(), "9449310025");

    }

    @Test
    public void testSearchThreeFieldsInCombination() {

        SearchPatientRequest request = new SearchPatientRequest();
        request.setFamilyName("SUBBU");
        request.setGivenName("JODY");
        request.setNhsNumber("9449306311");

        PatientEntryListHolder result = (PatientEntryListHolder) HttpRequestManager.getInstance().
                makeGetRequest(HttpRequestManager.getInstance()
                        .buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(result.getEntry().size(), 1);

        PatientEntryResource resource = result.getEntry().get(0).getResource();

        assertEquals(resource.getBirthDate(), "1997-01-19");
        assertEquals(resource.getName().get(0).getFamily().get(0), "SUBBU");
        assertEquals(resource.getName().get(0).getGiven().get(0), "JODY");
        assertEquals(resource.getIdentifier().get(0).getValue(), "9449306311");
    }

    @Test
    public void testSearchFourFieldsInCombination() {

        SearchPatientRequest request = new SearchPatientRequest();
        request.setFamilyName("FOOL");
        request.setGivenName("APRIL");
        request.setNhsNumber("9449310092");
        SearchPatientRequestDate dob = new SearchPatientRequestDate();

        dob.setDay("01");
        dob.setMonth("04");
        dob.setYear("1974");

        request.setDateOfBirth(dob);

        PatientEntryListHolder result = (PatientEntryListHolder) HttpRequestManager.getInstance().
                makeGetRequest(HttpRequestManager.getInstance()
                        .buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(result.getEntry().size(), 1);

        PatientEntryResource resource = result.getEntry().get(0).getResource();

        assertEquals(resource.getBirthDate(), "1974-04-01");
        assertEquals(resource.getName().get(0).getFamily().get(0), "FOOL");
        assertEquals(resource.getName().get(0).getGiven().get(0), "APRIL");
        assertEquals(resource.getIdentifier().get(0).getValue(), "9449310092");

    }

    @Test
    public void testSearchMultipleResults() {

        SearchPatientRequest request = new SearchPatientRequest();
        request.setFamilyName("DOUBLE");

        PatientEntryListHolder result = (PatientEntryListHolder) HttpRequestManager.getInstance().
                makeGetRequest(HttpRequestManager.getInstance()
                        .buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(result.getEntry().size(), 2);

        PatientEntryResource resourceOne = result.getEntry().get(0).getResource();
        PatientEntryResource resourceTwo = result.getEntry().get(1).getResource();

        assertEquals(resourceOne.getBirthDate(), "1933-09-10");
        assertEquals(resourceOne.getName().get(0).getFamily().get(0), "DOUBLE");
        assertEquals(resourceOne.getName().get(0).getGiven().get(0), "SPIKE");
        assertEquals(resourceOne.getIdentifier().get(0).getValue(), "9449310025");
        
        assertEquals(resourceTwo.getBirthDate(), "1933-09-10");
        assertEquals(resourceTwo.getName().get(0).getFamily().get(0), "DOUBLE");
        assertEquals(resourceTwo.getName().get(0).getGiven().get(0), "GODRIC");
        assertEquals(resourceTwo.getIdentifier().get(0).getValue(), "9449310017");
    }

    @After
    public void tearDown() throws Exception {

    }
}
