/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responses;

/**
 *
 * @author jackw
 */
public class ErrorResponse {
    
    private String errorMessage;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
