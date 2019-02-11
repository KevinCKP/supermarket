package com.scau.kevin.supermarket.controller;

import com.scau.kevin.supermarket.entity.Staff;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


/**
 * @Author: kevin
 * @Date: 2018/12/29 0:40
 * @Version 1.0
 */
@Controller
public class AuthenticationController {
    @Autowired
    private StaffService staffService;

    @RequestMapping("/login")
    @ResponseBody
    public Result<Staff> login(Model model,String staffId, String password,HttpSession session){
        System.out.println(staffId);
        System.out.println(password);
        Staff staff = staffService.login(staffId,password);
        model.addAttribute("staff",staff);
        session.setAttribute("staff",staff);
        return Result.success(staff);
    }
    @RequestMapping("/welcome")
    public String welcome(Model model, HttpSession session){
        model.addAttribute("staff",session.getAttribute("staff"));
        return "welcome";
    }

    @RequestMapping("welcome2.html")
    public String welcome2(Model model, HttpSession session){
        model.addAttribute("staff",session.getAttribute("staff"));
        return "welcome2";
    }
//    @RequestMapping("/supplier-add.html")
//    public String supplierAdd(){
//
//        return "supplier-add";
//    }

}
