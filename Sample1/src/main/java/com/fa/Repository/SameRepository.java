package com.fa.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fa.Entity.SampleEntity;

@Repository
public interface SameRepository extends JpaRepository<SampleEntity, Long>{
	
//@Query(name="call data.emp_seq_code()", nativeQuery=true)
//String getempId();
	
	@Query(value="CALL data.emp_seq_code()", nativeQuery=true)
	String getseqId();
	
	@Query(value="SELECT * From sample WHERE empid=?1", nativeQuery=true)
	SampleEntity getByEmpId(String empId);
	
	@Query(value="SELECT * FROM data.sample WHERE created_by=:createdBy or created_date=:CreatedDate", nativeQuery=true)
	ArrayList<SampleEntity> findFile(String createdBy, String CreatedDate);
	
//	@Query(value="SELECT email FROM data.sample", nativeQuery=true)
//	SampleEntity getDataByEmail(String email);
	SampleEntity findByEmail(String email);
	
	SampleEntity findByEmpId(String empId);
	SampleEntity findByUserName(String userName);
	String findByPassword(String userName);
	Optional<SampleEntity> findById(Long id);
	SampleEntity findByCreatedByOrCreatedDate(String createdBy, String createdDate);
	
	
	SampleEntity findByUserNameAndPassword(String userName,String password);
}
