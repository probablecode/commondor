package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class AppController {
    public final String epoch = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    public volatile int visitor = 0;

    @GetMapping("/")
    public String home(Model model) {
        System.out.println(epoch);
        model.addAttribute("epoch", epoch);
        model.addAttribute("service", "상식도르");
        model.addAttribute("developer", "jchoi");
        synchronized (this) { model.addAttribute("visitor", ++visitor); }
        return "home";
    }
}
