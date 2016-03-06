package com.mycompany.restclient;
 
import com.mycompany.restclientcommon.EmployeeBean;

/**
 * HTTPS Example.
 * @author atsushi
 */
public class Main2 {
    public static void main(String[] args) {
        JerseyClient2 client = new JerseyClient2();
        EmployeeBean bean = client.search(123L);
        System.out.println(bean);
         
        EmployeeBean bean2 = client.search(999L);
        System.out.println(bean2);
    }
}