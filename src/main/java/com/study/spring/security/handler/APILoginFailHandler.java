package com.study.spring.security.handler;

import java.io.IOException;
import java.util.Map;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import java.io.PrintWriter;

@Log4j2
public class APILoginFailHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
	
		log.info("login fail...." + exception);
		
		Gson gson = new Gson();
	    
	    String jsonStr = gson.toJson(Map.of("error", "ERROR_LOGIN*여기야"));

	    response.setContentType("application/json");
	    PrintWriter printWriter = response.getWriter();
	    printWriter.println(jsonStr);
	    printWriter.close();    
	
	}

}
