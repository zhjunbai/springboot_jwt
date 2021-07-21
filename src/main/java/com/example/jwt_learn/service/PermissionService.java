package com.example.jwt_learn.service;

import com.example.jwt_learn.dao.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    public Set<String> findPermissionsByUserId(int id){
        return permissionDao.findPermissionsByUserId(id);
    }
    public Set<String> findPermissionsByUsername(String username){
        return permissionDao.findPermissionsByUsername(username);
    }
    public String findPermissionByName(String name){
        return permissionDao.findPermissionByName(name);
    }
}
