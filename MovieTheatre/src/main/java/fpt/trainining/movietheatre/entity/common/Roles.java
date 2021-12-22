package fpt.trainining.movietheatre.entity.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Roles {
    CUSTOMER("CUSTOMER"), MEMBER("MEMBER"), EMPLOYEE("EMPLOYEE"), ADMIN("ADMIN");
    public String roleName;
}
