package com.example.springsecurityjpa.Repository

import com.example.springsecurityjpa.Models.SystemUsers
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepositroy:JpaRepository<SystemUsers,Int> {
    fun findByUserName(userName:String):Optional<SystemUsers>;
}