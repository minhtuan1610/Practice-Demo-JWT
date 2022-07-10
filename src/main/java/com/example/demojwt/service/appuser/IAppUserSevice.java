package com.example.demojwt.service.appuser;

import com.example.demojwt.model.AppUser;
import com.example.demojwt.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserSevice extends IGeneralService<AppUser>, UserDetailsService {
}
