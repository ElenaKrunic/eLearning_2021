import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { Student } from '../model/student';
import { TypeOfFinancing } from '../model/type-of-financing';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  student: Student = new Student({
    cardNumber : '', 
    firstName: '',
    lastName: '',
    phoneNumber: '',
    email: '',
    umnc: '',
    startedCollegeIn : 0,
    modelNumber: 0,
    referenceNumber: '',
    accountNumber : '',
    cardAmount : 0,
    //testno
    typeOfFinancing: null,
    financialCards : null
  });
  
  mode: string = 'ADD'; 

  constructor(private studentService: StudentService, private route: ActivatedRoute, private location: Location, private router : Router) { }

  ngOnInit(): void {
    if(this.route.snapshot.params['id']) {
      this.route.params.pipe(switchMap((params: Params) =>
      this.studentService.getStudent()))
      .subscribe(res => {
        this.student = res.body;
      });
    }
  }

  save() : void {
    this.mode == 'ADD' ? this.add() : this.edit();
  }

  private add(): void {
    this.studentService.addStudent(this.student)
    .subscribe(res => {
      this.studentService.announceChange();
      this.goBack();
    });
  }

  private edit() : void {
    this.studentService.editStudent(this.student)
    .subscribe(student => {
      this.studentService.announceChange();
      this.goBack();
    });
  }

  goBack() : void {
    this.location.back(); 
  }
}
