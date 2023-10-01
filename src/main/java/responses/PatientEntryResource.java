/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author jackw
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientEntryResource {
    
    private List<PatientName> name;
    private String birthDate;
    private List<PatientIdentifier> identifier;

    public List<PatientName> getName() {
        return name;
    }

    public void setName(List<PatientName> name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<PatientIdentifier> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<PatientIdentifier> identifier) {
        this.identifier = identifier;
    }
}
