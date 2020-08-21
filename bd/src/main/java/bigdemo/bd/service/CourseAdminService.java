package bigdemo.bd.service;

import bigdemo.bd.mapper.CourseAdminMapper;
import bigdemo.bd.model.CourseAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CourseAdminService {

    public Integer addCourse(CourseAdmin courseAdmin);
    public Integer deleteCourse(Integer id);
    public Integer updateCourse(CourseAdmin courseAdmin);
    public List<CourseAdmin> selectCourse();
    public List<CourseAdmin> selectKeyCourse();

}
