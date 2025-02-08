import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import { ConfirmPasswordValidator } from "./confirm-password.validator";
import Swal from 'sweetalert2';

@Component({
  selector: '[app-page2]',
  templateUrl: './page2.component.html',
  styleUrls: ['./page2.component.css']
})
export class Page2Component implements OnInit {
  

  submitted: boolean = false;

  registerForm = this.fb.group({

    email: ['', Validators.required],
    password: ['', Validators.required],
    confirmPassword: ['', Validators.required]

  }, {
    validator: ConfirmPasswordValidator("password", "confirmPassword")
  });


  constructor(private fb: FormBuilder, private myservice: AuthService) { }

  ngOnInit(): void {
  }

  get f() {
    return this.registerForm.controls;
  }

  register() {
    this.submitted = true;
    console.log(this.registerForm.controls)
    // console.log(this.f['email'].errors);
    // console.log(this.f['confirmPassword'].errors)
    console.log(this.registerForm.value)
    

    if (this.registerForm.invalid) {
      return;
    } else {

      this.myservice.savePassword(this.registerForm.value).subscribe((Response) => {
        console.log(Response)

        if(Response.status == "Success"){
          // this.registerForm.reset();
          // this.submitted = false;
          Swal.fire(
            'SignUp Complete',
            'Go Back To Login Page',
            'success'
          )

        }


      });
    }

  }
}
