package com.abdkh93.fsecure123;

import java.net.URL;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Message object with all the neccessary data members
// Data members: title, content, sender, url
// Addiitonal id attribute also added for enhancements in the future (not required for now as such)
// Checks on the lengths of strings in overloaded constructor (Strings stripped to length 50 if longer)

@XmlRootElement
public class Message {

    private Long id;

    private String title;

    private String content;

    private String sender;

    @MessageDetailedView
    private URL url;

    // Default Constructor
    public Message(){

    }

    // Overloaded Constructor
    public Message(Long id, String title, String content, String sender, URL url){

        this.id = id;

        // Limit content of strings
        if(title.length() > 50)
            title = title.substring(0,50);
        if(content.length() > 50)
            content = content.substring(0,50);
        if(sender.length() > 50)
            sender = sender.substring(0,50);

        this.title = title;
        this.content = content;
        this.sender = sender;
        this.url = url;
    }

    // Getter and Setters
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getSender(){
        return this.sender;
    }

    public void setSender(String sender){
        this.sender = sender;
    }

    public URL getUrl(){
        return this.url;
    }

    public void setUrl(URL url){
        this.url = url;
    }
}