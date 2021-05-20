package com.example.demo.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.demo.security.Permission.*;

public enum ROLES {

    ADMIN(Sets.newHashSet(SHOP_READ,SHOP_UPDATE,
            SHOP_DELETE,CUSTOMER_UPDATE,
            CUSTOMER_READ,CUSTOMER_DELETE)),
    SHOP(Sets.newHashSet(SHOP_CREATE,SHOP_READ,
            SHOP_UPDATE,SHOP_DELETE)),
    CUSTOMER(Sets.newHashSet(CUSTOMER_CREATE,CUSTOMER_UPDATE
            ,CUSTOMER_READ));

    private final Set<Permission> permissions;

    ROLES(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
