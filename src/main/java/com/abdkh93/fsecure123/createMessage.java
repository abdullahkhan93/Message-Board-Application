package com.abdkh93.fsecure123;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.net.MalformedURLException;

// Message creation service Endpoint Interface
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface createMessage {

    @WebMethod
    String setMessage(String title, String content, String sender, String url) throws MalformedURLException;
}