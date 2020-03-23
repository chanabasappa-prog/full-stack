package com.application.project.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class SimpleUserDetailsService implements UserDetailsService {
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List authorities = new ArrayList<>();

        OrganizationUser organizationUser = new OrganizationUser("john", passwordEncoder().encode("123"),true,true,true,true,authorities,"Hunaid","Iqbal","Husain",808790866,88888);
        return organizationUser;
    }
}
