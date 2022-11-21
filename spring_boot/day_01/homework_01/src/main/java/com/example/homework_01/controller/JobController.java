package com.example.homework_01.controller;

import com.example.homework_01.model.Job;
import com.example.homework_01.request.UpsertJobRequest;
import com.example.homework_01.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jobs")
public class JobController {
    @Autowired
    private JobService jobService;
    List<Job> jobs;

    // GET : Lấy danh sách tất cả Job
    @GetMapping("")
    public List<Job> getJobs(){
        return jobService.getJops();
    }
    // POST: Tạo mới 1 job
    @PostMapping("")
    public Job createJob(@RequestBody UpsertJobRequest request){
        return jobService.createJob(request);
    }
    //PUT : Cập nhập thông tin Job
    @PutMapping("{id}")
    public Job updateJob(@PathVariable String id,@RequestBody UpsertJobRequest request){
        return jobService.updateJobById(id,request);
    }
    //GET: Lấy chi tiết 1 Job theo id
    @GetMapping("{id}")
    public  Job getJobById(@PathVariable String id,@RequestBody UpsertJobRequest request){
        return jobService.getJobById(id,request);
    }
    //DELETE: Xóa 1 Job theo id
    @DeleteMapping("{id}")
    public void deleteJob(@PathVariable String id){
        jobService.deleteJob(id);
    }
    //random job : http://localhost:8082/api/v1/jobs/rd
    @GetMapping("/rd")
    public Job randomJob(){
       return jobService.randomJob();
    }
    @GetMapping("/sort")
    public List<Job> sortJobBySalary(@RequestParam(value = "field",defaultValue = "maxSalary") String field,
                                     @RequestParam(value = "direction", defaultValue = "DESC") String direction){
        return jobService.sortJobBySalary(field,direction);
    }
}
