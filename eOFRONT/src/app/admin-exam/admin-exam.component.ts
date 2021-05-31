import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ExamService } from '../exam/exam.service';
import { Exam } from '../model/exam';

@Component({
  selector: 'app-admin-exam',
  templateUrl: './admin-exam.component.html',
  styleUrls: ['./admin-exam.component.css']
})
export class AdminExamComponent implements OnInit {

  exams : Exam[];
  subscription : Subscription;

  constructor(private examService: ExamService, private router: Router) { 
  this.getExams();
}
  ngOnInit(): void {
    this.getExams();
  }

  getExams(){
    this.examService.getExams().subscribe(res =>
       this.exams = res.body);
  }
  gotoAdd() : void {
    this.router.navigate(["/addExam"]);
  }
  gotoEdit(exam : Exam) : void {
    this.router.navigate(['/editExam', exam.id]);
  } 

  deleteExam(examId : number) : void {
    this.examService.deleteExam(examId).subscribe(
      () => this.getExams()
    );
  }

}
