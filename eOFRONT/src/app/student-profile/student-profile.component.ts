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
  student?:Student;
  constructor(private location:Location,private studentService: StudentService, private route: ActivatedRoute) {
    // this.student=new Student({
    //   cardNumber:'',
    //   firstName:'',
    //   lastName:'',
    //   phoneNumber:'',
    //   email:'',
    //   umnc:'',
    //   modelNumber:0,
    //   referenceNumber:'',
    //   accountNumber:'',
    //   typeOfFinancing:TypeOfFinancing{},


  //  )
  }
    ;
   

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
