package com.mycompany.restclient;
 
import com.mycompany.restclientcommon.EmployeeBean;

/**
 * GET Example.
 * @author atsushi
 */
public class Main {
    public static void main(String[] args) {
        JerseyClient client = new JerseyClient();
        EmployeeBean bean = client.search(123L);
        System.out.println(bean);
         
        EmployeeBean bean2 = client.search(999L);
        System.out.println(bean2);
    }
}