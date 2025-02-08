package com.fa.repository.ng;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fa.entity.ng.CrudNgEntity;

@Repository
public interface CrudNgRepository extends JpaRepository<CrudNgEntity, Long>{

	@Query(value="SELECT * FROM register WHERE name=?1", nativeQuery = true)
	CrudNgEntity getDataByName(String name);
	
	@Query(value="SELECT * FROM register WHERE name=?1", nativeQuery=true)
	Long getIdByName(String name);
	
	@Query(value="SELECT * FROM register WHERE  email=?1", nativeQuery = true)
	CrudNgEntity getDataByEmail(String email);
//	SELECT * FROM data.register WHERE email="kalai@gmail.com";
//	
//	@Query(value="SELECT email FROM register WHERE email=?1", nativeQuery = true)
//	String getEmailValue(String email);
//	
//	@Query(value="SELECT password FROM register WHERE password=?1", nativeQuery=true)
//	String getPasswordValue(String password);

	@Query(value="CALL data.emp_seq_code()", nativeQuery=true)
	String getEmpId();
	
}
  