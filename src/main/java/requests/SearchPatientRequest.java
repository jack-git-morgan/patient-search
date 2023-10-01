/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

import java.time.LocalDate;

/**
 *
 * @author jackw
 */
public class SearchPatientRequest {
    
    private SearchPatientRequestDate dateOfBirth;
    private String nhsNumber;
    private String familyName;
    private String givenName;

    public SearchPatientRequestDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(SearchPatientRequestDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNhsNumber() {
        return nhsNumber;
    }

    public void setNhsNumber(String nhsNumber) {
        this.nhsNumber = nhsNumber;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
}
