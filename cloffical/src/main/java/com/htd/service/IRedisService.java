package com.htd.service;


public interface IRedisService {  
    
	public void set(String key, Object value);  

    public Object get(String key);  

      
} 
