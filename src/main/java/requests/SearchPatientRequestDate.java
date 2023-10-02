/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

/**
 *
 * @author jackw
 */
public class SearchPatientRequestDate {
    
    private String day;
    private String month;
    private String year;

    public String getDay() {
        if (this.day == null) this.day = "0";
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        
        if (this.month == null) this.month = "0";
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        if (this.year == null) this.year = "0";
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    
}
