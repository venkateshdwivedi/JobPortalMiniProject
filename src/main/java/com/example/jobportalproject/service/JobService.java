package com.example.jobportalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobportalproject.model.JobPost;
import com.example.jobportalproject.repo.JobRepo;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;


    public void addJob(JobPost jobpost){
        repo.addJob(jobpost);
    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
    }
}
