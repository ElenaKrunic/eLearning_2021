import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-admin-details-student',
  templateUrl: './admin-details-student.component.html',
  styleUrls: ['./admin-details-student.component.css']
})
export class AdminDetailsStudentComponent implements OnInit {

  currentStudent: any | null; 
  message = ''; 

  constructor(private studentService: StudentService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getStudent(this.route.snapshot.paramMap.get('id'));
  }

  getStudent(id: any) : void {
    this.studentService.get(id)
    .subscribe(
      data => {
        this.currentStudent = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updateStudent(): void {
    this.studentService.update(this.currentStudent.id, this.currentStudent)
    .subscribe(
      response => {
        console.log(response); 
        this.message =  "You successfully updated selected student!";
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteStudent() : void {
    this.studentService.delete(this.currentStudent.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/students']);
      }, 
      error => {
        console.log(error); 
      }
    );
  }

}
