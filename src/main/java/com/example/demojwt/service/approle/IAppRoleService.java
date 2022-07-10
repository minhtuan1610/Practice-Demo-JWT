package com.example.demojwt.service.approle;

import com.example.demojwt.model.AppRole;
import com.example.demojwt.service.IGeneralService;

public interface IAppRoleService extends IGeneralService<AppRole> {
    AppRole findByName(String name);
}
