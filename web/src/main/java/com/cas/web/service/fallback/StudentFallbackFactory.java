package com.cas.web.service.fallback;

import com.cas.pojo.Student;
import com.cas.web.service.feign.StudentService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Classname StudentFallbackFactory
 * @Description TODO
 * @Date 2020/7/12 23:36
 * @Created by Administrator
 */
public class StudentFallbackFactory implements FallbackFactory<StudentService> {
    @Override
    public StudentService create(Throwable throwable) {
        String message ="=========Student fallback=========" +  throwable.getMessage();

        return new StudentService() {
            private Logger log = LoggerFactory.getLogger(StudentFallbackFactory.class);
            @Override
            public int deleteByPrimaryKey(Integer id) {
                log.info(message);
                return 0;
            }

            @Override
            public int insert(Student record) {
                log.info(message);
                return 0;
            }

            @Override
            public Student selectByPrimaryKey(Integer id) {
                log.info(message);
                return null;
            }

            @Override
            public List<Student> selectAll() {
                log.info(message);
                return null;
            }

            @Override
            public int updateByPrimaryKey(Student record) {
                log.info(message);
                return 0;
            }

            @Override
            public String errorMessage() {
                log.info(message);
                return null;
            }
        };
    }
}
