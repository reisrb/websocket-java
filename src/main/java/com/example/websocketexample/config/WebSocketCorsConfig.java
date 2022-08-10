package com.example.websocketexample.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class WebSocketCorsConfig extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

      if (request.getRequestURI().contains("websocket")) {
          response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
          response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
          response.setHeader("Access-Control-Max-Age", "3600");
          response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
          response.addHeader("Access-Control-Expose-Headers", "xsrf-token");

          response.setHeader("Access-Control-Allow-Credentials", "true");
          if ("OPTIONS".equals(request.getMethod())) {
              response.setStatus(HttpServletResponse.SC_OK);
          } else {
              filterChain.doFilter(request, response);
          }
      } else {
          filterChain.doFilter(request, response);
      }

  }
}
