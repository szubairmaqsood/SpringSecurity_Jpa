package com.example.springsecurityjpa.SecurityConfigurations

import com.example.springsecurityjpa.Models.SystemUsers
import com.example.springsecurityjpa.Repository.UserRepositroy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service
class myUserDetailsService:UserDetailsService {
    var userRepository: UserRepositroy;
    @Autowired
    constructor(_userRepository: UserRepositroy){
        this.userRepository = _userRepository;
    }
    override fun loadUserByUsername(username: String): UserDetails {
       //return MyUserDetails(username);
       var user:Optional<SystemUsers> = this.userRepository.findByUserName(username);
        return user.map(::MyUserDetails).get();
    }
}