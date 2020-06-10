package cn.eggnetech.eggnetechmybatis.controller;

import cn.eggnetech.eggnetechmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/30
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("list", userService.list());
        return "list";
    }
}
