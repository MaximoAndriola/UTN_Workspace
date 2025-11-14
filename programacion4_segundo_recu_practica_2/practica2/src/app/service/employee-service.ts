import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private URL : string = "http://localhost:3000/employees"

  constructor(private http : HttpClient){}

  getEmployees() : Observable<Employee[]>{
    return this.http.get<Employee[]>(this.URL)
  }
 
  getEmployeeById(id : string) : Observable<Employee>{
    return this.http.get<Employee>(`${this.URL}/${id}`)
  }
  
  postEmployee(employee : Employee) : Observable<Employee>{
    return this.http.post<Employee>(this.URL, employee)
  }

  putEmployee(employee : Employee, id : string) : Observable<Employee>{
    return this.http.put<Employee>(`${this.URL}/${id}`, employee)
  }

  deleteEmployee(id : string) : Observable<void>{
    return this.http.delete<void>(`${this.URL}/${id}`)
  }
}
