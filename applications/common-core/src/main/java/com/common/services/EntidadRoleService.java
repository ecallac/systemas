/**
 * 
 */
package com.common.services;

import com.common.domain.EntidadRol;
import com.common.utils.BusinessException;

/**
 * @author efrain.calla
 *
 */
public interface EntidadRoleService {
	void save(EntidadRol entidadRol) throws BusinessException ;
	EntidadRol getEntidadRolByEntidadId(Long entidadId,String tipoEntidadRol);
	EntidadRol findEntidadRolById(Long id);
}
