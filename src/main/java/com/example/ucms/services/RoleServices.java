package com.example.ucms.services;

import com.example.ucms.DTO.role.roleRequest;
import com.example.ucms.DTO.role.roleResponse;

import java.util.List;


public interface RoleServices {
        void createRole(roleRequest request);
        List<roleResponse> getAllRoles();
        roleResponse updateRole(int role_id  ,roleRequest request);
        void deleteRole(int role_id);

}
