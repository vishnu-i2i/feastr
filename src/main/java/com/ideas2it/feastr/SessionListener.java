package com.ideas2it.feastr;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionAttributeListener;

public class SessionListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        System.out.println(session.getAttribute("customerId"));
        if (session.getAttribute("customerId") != null) {
    	    System.out.println("Login Time = " + LocalDateTime.now());
    	}
    	System.out.println("Session Created:: ID="+session.getId());
        
    }

    public void attributeRemoved(HttpSessionBindingEvent sessionEvent) {
    	System.out.println("Session Destroyed:: ID="+sessionEvent.getSession().getId());
    	System.out.println("Logout Time = " + LocalDateTime.now());
    }
    
   public void attributeReplaced(HttpSessionBindingEvent event){}
	
}

