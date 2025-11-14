import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  imports: [],
  templateUrl: './list.html',
  styleUrl: './list.css',
})
export class List implements OnInit{
  public employees? : Employee[]
  public allEmployees? : Employee[]
  public cant : number = 0
  public filterText : string = ""

  constructor(
    public employeeService : EmployeeService,
    private router : Router
  ){}

  ngOnInit(): void {
    this.loadEmployees()
  }

  loadEmployees(){
    this.employeeService.getEmployees().subscribe({
      next: (data) => {
        this.allEmployees = data
        this.employees = data
        this.count()
      },
      error: (error) => (console.log(error))
    })
  }

  showDetails(id : string){
    return this.router.navigate(["/details", id])
  }
  
  updateEmployee(id : string){
    return this.router.navigate(["/update", id])
  }

  deleteEmployee(id : string){
    return this.employeeService.deleteEmployee(id).subscribe({
      next: () => (this.loadEmployees()),
      error: (error) => (console.log(error))
    })
  }

  count(){
    this.cant = 0
    for(let emp of this.employees!){
      this.cant += 1
    }
  }

  filterEmployees(event : Event){
    const input = event.target as HTMLInputElement
    this.filterText = input.value.toLowerCase()

    if(this.filterText === ""){
      this.employees = this.allEmployees
    }else{
      this.employees = this.allEmployees?.filter(emp => 
        emp.name.toLowerCase().includes(this.filterText) ||
        emp.mail.toLowerCase().includes(this.filterText) ||
        emp.phoneNumber.includes(this.filterText)
      )
    }
    
    this.count()
  }
}
