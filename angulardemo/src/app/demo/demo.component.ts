import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo',
  templateUrl: './demo.component.html',
  styleUrls: ['./demo.component.css']
})
export class DemoComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {

    this.futureDateDisable()
  }

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
