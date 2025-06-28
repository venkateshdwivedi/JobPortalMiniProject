package com.example.jobportalproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.jobportalproject.model.JobPost;
import com.example.jobportalproject.service.JobService;

@Controller
public class JobController {

    @Autowired
    private JobService service;

    @RequestMapping({"/","home"})
    public String home(){
        return "home";
    }

    @RequestMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        // model.addAttribute("jobPost",jobPost); //behind the scenes mapping
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewjobs(Model m){
        List<JobPost> jobs=service.getAllJobs();

        m.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
