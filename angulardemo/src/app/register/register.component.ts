import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { save, windows } from 'ngx-bootstrap-icons';
import { NgxSpinnerService } from 'ngx-spinner';
import Swal from 'sweetalert2';
import { AuthService } from '../service/auth.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  submitted = false;
  

  // tablelist=null;


  // form = new FormGroup({
  //   name : new FormControl(''),
  //   email: new FormControl(''),
  //   phone: new FormControl(''),
  //   dob: new FormControl(''),
  //   gender: new FormControl('Male'),
  //   team: new FormControl(this.teams[0]),
  // });

  

  profileForm = this.fb.group({
    name:['', Validators.required],
    email:['', [Validators.required,Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
    phone:['', [Validators.required,Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
    dob:['', Validators.required],
    gender:['', Validators.required],
    team:[''],
  });
  // remember = new FormControl();
  constructor(private fb: FormBuilder, private myservice : AuthService,private spinner: NgxSpinnerService) { }
  
  ngOnInit(): void {
    /** spinner starts on init */
    this.spinner.show();

    setTimeout(() => {
      /** spinner ends after 1 seconds */
      this.spinner.hide();
    }, 1000);
  }

  get f(){
    return this.profileForm.controls;
  }

  // For Submit Button action
  submit(){
   
    this.submitted=true;
    // console.log(this.profileForm.controls)
    // console.log(this.f['name'].errors);
    if(this.profileForm.invalid){
      return;
    }else{
      
        this.myservice.save(this.profileForm.value).subscribe((Response)=>{
          console.log(Response)
          if(Response.status == "Success"){
            this.profileForm.reset();
            this.submitted = false;
            Swal.fire('Thank you...', 'You submitted succesfully!', 'success')

          }
          });
       }

    console.log(this.profileForm.value)
    
  }

  // For getAllData Button 
  //  getAllData(){
     
  //    this.myservice.getAllData().subscribe((Response1)=>{
  //      console.log(Response1)
  //     //  this.tablelist = Response1;
  //    })

  //  }

  
  // For Update Button Action 
  // update(){
  
  //   this.profileForm.setValue({
  //     name: "demo",
  //     email:"demo@gmail.com",
  //     phone: "9661781569",
  //     dob: "1996-07-07",
  //     gender: "Female",
  //     team:"LIC",
  //   });
    
  // }


  maxDate = "2022-05-30"

  futureDateDisable(){
    var date:any = new Date();
    var todayDate:any = date.getDate();
    var month:any = date.getMonth();
    var year:any = date.getFullYear();
    if(todayDate < 0){
      todayDate = 0 + todayDate;
    }
    if(month < 0){month = '0'+month;}
  
    this.maxDate = year+"-"+month+"-"+todayDate;
    console.log(this.maxDate)
  }
 

}