package com.mycompany.restclient;
 
import com.mycompany.restclientcommon.EmployeeBean;

/**
 * POST Example.
 * @author atsushi
 */
public class Main4 {
    public static void main(String[] args) {
        JerseyClient4 client = new JerseyClient4();
        EmployeeBean bean = client.search(123L);
        System.out.println(bean);
         
        EmployeeBean bean2 = client.search(999L);
        System.out.println(bean2);
    }
}