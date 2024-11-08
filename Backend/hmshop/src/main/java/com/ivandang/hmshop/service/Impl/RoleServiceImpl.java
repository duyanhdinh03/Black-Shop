package com.ivandang.hmshop.service.Impl;

import com.ivandang.hmshop.model.Role;
import com.ivandang.hmshop.repository.RoleRepository;
import com.ivandang.hmshop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
