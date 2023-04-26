package cn.minfengyu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String getIndex(Model model){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("title","你好");
        model.addAttribute("title","你好");
        return "index.ftl";
    }
}
