import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AuthService } from '../service/auth.service';
import { NgxSpinnerService } from "ngx-spinner";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public showPassword: boolean = false;
  submitted = false;

  loginForm = this.fb.group({

    username: ['', Validators.required],
    password: ['', Validators.required]

  })

  constructor(private fb: FormBuilder, private myservice: AuthService, private router: Router,
     private SpinnerService: NgxSpinnerService) { }

  ngOnInit(): void {
  }

  public togglePasswordVisibility(): void {
    this.showPassword = !this.showPassword;
  }
  
  get f() {
    return this.loginForm.controls;
  }


  // For Submit Button Action 
  loginSubmit() {
    
    this.submitted = true;

    console.log(this.loginForm.controls)
    console.log(this.f['username'].errors);
    console.log(this.loginForm.value)

    if (this.loginForm.invalid) {
      return
    } else {
      this.myservice.loginValidation(this.loginForm.value).subscribe((Response) => {
        console.log(Response)
        if (Response.status == "Success") {
          // this.loginForm.reset();
          // this.submitted = false;
          console.log("success")
          /** spinner starts on init */
    this.SpinnerService.show();

    setTimeout(() => {
      /** spinner ends after 1 seconds */
      this.SpinnerService.hide();
    }, 1000);
          this.router.navigateByUrl('/common/sample')
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Invalid Credential !!!!',
          })
        }

      });

    }

    
  }

}
