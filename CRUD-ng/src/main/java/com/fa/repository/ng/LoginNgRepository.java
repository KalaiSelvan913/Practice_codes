package com.fa.repository.ng;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fa.entity.ng.LoginNgEntity;

@Repository
public interface LoginNgRepository extends JpaRepository<LoginNgEntity, Long>{
	
	@Query(value = "SELECT username FROM angular_login WHERE username=?1",nativeQuery = true)
	String getName(String userName);
	
	@Query(value="SELECT password FROM angular_login WHERE username=?1", nativeQuery=true)
	String getPasswordValue(String userName);

}
