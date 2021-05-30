package com.springrest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao coursedao;
	
	public CourseServiceImpl() {
		
	}
	@Override
	public List<Course> getCourses() {
		return coursedao.findAll();
	}
	@Override
	public Course getCourse(int courseId) {
		return coursedao.getOne(courseId);
	}
	@Override
	public Course addCourse(Course course) {
		coursedao.save(course);
		return course;
	}
	@Override
	public Course updateCourse(Course course) {
		coursedao.save(course);
		return course;
	}
	@Override
	public void deleteCourse(int parseint) {
		Course entity = coursedao.getOne(parseint);
		coursedao.delete(entity);
	}
	
}