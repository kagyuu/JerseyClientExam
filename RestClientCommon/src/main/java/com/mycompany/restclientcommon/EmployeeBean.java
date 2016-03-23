package com.mycompany.restclientcommon;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "employee")
public class EmployeeBean {
    private long id;
    private String name;
    private String dept;
}
