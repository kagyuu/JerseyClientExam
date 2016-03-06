package com.mycompany.restclient;

import com.mycompany.restclientcommon.EmployeeBean;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jaxb.internal.JaxbStringReaderProvider;
//import org.glassfish.jersey.client.filter.HttpBasicAuthFilter;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        NewJerseyClient1 client = new NewJerseyClient1();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author atsushi
 */
public class JerseyClient3 {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RestClientExam/webresources/secure";

    public JerseyClient3(String username, String password) {
        ClientConfig config = new ClientConfig();
        config.register(JaxbStringReaderProvider.class);
        config.register(HttpAuthenticationFeature.basic(username, password));
        client = javax.ws.rs.client.ClientBuilder.newClient(config);
        webTarget = client.target(BASE_URI);
    }

    public EmployeeBean search(long id) throws ClientErrorException {
        WebTarget resource = webTarget.path("search").queryParam("id", id);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(EmployeeBean.class);
    }

    public void close() {
        client.close();
    }
}
