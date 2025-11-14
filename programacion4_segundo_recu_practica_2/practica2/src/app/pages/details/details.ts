import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { EmployeeService } from '../../service/employee-service';
import { Employee } from '../../model/employee';

@Component({
  selector: 'app-details',
  imports: [],
  templateUrl: './details.html',
  styleUrl: './details.css',
})
export class Details implements OnInit{
  employee? : Employee
  employeeId : string | null = null

  constructor(
    public employeeService : EmployeeService,
    private route : ActivatedRoute
  ){}

  ngOnInit(): void {
    this.employeeId = this.route.snapshot.paramMap.get("id")
    
    if(this.employeeId){
      this.loadEmployee(this.employeeId)
    }
  }

  loadEmployee(id : string){
    this.employeeService.getEmployeeById(id).subscribe({
      next: (data) => (this.employee = data),
      error: (error) => (console.log(error))
    })
  }
}
