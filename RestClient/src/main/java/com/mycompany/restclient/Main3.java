package com.mycompany.restclient;
 
import com.mycompany.restclientcommon.EmployeeBean;

/**
 * Basic Auth Example.
 * @author atsushi
 */
public class Main3 {
    public static void main(String[] args) {
        JerseyClient3 client = new JerseyClient3("aho","password");
        EmployeeBean bean = client.search(007L);
        System.out.println(bean);
    }
}