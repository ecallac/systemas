/**
 * 
 */
package com.security.client.bean;

import java.util.List;
import java.util.Map;

/**
 * @author efrain.calla
 *
 */
public class ModuleBean {
	private String name;
	private String moduleVersion;
	private String description;
	private List<PermissionBean> permissions;
	private Map<String,String> rolesByPermission;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<PermissionBean> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<PermissionBean> permissions) {
		this.permissions = permissions;
	}
	public Map<String, String> getRolesByPermission() {
		return rolesByPermission;
	}
	public void setRolesByPermission(Map<String, String> rolesByPermission) {
		this.rolesByPermission = rolesByPermission;
	}
	public String getModuleVersion() {
		return moduleVersion;
	}
	public void setModuleVersion(String moduleVersion) {
		this.moduleVersion = moduleVersion;
	}
	
}
