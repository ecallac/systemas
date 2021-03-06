/**
 * 
 */
package com.security.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.dao.PermissionDao;
import com.security.domain.Module;
import com.security.domain.Permission;
import com.security.domain.Role;
import com.security.utils.BeanParser;

/**
 * @author EFRAIN
 * @dateCreated 26 mar. 2017 12:47:44
 */
@Transactional
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionDao permissionDao;
	@Autowired
	ModuleService moduleService;
	/* (non-Javadoc)
	 * @see com.security.service.ModuleService#save(com.security.domain.Module)
	 */
	
	public void save(Permission permission) {
		if (permission.getId()==null) {
			permissionDao.save(permission);
		}else{
			Permission permissionStored = findPermissionById(permission.getId());
			if (permissionStored!=null) {
				if (!permissionStored.getEnabled().equals(permission.getEnabled())) {
					permissionStored.setEnabled(permission.getEnabled());
					permissionStored.setUpdatedBy(permission.getUpdatedBy());
				}else{
					permissionStored = (Permission) BeanParser.parseBetweenObjects(permission, permissionStored, null);
					
					if (permission.getParentPermission()!=null) {
						Permission parentPermissionStored = findPermissionById(permission.getParentPermission().getId());
						permissionStored.setParentPermission(parentPermissionStored);
					}else{
						permissionStored.setParentPermission(null);
					}
					
					if (permission.getModule()!=null) {
						Module moduleStored = moduleService.findModuleById(permission.getModule().getId());
						permissionStored.setModule(moduleStored);
					}
				}
				permissionDao.save(permissionStored);
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.security.service.ModuleService#delete(com.security.domain.Module)
	 */
	public void delete(Permission permission) {
		permissionDao.delete(permission);

	}

	/* (non-Javadoc)
	 * @see com.security.service.ModuleService#findById(java.lang.Long)
	 */
	public Permission findPermissionById(Long id) {
		// TODO Auto-generated method stub
		return (Permission) permissionDao.findById(Permission.class, id);
	}

	/* (non-Javadoc)
	 * @see com.security.service.ModuleService#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<Permission> findAllPermissions() {
		// TODO Auto-generated method stub
		return (List<Permission>) permissionDao.findAll(Permission.class);
	}

	/* (non-Javadoc)
	 * @see com.security.service.ModuleService#findByStatusId(java.lang.Long)
	 */
	public List<Permission> findPermissionsByEnabled(String enabled) {
		// TODO Auto-generated method stub
		return permissionDao.findByEnabled(enabled);
	}

	public List<Permission> findPermissionsByModuleId(Long id) {
		// TODO Auto-generated method stub
		return permissionDao.findByModuleId(id);
	}

	public List<Permission> findPermissionByRoleId(Long id) {
		// TODO Auto-generated method stub
		return permissionDao.findPermissionByRoleId(id);
	}

	@Override
	public List<Permission> findEnabledPermissionsByModuleId(Long id) {
		// TODO Auto-generated method stub
		return permissionDao.findEnabledPermissionsByModuleId(id);
	}
	
	@Override
	public Map<String, String> getRolesOfPermissionByModuleId(Long id) {
		List<Permission> permissions = findEnabledPermissionsByModuleId(id);
		
		Map<String,List<String>> permissionBeans = new HashMap<String,List<String>>();
		
		for (Permission permission : permissions) {
			List<Role> rolesDB = permission.getRoles();
			
			List<String> roles = new ArrayList<String>();
			for (Role role : rolesDB) {
				roles.add(role.getNameWithPrefix());
			}
			permissionBeans.put(permission.getPath(), roles);	
		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		int c = 1;
		for (Map.Entry<String,List<String>> entry : permissionBeans.entrySet()){
			List<String> list = entry.getValue();
			
			StringBuffer buffer = new StringBuffer();
			for (String string : list) {
				if (c > 1) {
					buffer.append(",");
				}
				buffer.append("'"+string+"'");
				c++;
			}
			map.put(entry.getKey(), buffer.toString());
			c=0;
		}
		
		System.out.println(map);
		return map;
	}
}
