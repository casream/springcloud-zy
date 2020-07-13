package com.cas.web.service.feign;

import com.cas.pojo.Student;
import com.cas.web.service.base.StudentServiceBase;
import com.cas.web.service.fallback.StudentFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="micro-order" ,path="/student"
//        ,fallbackFactory = StudentFallbackFactory.class
)
public interface StudentService extends StudentServiceBase {

}