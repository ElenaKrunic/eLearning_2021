import { Component, Input, OnInit } from '@angular/core';
import { Student } from '../model/student';
import { Location } from '@angular/common';
import { ActivatedRoute, Params } from '@angular/router';
import { StudentService } from '../students/student.service';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})

export class StudentProfileComponent implements OnInit {
  student=new Student({
    cardNumber:'',
    firstName:'',
    lastName:'',
    phoneNumber:'',
    email:'',
    umnc:'',
    modelNumber:0,
    startedCollegeIn:0,
    referenceNumber:'',
    cardAmount:0,
    accountNumber:'',
    typeOfFinancing:null,
    financialCards:null
  });


  constructor(private location:Location,private studentService: StudentService, private route: ActivatedRoute) {}
   

  ngOnInit(): void {
    this.route.snapshot.params['id'];
    if (this.route.snapshot.params['id']) {
      // fetch student if we edit the existing student
      this.route.params.pipe(switchMap((params: Params) => 
          this.studentService.getStudent(+params['id']))) // convert to number
        .subscribe(res => {
          this.student = res.body;
          
          }
        );
    } 
  }

  goBack(): void {
    this.location.back();
  }

}
