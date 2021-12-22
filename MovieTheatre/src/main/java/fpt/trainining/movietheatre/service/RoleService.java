package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.role.RoleCreateReq;
import fpt.trainining.movietheatre.entity.Role;

import java.util.Collection;

public interface RoleService {
    Collection<Role> findAll();
    Role findById(Integer id);
    Role create(RoleCreateReq roleCreateReq);
    void remove(Integer id);
    Role findByRoleName(String roleName);
}
