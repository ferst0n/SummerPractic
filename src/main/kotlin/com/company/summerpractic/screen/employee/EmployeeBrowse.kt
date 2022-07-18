package com.company.summerpractic.screen.employee

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.Employee

@UiController("Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
class EmployeeBrowse : StandardLookup<Employee>()