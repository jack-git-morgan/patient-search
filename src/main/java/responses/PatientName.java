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
public class PatientName {

    private List<String> given;
    private List<String> family;

    public List<String> getGiven() {
        return given;
    }

    public void setGiven(List<String> given) {
        this.given = given;
    }

    public List<String> getFamily() {
        return family;
    }

    public void setFamily(List<String> family) {
        this.family = family;
    }
}
