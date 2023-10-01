/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

/**
 *
 * @author jackw
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientEntryListHolder {

    private ArrayList<PatientEntry> entry;

    public ArrayList<PatientEntry> getEntry() {
        return entry;
    }

    public void setEntry(ArrayList<PatientEntry> entry) {
        this.entry = entry;
    }
}
