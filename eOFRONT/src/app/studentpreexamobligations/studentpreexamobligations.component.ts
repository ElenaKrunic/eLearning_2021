import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { AuthenticationService } from '../login/authentication.service';
import { PreexamObligation } from '../model/preexam-obligation';
import { Student } from '../model/student';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-studentpreexamobligations',
  templateUrl: './studentpreexamobligations.component.html',
  styleUrls: ['./studentpreexamobligations.component.css']
})
export class StudentpreexamobligationsComponent implements OnInit {

  preexamObligations?:PreexamObligation[];
  student:Student;
  examId:number;
  constructor(private studentService: StudentService, private route: ActivatedRoute,private router: Router,private authService:AuthenticationService,private location:Location) { }

  ngOnInit() {
    this.examId=+this.route.snapshot.paramMap.get('id');
    console.log(this.examId);
    this.studentService.getMeAgain().subscribe(res =>{( this.student=res)
      this.studentService.getStudentPreexamObligation(res,+this.route.snapshot.paramMap.get('examid')).subscribe(res=>this.preexamObligations=res)
      this.studentService.registerExam(this.student,+this.route.snapshot.paramMap.get('examid')).subscribe(()=>this.ngOnInit);
   
    });
  }
  //   this.studentService.getStudentMe().subscribe(res =>{(this.student = res)
  //     if (this.route.snapshot.params['id']) {
  //       // fetch student if we edit the existing student
  //       this.route.params.pipe(switchMap((params: Params) => 
  //           this.studentService.getStudentPreexamObligation(this.student,+params['id']))) // convert to number
  //           .subscribe(res =>
  //             this.preexamObligations = res);
  //             }
  //         });
  // }

  private register(student:Student,examId:number) {
    this.examId=+this.route.snapshot.paramMap.get('id');
    
    this.studentService.registerExam(student,this.examId).subscribe(()=>this.ngOnInit)
    console.log("Student"+this.student);
    console.log("Exam id"+this.examId )
  }
    goBack(): void {
      this.location.back();
           }

}
