package main.tripservice.enums;

public enum RolesEnum {

    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    ACCOUNTING("ACCOUNTING"),
    SQUAD("SQUAD"),
    USER("USER");

    private final String roleType;

    RolesEnum(String roleType){
        this.roleType = roleType;
    }
    public String getRoleType(){
        return roleType;
    }

}
