package api;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import requests.SearchPatientRequest;
import requests.SearchPatientRequestDate;
import responses.ErrorResponse;
import responses.PatientEntryListHolder;

/**
 *
 * @author jackw
 */
@Path("resource")
public class ResourceServlet {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search_patients")
    public Response searchPatients(SearchPatientRequest request) {

        SearchPatientRequestDate dob = request.getDateOfBirth();

        boolean validDate = true;
        boolean dobSupplied = false;
        
        int day = Integer.valueOf(dob.getDay());
        int month = Integer.valueOf(dob.getMonth());
        int year = Integer.valueOf(dob.getYear());

        if (day > 0 || month > 0 || year > 0) {

            if (day == 0 || month == 0 || year == 0) {
                validDate = false;
            }

            if (String.valueOf(dob.getDay()).length() != 2
                    || String.valueOf(dob.getMonth()).length() != 2
                    || String.valueOf(dob.getYear()).length() != 4) {
                validDate = false;
            }

            if (validDate) {
                dobSupplied = true;
            }
        }

        if (!validDate) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("Date provided is invalid. Date must be supplied in the following format DD-MM-YYYY"))
                    .build();
        }

        if (request.getNhsNumber() != null && request.getNhsNumber().trim().length() > 0 && request.getNhsNumber().trim().length() != 10) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("NHS number can only contain digits"))
                    .build();
        }

        if (!dobSupplied && ((request.getNhsNumber() == null || request.getNhsNumber().trim().length() == 0)
                && (request.getFamilyName() == null || request.getFamilyName().trim().length() == 0)
                && (request.getGivenName() == null || request.getGivenName().trim().length() == 0))) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponse("No search terms provided. You must provide at least one search value"))
                    .build();
        }

        HttpRequestManager manager = HttpRequestManager.getInstance();
        String requestUrl = manager.buildPatientSearchUrl(request);

        return Response.status(Response.Status.OK)
                .entity(manager.makeGetRequest(requestUrl, PatientEntryListHolder.class))
                .build();
    }
}
