package com.application.project.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class OrganizationUser extends User {
    private  String firstName;
    private  String middleName;
    private  String lastName;
    private  long phNumber;
    private  long altPhNumber;


    public OrganizationUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String firstName, String middleName, String lastName, long phNumber, long altPhNumber) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phNumber = phNumber;
        this.altPhNumber = altPhNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getPhNumber() {
        return phNumber;
    }

    public long getAltPhNumber() {
        return altPhNumber;
    }
}
