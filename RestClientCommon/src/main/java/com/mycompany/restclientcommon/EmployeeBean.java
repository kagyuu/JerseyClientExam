/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restclientcommon;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author atsushi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "employee")
public class EmployeeBean {
    private long id;
    private String name;
    private String dept;
}
