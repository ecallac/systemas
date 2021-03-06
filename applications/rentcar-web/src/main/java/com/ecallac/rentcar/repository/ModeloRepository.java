/**
 * 
 */
package com.ecallac.rentcar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecallac.rentcar.domain.Modelo;

/**
 * @author efrain.calla
 *
 */
@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
	List<Modelo> findAllByStatus(String status);
	
	@Modifying
	@Query("update Modelo o "
			+ "set o.status =:status, o.updatedBy =:updatedBy, o.dateUpdated =:dateUpdated, o.version =(o.version+1) "
			+ "where o.id = :id")
	int updateStatus(
			@Param("status") String status
			,@Param("updatedBy") String updatedBy
			,@Param("dateUpdated") Date dateUpdated
			,@Param("id") Long id);
	
	List<Modelo> findByMarcaIdAndStatus(Long marcaId, String status);
	
}
