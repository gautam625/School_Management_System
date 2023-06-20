package com.SchoolManagement.Controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.SchoolManagement.Model.FeeDetails;
import com.SchoolManagement.Model.MarksDetails;
import com.SchoolManagement.Model.PersonalDetail;
import com.SchoolManagement.Model.Student;
import com.SchoolManagement.Services.StudentServices;

import jakarta.validation.Valid;

@Controller
public class StudentController  {
	
	@Autowired
	StudentServices service;

	
 //             Display all Students
	@RequestMapping("/")
	public String getAllStudent(Model m) {
           m.addAttribute("list", service.getAllStudent());
		   return "students"; 
	} 

	
	
 //             Insert new Student
	@RequestMapping("/students/form")
	public String addStudent(Model m) {
		   m.addAttribute("s", new Student());
		   return "form";
	}
	@GetMapping("/students/save")
	public String saveStudent(@Valid @ModelAttribute("s") Student s,BindingResult result,Model m) {
		if(result.hasErrors()) {	  
			 return "form";
		}else {
			 m.addAttribute("alart1",service.saveStudent(s));
		     m.addAttribute("list",service.getAllStudent());
	   		 return "students";  			
		}      
     }


	
 
 //                 Display All student Details
	@GetMapping("/students/input")
	public String  inputAdmissionNo(Model m) {
		   return "inputAdmissionNo";
	}
	@GetMapping("/students/display")
	public String displayStudentDetail(@RequestParam("admissionNo") int admissionNo, Model m) {
		if(service.getStudent(admissionNo)==null) {
			 m.addAttribute("admissionNumber","Invalid Admission Number");
			 return "inputAdmissionNo";
		}else {	
		     m.addAttribute("s", service.getStudent(admissionNo));
		     m.addAttribute("p", service.getPersonalDetail(admissionNo));
		     m.addAttribute("f", service.getFeeDetailsFeeDetails(admissionNo));
		     m.addAttribute("m", service.getMarksDetails(admissionNo));
		     return "display"; 
	    }
	}
	
 	@GetMapping("/students/display/{admissionNo}")
	public ResponseEntity<byte[]> getStudentImage(@PathVariable("admissionNo") int admissionNo, Model m) {
	        PersonalDetail p =service.getPersonalDetail(admissionNo);
	        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(p.getImage());
	} 
	

	
//                              Refresh
	
	
	
 //                  Search Student by AdmissionNo
	@GetMapping("/student/search")
	public String searchStudentRecord(@RequestParam("admissionNo") int admissionNo, Model m) {
		   m.addAttribute("list", service.searchStudentsRecord(admissionNo));
		   return "students";
	}
	
	
	

 //                    Update  Student Record
	@GetMapping("/students/edit/{admissionNo}")
	public String geStudentRecord(@PathVariable("admissionNo") int admissionNo, Model m) {
		   m.addAttribute("s", service.getStudent(admissionNo));
		   m.addAttribute("p", service.getPersonalDetail(admissionNo));
		   m.addAttribute("f", service.getFeeDetailsFeeDetails(admissionNo));
		   m.addAttribute("m", service.getMarksDetails(admissionNo));
		   return "update";
	}
	@PostMapping("/students/update")
	public String updateStudentRecord(@ModelAttribute("s") Student s,@ModelAttribute("p") PersonalDetail p,@RequestParam("file")MultipartFile file,@ModelAttribute("f") FeeDetails f,@ModelAttribute("k") MarksDetails k,Model m) throws IOException {
		   m.addAttribute("alart1",service.updateAllStudentRecord(s,p,file,f,k));
		   m.addAttribute("s", service.getStudent(s.getAdmissionNo()));
		   m.addAttribute("p", service.getPersonalDetail(s.getAdmissionNo()));
		   m.addAttribute("f", service.getFeeDetailsFeeDetails(s.getAdmissionNo()));
		   m.addAttribute("m", service.getMarksDetails(s.getAdmissionNo()));
		       return "display";  
	}
	
	
	
	

//                    Delete Student Record	
	@GetMapping("/students/delete/{admissionNo}")
	public String deleteStudentById(@PathVariable("admissionNo") int admissionNo,Model m) {
		   m.addAttribute("alart2",service.deleteAllStudentRecord(admissionNo));
		   m.addAttribute("list", service.getAllStudent());
		   return "students";
	}

}
