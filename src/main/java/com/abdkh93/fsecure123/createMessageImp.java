package com.abdkh93.fsecure123;

import javax.jws.WebService;
import java.net.MalformedURLException;
import java.net.URL;

@WebService(endpointInterface = "com.abdkh93.fsecure123.createMessage")
public class createMessageImp implements createMessage{

    // Implementation of the message creation service
    @Override
    public String setMessage(String title, String content, String sender, String url) throws MalformedURLException {

        String output = "";
        URL Url = new URL(url);
        Message msg = MessageStore.createMessage(title, content, sender, Url);
        if(msg != null)
            output = "Message added successfully...";
        else
            output = "Failed to add message.";
        return output;
    }
}
