package bigdemo.bd.service.impl;

import bigdemo.bd.mapper.CourseAdminMapper;
import bigdemo.bd.model.CourseAdmin;
import bigdemo.bd.service.CourseAdminService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
    课程管理模块
 */
@Service
public class CourseAdminServiceImpl implements CourseAdminService {

    @Autowired
    CourseAdminMapper courseAdminMapper;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer addCourse(CourseAdmin courseAdmin) {
        return courseAdminMapper.add(courseAdmin);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer deleteCourse(Integer id) {
        return courseAdminMapper.delete(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer updateCourse(CourseAdmin courseAdmin) {
        return courseAdminMapper.update(courseAdmin);
    }


    @Override
    public List<CourseAdmin> selectCourse() {

        return courseAdminMapper.select();
    }

    @Override
    public List<CourseAdmin> selectKeyCourse() {
        return courseAdminMapper.selectKey();
    }
}
