/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author iyefreed
 */
public class UserSession {
    
    private static String id;
    private static String profileId;
    private static String roleId;
    private static String deptId;
    
    public static void setId(String id) {
        UserSession.id = id;
    }
    
    public static String getId() {
        return id;
    }
    
    public static void setRoleId(String roleId) {
        UserSession.roleId = roleId;
    }
    
    public static String getRoleId() {
        return roleId;
    }
    
    public static void setDeptId(String deptId) {
        UserSession.deptId = deptId;
    }
    
    public static String getDeptId() {
        return deptId;
    }
    
}
