package com.SchoolManagement.Services;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.SchoolManagement.Model.FeeDetails;
import com.SchoolManagement.Model.MarksDetails;
import com.SchoolManagement.Model.PersonalDetail;
import com.SchoolManagement.Model.Student;
import com.SchoolManagement.Repository.StudentRepository;


@Service
public class StudentServices {
	   
	    @Autowired
	    private StudentRepository repository;
	
	   
     		
//                     Display all Students  	
		public List<Student> getAllStudent(){
			return repository.findAll();
		}
		
		
	  	
//                     Insert new Students		   
	 	public String saveStudent(Student s) {	
	 		int max;		
	 		try {max=repository.maxAdmissionNo();
	 	    }catch (Exception e) { max=1000;}		
	 		s.setAdmissionNo(++max);	
	 		
	 		repository.saveStudent(s.getAdmissionNo(),s.getName(),s.getStandard(),s.getPlace(),s.getMobile());	
	 		LocalDate date = LocalDate.now();
	 		repository.savePersonalDetail(s.getAdmissionNo(),"","",null,"","",date,null);
	 		repository.saveMarksDetails(s.getAdmissionNo(),0,0,0);
	 		repository.saveFeeDetails(s.getAdmissionNo(),0,0,0,0);
	 		return"Student Record Added Successfully";
		}
	 	 	
	 	
	 	
	 	
//  	 	           Get  Student By AdmissionNo	
	 	public Student getStudent(int admissionNo) {  
		    return repository.getStudent(admissionNo);
		}
	 	public PersonalDetail getPersonalDetail(int admissionNo) {  
		    return repository.getPersonalDetail(admissionNo);
		}
	 	public MarksDetails getMarksDetails(int admissionNo) {
	 		 return repository.getMarksDetails(admissionNo);
		}
	 	public FeeDetails getFeeDetailsFeeDetails(int admissionNo) {
	 		 return repository.getFeeDetails(admissionNo);
		}
	 	
	   
	 	
	 		 	
//                    Search  Students By AdmissionNo 	
	 	public List<Student> searchStudentsRecord(int admissionNo){
	 	       return repository.searchStudentsRecord(admissionNo);
	 	}
 
	 	
	 	
	 	 
//                    Update  Student BY ID  
	    public String updateAllStudentRecord(Student s, PersonalDetail p, MultipartFile file, FeeDetails f, MarksDetails m ) throws IOException{ 
	      if(file.isEmpty()){
	    	   repository.updatePersonalDetail(p.getGuardianName(),p.getEmail(),p.getDob(),p.getAadhar(),p.getGender(),p.getDate(),s.getAdmissionNo());
	      }else{
	    	   repository.updatePersonalDetail(p.getGuardianName(),p.getEmail(),p.getDob(),p.getAadhar(),p.getGender(),p.getDate(),file.getBytes(),s.getAdmissionNo());
	      }
	    	   repository.updateStudent(s.getName(),s.getStandard(),s.getPlace(),s.getMobile(),s.getAdmissionNo());	  
	 		   repository.updateMarksDetails(m.getQuarterly(),m.getHalfYearly(),m.getAnnual(),s.getAdmissionNo());
	 		   repository.updateFeeDetails(f.getAdmissionFee(),f.getQuater1Fee(),f.getQuater2Fee(),f.getQuater3Fee(),s.getAdmissionNo());   
		       return "Student Record Updated Successfully";
	    }
		
		
	    
	    
//                    Delete  Student BY ID  
		public String deleteAllStudentRecord(int admissionNo) {
			   repository.deleteStudent(admissionNo);
			   repository.deletePersonalDetail(admissionNo);
			   repository.deleteMarksDetails(admissionNo);
			   repository.deleteFeeDetails(admissionNo);
			   return "Student Record Deleted Successfully";
		}

	
}
