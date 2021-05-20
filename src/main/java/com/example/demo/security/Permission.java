package com.example.demo.security;

public enum Permission {

    CUSTOMER_CREATE("customer:create"),
    CUSTOMER_UPDATE("customer:update"),
    CUSTOMER_DELETE("customer:delete"),
    CUSTOMER_READ("customer:read"),
    SHOP_CREATE("shop:create"),
    SHOP_UPDATE("shop:update"),
    SHOP_DELETE("shop:delete"),
    SHOP_READ("shop:read");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
