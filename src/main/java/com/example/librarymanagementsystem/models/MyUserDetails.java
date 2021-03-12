package com.example.librarymanagementsystem.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private Long id;
    private String email;
    private String password;
    private List <GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.email = email;
        this.password = password;
        this.authorities = Arrays.stream(user.getRoles().toString().split(","))
        .map(SimpleGrantedAuthority:: new)
        .collect(Collectors.toList());
    }

//    public static  MyUserDetails build(User user){
//        List<GrantedAuthority> authorities = Arrays.stream(user.getRoles().split)
//
//        return new MyUserDetails(
//                user.getId(),
//                user.getEmail(),
//                user.getPassword(),
//                authorities
//        );
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return Arrays.asList(new SimpleGrantedAuthority("ROLE_PATRON"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
