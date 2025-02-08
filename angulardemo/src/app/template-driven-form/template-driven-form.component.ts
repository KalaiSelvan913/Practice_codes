import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
  styleUrls: ['./template-driven-form.component.css']
})
export class TemplateDrivenFormComponent implements OnInit {


  Submitted = false;
  // name: String = "";
  // phone: String="";
  // email: String="";

  constructor() { }

  ngOnInit(): void {
  }

  // For Click Button Action
  click(myForm:any){

    this.Submitted=true;

    // console.log(myForm)

    console.log(myForm.invalid)
    if(myForm.invalid){

    }else{
      console.log(myForm.value)
    }

    

  }

  

}
