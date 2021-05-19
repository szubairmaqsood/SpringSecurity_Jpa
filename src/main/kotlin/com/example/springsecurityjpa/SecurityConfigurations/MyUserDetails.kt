package com.example.springsecurityjpa.SecurityConfigurations

import com.example.springsecurityjpa.Models.SystemUsers
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import java.util.stream.Collectors

class MyUserDetails:UserDetails {
    var userName:String;
    var _password:String;
    var active:Boolean;
    var authorities:List<GrantedAuthority>;

    constructor(user:SystemUsers){
        this.userName = user.userName;
        this._password = user.password;
        this.active = user.active;
        this.authorities = Arrays.stream(user.roles.split(',').toTypedArray())
                                  .map((::SimpleGrantedAuthority))
                                  .collect(Collectors.toList());
    }
    override fun getAuthorities():Collection<out GrantedAuthority> {
      return this.authorities;
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
       return this.active;
    }
}