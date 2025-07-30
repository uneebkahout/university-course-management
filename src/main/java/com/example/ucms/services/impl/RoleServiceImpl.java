package com.example.ucms.services.impl;

import com.example.ucms.DTO.role.roleRequest;
import com.example.ucms.DTO.role.roleResponse;
import com.example.ucms.entity.Roles;
import com.example.ucms.exception.ResourceNotFoundException;
import com.example.ucms.repository.RoleRepository;
import com.example.ucms.services.RoleServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleServices {
    private final RoleRepository roleRepository;
    @Override
    public void createRole(roleRequest request) {
        Roles ro = Roles.builder()
                .role_name(request.role_name())
                .build();
        mapToResponse(roleRepository.save(ro));
    }

    @Override
    public List<roleResponse> getAllRoles() {
        return roleRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public void updateRole(int role_id, roleRequest request) {
        Roles ro=roleRepository.findById(role_id).orElseThrow(() -> new ResourceNotFoundException("Role not Found with this id" + role_id));
        ro.setRole_name(request.role_name());
        mapToResponse(roleRepository.save(ro));
    }

    @Override
    public void deleteRole(int role_id) {
        if(!roleRepository.existsById(role_id)){
            throw   new ResourceNotFoundException("Role Not found" + role_id);
        }
        roleRepository.deleteById(role_id);
    }

private roleResponse mapToResponse(Roles r){
        return  new roleResponse(r.getRole_id() , r.getRole_name());
}
}
