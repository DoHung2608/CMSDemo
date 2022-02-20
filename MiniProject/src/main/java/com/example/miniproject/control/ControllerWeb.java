package com.example.miniproject.control;

import com.example.miniproject.model.database.Account;
import com.example.miniproject.model.database.Employee;
import com.example.miniproject.model.session.EmployeeInfo;
import com.example.miniproject.service.AccountService;
import com.example.miniproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerWeb {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AccountService accountService;

    @RequestMapping("/")
    public String goLogin() {
        return "login";
    }

    @RequestMapping("/index")
    public String goIndex() {
        return "index";
    }

    @RequestMapping("/profile")
    public String goProfile() {
        return "profile";
    }

//    @RequestMapping("/profile/{id}")
//    public String getInfoProfile(@PathVariable("id") Integer id, Model model) {
//        EmployeeInfo employeeInfo = employeeService.findEmployInfo(id);
//        model.addAttribute("employeeInfo", employeeInfo);
//        return "profile";
//    }


    @RequestMapping("/login")
    public String loginAccount(Model model,@RequestParam Map<String,String> body) {
        if(body.size() > 0 && body.get("email") != null) {
            Account account = accountService.findAccountByEmail(body.get("email"));
            if(account == null || !account.getPassword().equals(body.get("password"))) {
                model.addAttribute("not_correct","erro");
                return "login";
            }
            model.addAttribute("logined",true);
            model.addAttribute("welcome","xin chào"+account.getEmail());
            return "redirect:profile";
        }
        return "login";
    }

    @RequestMapping("/register")
    public String register() {

        return "register";
    }
    @GetMapping("/register")
    public String signUpAccount(@RequestParam(value = "email", required = false) String email,
                                @RequestParam(value = "password", required = false) String password,Model model) {
        Account account = new Account(email,password);
        model.addAttribute("account", account);
        return "register";
    }
    @PostMapping("/register")
    public String addAccount(Account account, Model model) {
        accountService.saveAccount(account);
        return "redirect:login";
    }


    @RequestMapping("/table")
    public String table(Model model) {
//        List<Employee> listEmp = new ArrayList<>(employeeService.getInfoEmp());
//        model.addAttribute("listEmp", listEmp);
//        return "table";
        return findPaginated(1,model);
    }

    @RequestMapping("/addemployee")
    public String addemployee() {
        return "addemployee";
    }


    //add Employee
    @GetMapping("/addemployee")
    public String addEmployee(@RequestParam(value = "img", required = false) String img,
                              @RequestParam(value = "username", required = false) String username,
                              @RequestParam(value = "firstname", required = false) String firstname,
                              @RequestParam(value = "lastname", required = false) String lastname,
                              @RequestParam(value = "address", required = false) String address,
                              @RequestParam(value = "city", required = false) String city,
                              @RequestParam(value = "age", required = false) BigDecimal age,
                              @RequestParam(value = "salary", required = false) String salary,
                              Model model) {
        Employee employee = new Employee(img, username, firstname, lastname, address, age, city, salary);
        model.addAttribute("employee", employee);
        return "addemployee";
    }

    @PostMapping("/addemployee")
    public String addEmp(Employee employee, Model model) {
        employeeService.saveEmp(employee);
        return "redirect:table";
    }

    //delete Employee
    @GetMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            employeeService.deleteEmp(id);
        } catch (Exception e) {
            ra.addFlashAttribute("message", "No");
        }
        return "redirect:/table";
    }

    //update emp
    @GetMapping("/updateEmp/{id}")
    public String updateEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "updateemployee";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listEmployees", listEmployees);
        return "table";
    }


}
