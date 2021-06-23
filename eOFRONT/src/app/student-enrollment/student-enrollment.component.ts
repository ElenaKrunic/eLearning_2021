
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AuthenticationService } from '../login/authentication.service';
import { Enrollment } from '../model/enrollment';
import { switchMap } from 'rxjs/operators';
import { StudentService } from '../students/student.service';

@Component({
  selector: 'app-student-enrollment',
  templateUrl: './student-enrollment.component.html',
  styleUrls: ['./student-enrollment.component.css']
})
export class StudentEnrollmentComponent implements OnInit {
  
  enrollments: Enrollment[];
  
   constructor(private studentService: StudentService, private router: Router,private authService:AuthenticationService,private route:ActivatedRoute) { 
  
  }


  ngOnInit(): void {
    if(this.route.snapshot.params['id']) {
      this.route.params.pipe(switchMap((params : Params) =>
      this.studentService.getStudentEnrollment(+params['id'])))
      .subscribe(res => {
        this.enrollments = res;
        
      });
    }
  }

  

}
