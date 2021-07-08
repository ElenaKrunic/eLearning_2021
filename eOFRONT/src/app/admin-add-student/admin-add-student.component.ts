import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-admin-add-student',
  templateUrl: './admin-add-student.component.html',
  styleUrls: ['./admin-add-student.component.css']
})
export class AdminAddStudentComponent implements OnInit {

  student : Student = new Student({
    cardNumber : '',
    firstName: '', 
    lastName: '', 
    phoneNumber: '', 
    email: '', 
    umnc: '', 
    startedCollegeIn: 1999, 
    modelNumber: 2, 
    referenceNumber :'', 
    accountNumber : '', 
    cardAmount : 124223,
    typeOfFinancing : null, 
    financialCards: null

  });

  submitted = false; 

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
  }

  saveStudent() {
    const data = {
     cardNumber : this.student.cardNumber,
     firstName: this.student.firstName, 
     lastName: this.student.lastName, 
     phoneNumber: this.student.phoneNumber, 
     email: this.student.email, 
     umnc: this.student.umnc, 
     startedCollegeIn: this.student.startedCollegeIn, 
     modelNumber: this.student.modelNumber,  
     referenceNumber : this.student.referenceNumber, 
     accountNumber : this.student.accountNumber, 
     cardAmount : this.student.cardAmount,
     typeOfFinancing : this.student.typeOfFinancing, 
     financialCards: this.student.financialCards
    }; 

    this.studentService.create(data)
    .subscribe(
      response => {
        console.log(response); 
        this.submitted = true; 
      },
      error => {
        console.log(error);
      }
    );
  }
}
