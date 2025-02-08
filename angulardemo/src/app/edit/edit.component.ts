import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';


export interface CommonDto {
  status: String;
  responseDto: any;
  responsedata: any;
}

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  editForm = this.fb.group({
    name : [''],
    email:[''],
    phone:[''],
    dob:[''],
    team:[''],
    gender:[''],
  });

  constructor(private fb: FormBuilder,private myservice : AuthService,private router: Router) { }

  ngOnInit(): void {
    var name = localStorage.getItem("empName");
    // var phone = localStorage.getItem("phone");
    // var email = localStorage.getItem("email");
    // var date = localStorage.getItem("dob");
    // var team = localStorage.getItem("team");
    // var gender = localStorage.getItem("gender");
    console.log(name)
    // this.editForm.controls['name'].setValue(name);
    // this.editForm.controls['phone'].setValue(phone);
    // this.editForm.controls['email'].setValue(email);
    // this.editForm.controls['dob'].setValue(date);
    // this.editForm.controls['team'].setValue(team);
    // this.editForm.controls['gender'].setValue(gender);
    this.myservice.getDataByName(name).subscribe((Data)=>{
      console.log(Data)
      this.editForm.controls['name'].setValue(Data.responsedata.name);
      this.editForm.controls['phone'].setValue(Data.responsedata.phone);
      this.editForm.controls['email'].setValue(Data.responsedata.email);
      this.editForm.controls['dob'].setValue(Data.responsedata.dob);
      this.editForm.controls['team'].setValue(Data.responsedata.team);
      this.editForm.controls['gender'].setValue(Data.responsedata.gender);
    })
  }

  saveEdit(){
    console.log(this.editForm.value)
    this.myservice.edit(this.editForm.value).subscribe((Response) => {
      console.log(Response);
      if (Response.status == "Success") {
        this.router.navigateByUrl("/common/view")
        Swal.fire('Thank you...', 'Edited Data Saved Successfully', 'success')
      }
    });
  }
}
