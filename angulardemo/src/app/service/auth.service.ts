import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import{Router,ActivatedRoute,ParamMap} from '@angular/router';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  baseurl : String = 'http://localhost:9090';

  constructor(private http: HttpClient) { }

  save(input:any): Observable<any> {  
    const headers={
      "Content-type": "application/json"
    }
    return this.http.post(`${this.baseurl}`+'/save',input,{headers});
  }

  getAllData(): Observable<any> {
    return this.http.get(`${this.baseurl}`+'/getAllData')
  }
  
  edit(input:any): Observable<any> {  
    const headers={
      "Content-type": "application/json"
    }
    return this.http.post(`${this.baseurl}`+'/edit',input,{headers});
  }

  delete(input:any): Observable<any> {
    const headers={
      "Content-type": "application/json"
    }
    return this.http.post(`${this.baseurl}`+'/delete',input,{headers});
  }

  savePassword(input:any): Observable<any> {
    const headers={
      "Content-type": "application/json"
    }
    return this.http.post(`${this.baseurl}`+'/savePassword',input,{headers});
  }

  loginValidation(input:any): Observable<any> {
    const headers={
      "Content-type": "application/json"
    }
    return this.http.post(`${this.baseurl}`+'/loginValidation',input,{headers});
  }

  getDataByName(name:any): Observable<any> {
    const headers={
      "Content-type": "application/json"
    }
    return this.http.post(`${this.baseurl}`+"/getDataByName?empName="+name,{},{headers});
  }
  
}
