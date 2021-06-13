package com.spring.retry;
 
import java.util.Date;

import javax.naming.ServiceUnavailableException;

import org.springframework.stereotype.Service;
 
@Service
public class BackendAdapterImpl implements BackendAdapter {
 
    @Override
    public String getBackendResponse(boolean simulateretry, boolean simulateretryfallback) throws Exception  {
    	if (simulateretry) {
            System.out.println(new Date()+" Simulateretry is true, so try to simulate exception scenario.");
 
            if (simulateretryfallback) {
                throw new Exception(
                        "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
            }
           int random=2;
            if (random % 2 == 0) {
                throw new Exception("Don't worry!! Just Simulated for Spring-retry..");
            }
        }
        return "Hello from Remote Backend!!!";
    }
 
    @Override
    public String getBackendResponseFallback(Exception e) {
    	
        System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";
    }
}