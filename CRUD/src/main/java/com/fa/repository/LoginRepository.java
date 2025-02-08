package com.fa.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fa.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long>{
	
	@Query(value = "SELECT username FROM login_credentials WHERE username=?1",nativeQuery = true)
	String getName(String userName);
	
	@Query(value = "SELECT password FROM login_credentials WHERE username=?1",nativeQuery = true)
	String getPassword(String userName);

//	List<LoginEntity> getdata();

	

}
