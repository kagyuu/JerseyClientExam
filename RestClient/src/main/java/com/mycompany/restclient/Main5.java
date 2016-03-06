/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restclient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;

/**
 * Multipart POST & Recv Stream Example.
 * @author atsushi
 */
public class Main5 {
    public static void main(String[] args) {
        try {
            JerseyClient4 client = new JerseyClient4();
            Response res = client.convert("Hanako", "female", "src/main/resources/440px-Lenna.png");
            System.out.println(res.getStatus());
            System.out.println(res.getHeaders());
            
            // get contents
            InputStream body = res.readEntity(InputStream.class);
            
            File tmp = new File("/tmp/tmp.png");
            tmp.createNewFile();
            OutputStream out = new FileOutputStream(tmp);
            byte[] buf = new byte[1024];
            int len;
            while ((len = body.read(buf)) > 0) {
                out.write(buf,0,len);
            }
            out.close();
            res.close();
            
        } catch (ClientErrorException | IOException ex) {
            Logger.getLogger(Main5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
