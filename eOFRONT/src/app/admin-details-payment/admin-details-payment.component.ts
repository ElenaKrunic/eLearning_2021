import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PaymentService } from '../payment/payment.service';
import { FormBuilder, FormGroup, AbstractControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-details-payment',
  templateUrl: './admin-details-payment.component.html',
  styleUrls: ['./admin-details-payment.component.css']
})
export class AdminDetailsPaymentComponent implements OnInit {

  currentPayment: any | null; 
  message = '';
  form! : FormGroup; 
  submitted = false; 

  constructor(private paymentService: PaymentService, private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.message = ''; 
    this.getPayment(this.route.snapshot.paramMap.get('id'));
    this.form = this.formBuilder.group({
      dateOfPayment: [
        '',
        [
          Validators.required
        ] 
      ],
      paymentDescription: [
        '',
       [
        Validators.required, 
       ]
      ],
      paymentAmount: [
        '',
        [
          Validators.required, 
          Validators.minLength(3),
          Validators.maxLength(9)
        ] 
      ],
    });
  }

  get f(): { [key: string]: AbstractControl} {
    return this.form.controls;
  }

  onSubmit() : void {
    this.submitted = true; 

    if(this.form.invalid) {
      return; 
    }

    console.log(JSON.stringify(this.form.value, null, 2));
  }

  onReset() : void {
    this.submitted = false; 
    this.form.reset();
  }

  getPayment(id: any) : void {
    this.paymentService.get(id)
    .subscribe(
      data => {
        this.currentPayment = data; 
        console.log(data); 
      }, 
      error => {
        console.log(error);
      }
    );
  }
  
  updatePayment(): void {
    this.paymentService.update(this.currentPayment.id, this.currentPayment)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/payments']);
      },
      error => {
        console.log(error);
      }
    );
  }

  deletePayment() : void {
    this.paymentService.delete(this.currentPayment.id)
    .subscribe(
      response => {
        console.log(response); 
        this.router.navigate(['/payments']);
      }, 
      error => {
        console.log(error); 
      }
    );
  }

}
