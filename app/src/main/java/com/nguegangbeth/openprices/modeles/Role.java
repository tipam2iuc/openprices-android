package com.nguegangbeth.openprices.modeles;

import java.util.Objects;

public class Role {

    private enum Type{
        gestionnaire,
        consommateur;
    }
    private int idRole;
    private Type roleType;

    public Role() {
    }

    public Role(int idRole, Type roleType) {
        this.idRole = idRole;
        this.roleType = roleType;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public Type getRoleType() {
        return roleType;
    }

    public void setRoleType(Type roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return idRole == role.idRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole);
    }
}
