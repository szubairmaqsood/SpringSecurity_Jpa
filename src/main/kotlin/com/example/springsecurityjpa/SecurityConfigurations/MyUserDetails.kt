package com.example.springsecurityjpa.SecurityConfigurations

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class MyUserDetails:UserDetails {
    val userName:String;
    constructor(_userName:String){
        this.userName = _userName;
    }
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
      return Arrays.asList(SimpleGrantedAuthority("ROLE_USER"))
    }

    override fun getPassword(): String {
        return "pass";
    }

    override fun isAccountNonExpired(): Boolean {
       return true;
    }

    override fun getUsername(): String {
        return this.username;
    }

    override fun isAccountNonLocked(): Boolean {
        return true;
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true;
    }

    override fun isEnabled(): Boolean {
       return true;
    }
}