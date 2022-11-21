package com.example.demo.service;

import com.example.demo.request.UpsertBMIRequest;
import org.springframework.stereotype.Service;

@Service
public class BMIService {
    public Double BMI (UpsertBMIRequest request){
        double bmi =  request.getHeight()/Math.pow(request.getWeight(),2);
        return bmi;
    }
}
