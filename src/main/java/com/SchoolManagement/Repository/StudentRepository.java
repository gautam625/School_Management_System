package com.SchoolManagement.Repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.SchoolManagement.Model.FeeDetails;
import com.SchoolManagement.Model.MarksDetails;
import com.SchoolManagement.Model.PersonalDetail;
import com.SchoolManagement.Model.Student;
import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	@Query("select max(admissionNo) from Student s")
	int maxAdmissionNo();
	
//                                    Insert Record	
	@Query("insert into Student(admissionNo,name,standard,place,mobile)values (:admissionNo,:name,:standard,:place,:mobile)")
	@Modifying
	@Transactional
	int saveStudent(@Param("admissionNo")int admissionNo,@Param("name")String name,@Param("standard")String standard,@Param("place")String place,@Param("mobile")String mobile);
	
	@Query("insert into PersonalDetail(admissionNo,guardianName,email,dob,aadhar,gender,date,image)values (:admissionNo,:guardianName,:email,:dob,:aadhar,:gender,:date,:image)")
	@Modifying
	@Transactional
	int savePersonalDetail(@Param("admissionNo")int admissionNo,@Param("guardianName")String guardianName,@Param("email")String email,@Param("dob")LocalDate dob,@Param("aadhar")String aadhar,@Param("gender")String gender,@Param("date")LocalDate date,@Param("image")byte[] image);
	
	@Query("insert into MarksDetails(admissionNo,quarterly,halfYearly,annual)values (:admissionNo,:quarterly,:halfYearly,:annual)")
	@Modifying
	@Transactional
	int saveMarksDetails(@Param("admissionNo")int admissionNo,@Param("quarterly")double quarterly,@Param("halfYearly")double halfYearly,@Param("annual")double annual);
	
	@Query("insert into FeeDetails(admissionNo,admissionFee,quater1Fee,quater2Fee,quater3Fee)values (:admissionNo,:admissionFee,:quater1Fee,:quater2Fee,:quater3Fee)")
	@Modifying
	@Transactional
	int saveFeeDetails(@Param("admissionNo")int admissionNo,@Param("admissionFee")double admissionFee,@Param("quater1Fee")double quater1Fee,@Param("quater2Fee")double quater2Fee,@Param("quater3Fee")double quater3Fee);

	
	
//                                     Get Record
	@Query("select s from Student s where s.admissionNo=:admissionNo")
	Student getStudent(int admissionNo);
	
	@Query("select m from MarksDetails m where m.admissionNo=:admissionNo")
	MarksDetails getMarksDetails(int admissionNo);
	
	@Query("select f from FeeDetails f where f.admissionNo=:admissionNo")
	FeeDetails getFeeDetails(int admissionNo);
    
	@Query("select p from PersonalDetail p where p.admissionNo=:admissionNo")
	PersonalDetail getPersonalDetail(int admissionNo);

	
	
//                                      Search Record
	@Query("select s from Student s where s.admissionNo=:admissionNo")
	List<Student> searchStudentsRecord(@Param("admissionNo")int admissionNo);
	
	
	
//                                      Delete Record
	@Modifying
	@Transactional
	@Query("delete from Student s where s.admissionNo=:admissionNo")
	void deleteStudent(int admissionNo);
    
	@Modifying
	@Transactional
	@Query("delete from PersonalDetail p where p.admissionNo=:admissionNo")
	void deletePersonalDetail(int admissionNo);
	
	@Modifying
	@Transactional
	@Query("delete from MarksDetails m where m.admissionNo=:admissionNo")
	void deleteMarksDetails(int admissionNo);
    
	@Modifying
	@Transactional
	@Query("delete from FeeDetails f where f.admissionNo=:admissionNo")
	void deleteFeeDetails(int admissionNo);

	
	
//                                     Update Record	
	@Query("update Student s set s.name=:name, s.standard=:standard, s.place=:place, s.mobile=:mobile where s.admissionNo=:admissionNo")
	@Modifying
	@Transactional
	void updateStudent(@Param("name")String name,@Param("standard")String standard,@Param("place")String place,@Param("mobile")String mobile,@Param("admissionNo")int admissionNo);
    
	@Query("update PersonalDetail p  set  p.guardianName=:guardianName, p.email=:email, p.dob=:dob ,p.aadhar=:aadhar, p.gender=:gender, p.date=:date ,p.image=:image where p.admissionNo=:admissionNo")
	@Modifying
	@Transactional
	void updatePersonalDetail(@Param("guardianName")String guardianName,@Param("email")String email,@Param("dob")LocalDate dob,@Param("aadhar")String aadhar,@Param("gender")String gender,@Param("date")LocalDate date,@Param("image")byte[] image,@Param("admissionNo")int admissionNo);
	@Query("update PersonalDetail p  set  p.guardianName=:guardianName, p.email=:email, p.dob=:dob ,p.aadhar=:aadhar, p.gender=:gender, p.date=:date where p.admissionNo=:admissionNo")
	@Modifying
	@Transactional
	void updatePersonalDetail(@Param("guardianName")String guardianName,@Param("email")String email,@Param("dob")LocalDate dob,@Param("aadhar")String aadhar,@Param("gender")String gender,@Param("date")LocalDate date,@Param("admissionNo")int admissionNo);
    
	@Query("update  MarksDetails m set m.quarterly=:quarterly, m.halfYearly=:halfYearly, m.annual=:annual where m.admissionNo=:admissionNo")
	@Modifying
	@Transactional
	void updateMarksDetails(@Param("quarterly")double quarterly,@Param("halfYearly")double halfYearly,@Param("annual")double annual,@Param("admissionNo")int admissionNo);
    
	@Query("update FeeDetails f set f.admissionFee=:admissionFee, f.quater1Fee=:quater1Fee,f.quater2Fee=:quater2Fee, f.quater3Fee=:quater3Fee where f.admissionNo=:admissionNo")
	@Modifying
	@Transactional
	void updateFeeDetails(@Param("admissionFee")double admissionFee,@Param("quater1Fee")double quater1Fee,@Param("quater2Fee")double quater2Fee,@Param("quater3Fee")double quater3Fee,@Param("admissionNo")int admissionNo);

    
	
	
	
}