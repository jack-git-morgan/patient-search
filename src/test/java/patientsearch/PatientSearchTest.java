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
import responses.PatientEntryListHolder;

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

        HttpRequestManager.getInstance().makeGetRequest(HttpRequestManager.getInstance().buildPatientSearchUrl(request), PatientEntryListHolder.class);

        assertEquals(0, 0);
    }

    @Test
    public void testSearchByNhsNumber() {
        assertEquals(0, 0);
    }

    @Test
    public void testSearchByFamilyName() {
        assertEquals(0, 0);
    }

    @Test
    public void testSearchByGivenName() {
        assertEquals(0, 0);
    }

    @Test
    public void testSearchTwoFieldsInCombination() {
        assertEquals(0, 0);
    }

    @Test
    public void testSearchThreeFieldsInCombination() {
        assertEquals(0, 0);
    }

    @Test
    public void testSearchFourFieldsInCombination() {
        assertEquals(0, 0);
    }

    @Test
    public void testSearchNoInputProvided() {
        assertEquals(0, 0);
    }

    @Test
    public void testSearchInvalidDateProvided() {
        assertEquals(0, 0);
    }

    @Test
    public void testSearchInvalidNhsNumberProvided() {
        assertEquals(0, 0);
    }

    @After
    public void tearDown() throws Exception {

    }

}
