package com.company.summerpractic.screen.employee

import io.jmix.ui.screen.*
import com.company.summerpractic.entity.Employee

@UiController("Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
class EmployeeEdit : StandardEditor<Employee>()