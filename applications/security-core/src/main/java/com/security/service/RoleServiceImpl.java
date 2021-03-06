/**
 * 
 */
package com.security.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.dao.RoleDao;
import com.security.domain.Role;
import com.security.utils.BeanParser;

/**
 * @author EFRAIN
 * @dateCreated 5 mar. 2017 13:14:04
 */
@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleDao roleDao;
	/* (non-Javadoc)
	 * @see com.security.service.RoleService#findRolesByUserName(java.lang.String)
	 */
	public List<Role> findRolesByUserName(String userName) {
		// TODO Auto-generated method stub
		return roleDao.findRolesByUserName(userName);
	}

	/* (non-Javadoc)
	 * @see com.security.service.RoleService#findRolesByUserId(java.lang.Long)
	 */
	public List<Role> findRolesByUserId(Long id) {
		// TODO Auto-generated method stub
		return roleDao.findRolesByUserId(id);
	}

	/* (non-Javadoc)
	 * @see com.security.service.RoleService#findRoleById(java.lang.Long)
	 */
	public Role findRoleById(Long id) {
		// TODO Auto-generated method stub
		return (Role) roleDao.findById(Role.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Role> findAllRoles() {
		// TODO Auto-generated method stub
		return (List<Role>) roleDao.findAll(Role.class);
	}

	public void save(Role role) {
		// TODO Auto-generated method stub
		
		if (role.getId()==null) {
			roleDao.save(role);
		}else{
			Role roleStored = findRoleById(role.getId());
			if (roleStored!=null) {
				if (!roleStored.getEnabled().equals(role.getEnabled())) {
					roleStored.setEnabled(role.getEnabled());
					roleStored.setUpdatedBy(role.getUpdatedBy());
				} else {
					roleStored = (Role) BeanParser.parseBetweenObjects(role, roleStored, null);
				}
				roleDao.save(roleStored);
			}
		}
	}

	public void delete(Role role) {
		// TODO Auto-generated method stub
		roleDao.delete(role);
	}

	@Override
	public List<Role> findByEnabled(String enabled) {
		// TODO Auto-generated method stub
		return roleDao.findByEnabled(enabled);
	}

}
