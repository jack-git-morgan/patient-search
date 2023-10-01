/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author jackw
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientEntry {
    
    private PatientEntryResource resource;

    public PatientEntryResource getResource() {
        return resource;
    }

    public void setResource(PatientEntryResource resource) {
        this.resource = resource;
    }
}
