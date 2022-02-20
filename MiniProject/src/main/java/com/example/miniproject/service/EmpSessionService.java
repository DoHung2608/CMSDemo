//package com.example.miniproject.service;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTCreationException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.example.miniproject.model.session.EmployeeInfo;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpSession;
//import java.util.Map;
//
//@Service
//public class EmpSessionService {
//    private final String EMP_INFO = "EMP_INFO";
//
//    public boolean setEmployeeSession(EmployeeInfo employeeInfo) {
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession httpSession = attr.getRequest().getSession(true);
//        return true;
//    }
//    public EmployeeInfo getEmployeeSession() {
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession httpSession = attr.getRequest().getSession(true);
//        EmployeeInfo employeeInfo = (EmployeeInfo) httpSession.getAttribute(EMP_INFO);
//        if (employeeInfo == null) {
//            return null;
//        }
//        return employeeInfo;
//    }
//
//    public void clearSession() {
//        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//        HttpSession httpSession = attr.getRequest().getSession(true);
//        httpSession.removeAttribute(EMP_INFO);
//    }
//}
