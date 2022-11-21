package com.example.homework_01.service;

import com.example.homework_01.model.Job;
import com.example.homework_01.request.UpsertJobRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JobService {
    private List<Job> jobs = new ArrayList<>();

    public JobService() {

        jobs.add(new Job("1", "title1", "Des1", "Loca1", 5000, 10000, "email1"));
        jobs.add(new Job("2", "title2", "Des2", "Loca2", 4000, 60000, "email2"));
        jobs.add(new Job("3", "title3", "Des3", "Loco3", 5000, 6500, "email3"));
    }

    public List<Job> getJops() {
        return jobs;
    }

    public Job createJob(UpsertJobRequest request) {
        String id = UUID.randomUUID().toString();
        Job job = new Job(id,
                request.getTitle()
                , request.getDescription()
                , request.getLocation()
                , request.getMinSalary()
                , request.getMaxSalary()
                , request.getEmailTo());
        jobs.add(job);
        return job;
    }

    public Job updateJobById(String id, UpsertJobRequest request) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setDescription(request.getDescription());
                job.setLocation(request.getLocation());
                job.setMinSalary(request.getMinSalary());
                job.setMaxSalary(request.getMaxSalary());
                job.setEmailTo(request.getEmailTo());
                return job;
            }
        }
        return null;
    }

    public Job getJobById(String id, UpsertJobRequest request) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    public void deleteJob(String id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
            }
        }
    }

    public Job randomJob(){
        int id   = new Random().nextInt(jobs.size());
        return jobs.get(id);
    }


    public List<Job> sortJobBySalary(String field, String direction){
        if(field.equalsIgnoreCase("maxSalary")){
            if(direction.equalsIgnoreCase("ASC")){
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary)).toList();
            }else {
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary).reversed()).toList();
            }
        }else return null;
    }
}
