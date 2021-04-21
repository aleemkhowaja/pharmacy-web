package com.pharm.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PaswordEncoder {
    public static  void main(String args[])
    {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String p = bCryptPasswordEncoder.encode("123");
        System.out.println(p);
    }
}
