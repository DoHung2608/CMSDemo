//package com.example.miniproject.control;
//
//import com.example.miniproject.model.session.EmployeeInfo;
//import com.example.miniproject.service.EmpSessionService;
//import com.example.miniproject.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//public class BaseController {
//    @Autowired
//    EmpSessionService empSessionService;
//
//    @ModelAttribute
//    public void setBaseModel(Model model) {
//        EmployeeInfo employeeInfo = empSessionService.getEmployeeSession();
//        if (employeeInfo != null) {
//            model.addAttribute("staff", employeeInfo);
//        }
//    }
//}
