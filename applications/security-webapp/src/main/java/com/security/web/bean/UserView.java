/**
 * 
 */
package com.security.web.bean;

import java.util.Date;

/**
 * @author efrain.calla
 *
 */
public class UserView extends UserEditView {
	
	private Date activationDate;
	private Date inactivationDate;
	
	private String entityName;
	
	public Date getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	public Date getInactivationDate() {
		return inactivationDate;
	}
	public void setInactivationDate(Date inactivationDate) {
		this.inactivationDate = inactivationDate;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
}
