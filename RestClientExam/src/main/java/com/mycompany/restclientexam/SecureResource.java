package com.mycompany.restclientexam;

import com.mycompany.restclientcommon.EmployeeBean;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author atsushi
 */
@Path("secure")
public class SecureResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public SecureResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.restclientexam.GenericResource
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_XML)
    public EmployeeBean searchEmployee(@QueryParam("id") long id) {
        if (id == 007L) {
            return new EmployeeBean(007L,"Bond","MI6");
        }
        return new EmployeeBean(999L,"TEST_USER","TEST_DIVISION");
    }
}