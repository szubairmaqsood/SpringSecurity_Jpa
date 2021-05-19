package com.example.springsecurityjpa.Models

import javax.persistence.*

@Entity
@Table(name="SystemUsers")
class SystemUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Int=0;
    var userName:String="";
    var password:String="";
    var active:Boolean=true;
    var roles:String="";
}