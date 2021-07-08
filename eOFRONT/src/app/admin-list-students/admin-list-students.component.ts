import { Component, OnInit } from '@angular/core';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-admin-list-students',
  templateUrl: './admin-list-students.component.html',
  styleUrls: ['./admin-list-students.component.css']
})
export class AdminListStudentsComponent implements OnInit {

  students : any; 
  currentStudent: null | any; 
  currentIndex = -1; 
  firstName = '' ;
  lastName = ''; 

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.retrieveStudents();
  }

  retrieveStudents() : void {
    this.studentService.getAll()
    .subscribe(
      data => {
        this.students = data;
        console.log(data); 
      },
      error => {
        console.log(error);
      }
    );
  }

  refreshList(): void {
    this.retrieveStudents();
    this.currentIndex = -1; 
    this.currentStudent= null;
  }

  setActiveStudent(student : null | any, index=-1) : void {
    this.currentStudent = student;
    this.currentIndex = index;
  }


}
