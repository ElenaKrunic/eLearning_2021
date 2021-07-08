import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-admin-student',
  templateUrl: './admin-student.component.html',
  styleUrls: ['./admin-student.component.css']
})
export class AdminStudentComponent implements OnInit {

  students: Student[];
  subscription: Subscription;

  constructor(private studentService: StudentService, private router: Router) { 
    this.getStudents();
  }

  ngOnInit(): void {
    this.getStudents();
  }

  getStudents(){
    this.studentService.getStudents().subscribe(res => 
      this.students = res.body);
  }

  gotoAdd() : void {
    this.router.navigate(["/addStudent"]);
  }

  gotoEdit(student : Student) : void {
    this.router.navigate(['/editStudent', student.id]);
  } 

  deleteStudent(studentId : number) : void {
    this.studentService.deleteStudent(studentId).subscribe(
      () => this.getStudents()
    );
  }

}
