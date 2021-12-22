package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.role.RoleCreateReq;
import fpt.trainining.movietheatre.entity.Role;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.RoleRepository;
import fpt.trainining.movietheatre.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired private RoleRepository roleRepository;

    @Override
    public Collection<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot find role id: " + id));
    }

    @Override
    public Role create(RoleCreateReq roleCreateReq) {
        Role role = Role.builder()
                .roleName(roleCreateReq.getRoleName())
                .build();
        return roleRepository.save(role);
    }

    @Override
    public void remove(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found role name " +roleName));
    }
}
