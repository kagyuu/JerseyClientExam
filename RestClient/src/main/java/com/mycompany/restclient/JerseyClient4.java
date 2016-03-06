package com.mycompany.restclient;

import com.mycompany.restclientcommon.EmployeeBean;
import java.io.File;
import java.io.FileNotFoundException;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jaxb.internal.JaxbStringReaderProvider;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;
/**
 * Jersey REST client generated for REST resource:PostResource [post]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient client = new NewJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author atsushi
 */
public class JerseyClient4 {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RestClientExam/webresources/post";

    public JerseyClient4() {
        ClientConfig config = new ClientConfig();
        config.register(MultiPartFeature.class);
        config.register(JaxbStringReaderProvider.class);

        client = javax.ws.rs.client.ClientBuilder.newClient(config);
        webTarget = client.target(BASE_URI);
    }

    public EmployeeBean search(long id) throws ClientErrorException {
        WebTarget resource = webTarget.path("search");
        Form form = new Form();
        form.param("id",Long.toString(id));
        return resource
                .request(javax.ws.rs.core.MediaType.APPLICATION_XML)
                .post(Entity.form(form), EmployeeBean.class);
    }
    
    public Response convert(String name, String sex, String photo) throws ClientErrorException, FileNotFoundException {
        WebTarget resource = webTarget.path("convert");
        MultiPart multiPart = new FormDataMultiPart()
                .field("name", name)
                .field("sex", sex)
                .bodyPart(new FileDataBodyPart("photo", new File(photo)));
        
        return resource
                .request(javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM)
                .post(Entity.entity(multiPart, multiPart.getMediaType()));
    }

    public void close() {
        client.close();
    }
    
}

