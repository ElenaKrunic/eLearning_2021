import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, AbstractControl, Validators } from '@angular/forms';
import { Payment } from '../model/payment';
import { PaymentService } from '../payment/payment.service';


@Component({
  selector: 'app-admin-add-payment',
  templateUrl: './admin-add-payment.component.html',
  styleUrls: ['./admin-add-payment.component.css']
})
export class AdminAddPaymentComponent implements OnInit {

  payment: Payment = new Payment({
    dateOfPayment: '',
    paymentDescription : '', 
    paymentAmount: 0,
    financialCard : null
  });

  form! : FormGroup; 
  submitted = false;

  constructor(private paymentService: PaymentService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
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

  savePayment() {
    const data = {
      dateOfPayment: this.payment.dateOfPayment,
      paymentDescription : this.payment.paymentDescription, 
      paymentAmount: this.payment.paymentAmount,
    }; 

    this.paymentService.create(data)
    .subscribe(
      response => {
        console.log(response); 
        this.submitted = true; 
      },
      error => {
        console.log(error);
      }
    );
  }

  newPayment(){
    this.submitted = false; 
    this.payment = {
      dateOfPayment: '',
      paymentDescription : '', 
      paymentAmount: 0,
      financialCard : null
    };
  }

}
