package com.mycompany.restclientexam;

import com.mycompany.restclientcommon.EmployeeBean;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * REST Web Service
 *
 * @author atsushi
 */
@Path("post")
public class PostResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PostResource
     */
    public PostResource() {
    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_XML)
    public EmployeeBean searchEmployee(@FormParam("id") long id) {
        if (id == 123L) {
            return new EmployeeBean(123L,"Takako","Accounting");
        }
        return new EmployeeBean(999L,"TEST_USER","TEST_DIVISION");
    }

    @POST
    @Path("convert")
    @Consumes("multipart/form-data")
    @Produces({MediaType.APPLICATION_OCTET_STREAM})
    public Response convert(
        @FormDataParam("photo") InputStream file,
        @FormDataParam("photo") FormDataContentDisposition fileDisposition,
        @FormDataParam("name") String name,
        @FormDataParam("sex") String sex) {
 
        return Response.ok(file)
                .header("Content-disposition", "attachment; filename=" + fileDisposition.getFileName())
                .build();
    }
}
