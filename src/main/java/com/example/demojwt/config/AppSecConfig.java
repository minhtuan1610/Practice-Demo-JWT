package com.example.demojwt.config;

import com.example.demojwt.service.appuser.IAppUserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class AppSecConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IAppUserSevice appUserSevice;


}
