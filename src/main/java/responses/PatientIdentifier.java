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
public class PatientIdentifier {
    
    private String value;
    private String system;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}
