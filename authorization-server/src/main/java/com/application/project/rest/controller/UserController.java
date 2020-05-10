package com.application.project.rest.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    //@PreAuthorize("#oauth2.hasScope('user_info') and hasRole('ADMIN')")
    @GetMapping("/api/user/me")
    public Map<String, Object> user(HttpServletRequest request, Principal principal) {
        System.out.println("In / user/me request.getUserPrincipal() " + request.getUserPrincipal());
        System.out.println("In / user/me principal " + principal);
       /* // System.out.println("In / hashCode " +principal.hashCode());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("In / user/me authentication " + authentication);
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
            System.out.println("User principal name =" + userPrincipal.getUsername());
            System.out.println("Is user enabled =" + userPrincipal.isEnabled());
        }*/
      /*  Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Hunaid Hsusain");
        return map;*/

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", principal.getName());
        if(principal.getName().equals("hunaid")){
            map.put("id", "hunaidee");
            map.put("email", "hunaidee007@gmail.com");
        }else{
            map.put("id", "johnee");
            map.put("email", "johnee007@gmail.com");
        }

        return map;
        //return Collections.singletonMap("name", principal.getName());
    }
}