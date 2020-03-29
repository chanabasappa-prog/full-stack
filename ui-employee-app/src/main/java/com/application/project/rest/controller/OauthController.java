package com.application.project.rest.controller;

import com.application.project.AWTToken;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.Principal;

@Controller()
public class OauthController {

    @RequestMapping("/securedPage")
    public String securedPage(Model model, Principal principal) {
        System.out.println("in SecuredPage");
        return "index";
    }
    @RequestMapping("/")
    public String index(Model model, Principal principal) {
        System.out.println("in Index");
        return "index";
    }

    /*@GetMapping("oauth-code")
    public void getPhoneBookById(@RequestParam String code, @RequestParam String state, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        System.out.println("--- code : " + code + " , state : "+ state );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("client_id", "clientIdPassword");
        map.add("client_secret", "secret");
        map.add("redirect_uri", "http://localhost:8181/oauth-code");
        map.add("grant_type", "authorization_code");
        map.add("code", code);
        map.add("state", state);
        System.out.println("--- map : "+map );

        String auth = "clientIdPassword" + ":" + "secret";
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")) );
        String authHeader = "Basic " + new String( encodedAuth );

        headers.add("Authorization",authHeader);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AWTToken> response = restTemplate.postForEntity( "http://localhost:9090/oauth/token", request , AWTToken.class );
        System.out.println(response.getBody());
        System.out.println("Access Toke n : " +response.getBody().getAccess_token());

        httpServletRequest.getSession().setAttribute("access_token", response.getBody().getAccess_token());
        httpServletResponse.addCookie(new Cookie("access_token_cookie",response.getBody().getAccess_token()));

        try {
            httpServletResponse.sendRedirect("http://localhost:8181");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
