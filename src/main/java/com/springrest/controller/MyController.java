package com.springrest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.entities.Course;
import com.springrest.service.CourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MyController {
	
	@Autowired
	private CourseService courseservice;
	
	//get the course
	@GetMapping("/courses")
	public List<Course> getCourse(){
		return this.courseservice.getCourses();
	}
	
	//get the course by id
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseservice.getCourse(Integer.parseInt(courseId));
	}
	
	//adding the course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);
	}
	
	//updating the course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseservice.updateCourse(course);
	}
	
	//updating the course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseservice.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}