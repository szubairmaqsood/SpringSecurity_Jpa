package com.example.springsecurityjpa.SecurityConfigurations

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class myUserDetailsService:UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
       return MyUserDetails(username);
    }
}