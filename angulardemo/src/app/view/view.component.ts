import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { AuthService } from '../service/auth.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { NgxSpinnerService } from "ngx-spinner"; 

declare var $: any;


export interface CommonDto {
  status: String;
  responseDto: any;
  responsedata: any;
}

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.css']
})
export class ViewComponent implements OnInit {

  dataList: any;

  constructor(private fb: FormBuilder, private myservice: AuthService,private router: Router, private SpinnerService: NgxSpinnerService) { }

  viewForm = this.fb.group({
    name: [''],
    email: [''],
    phone: [''],
    dob: [''],
    gender: [''],
    team: [''],
  });

  ngOnInit(): void {
    this.getAllData();
  }

  // For  JQuery Datatable
  getAllData() {
    this.SpinnerService.show();
    this.myservice.getAllData().subscribe((Response: CommonDto) => {
      console.log(Response);
      this.dataList = Response.responseDto;
      $(document).ready(function () {
        $('#example').DataTable();
      });
      console.log(this.dataList)
    });
    // return this.http.post<CommonDto>();
    // {
    //   status: "",
    //   reponseDto:[{},{}]
    // }
    setTimeout(() => {
      /** spinner ends after 1 seconds */
      this.SpinnerService.hide();
    }, 1000);
  }

  // For Edit Button Action 
  edit() {
    console.log(this.viewForm.value)
    this.myservice.edit(this.viewForm.value).subscribe((Response) => {
      console.log(Response)
      if (Response.status == "Success") {
        this.getAllData();
        Swal.fire('Thank you...', 'Edited Data Saved Successfully', 'success')
      }
    });
  }

  // For Getting Data From Datatable
  onEdit(row: any) {
    // console.log(row)
    localStorage.setItem("empName",row);
    // localStorage.setItem("phone",row.phone);
    // localStorage.setItem("email",row.email);
    // localStorage.setItem("dob",row.dob);
    // localStorage.setItem("team",row.team);
    // localStorage.setItem("gender",row.gender);
    this.router.navigateByUrl('/common/edit')
    // this.viewForm.controls['name'].setValue(row.name);
    // this.viewForm.controls['email'].setValue(row.email);
    // this.viewForm.controls['phone'].setValue(row.phone);
    // this.viewForm.controls['dob'].setValue(row.dob);
    // this.viewForm.controls['gender'].setValue(row.gender);
    // this.viewForm.controls['team'].setValue(row.team);

  }

  // For Delete Button Action 
  delete(row:any) {
    this.viewForm.controls['name'].setValue(row.name);
    // Sweet Alert for Delete Confirmation
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        console.log(this.viewForm.value)
        this.myservice.delete(this.viewForm.value).subscribe((Response) => {
          console.log(Response)
          this.getAllData();
        });
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
      }
    })
  }


}
