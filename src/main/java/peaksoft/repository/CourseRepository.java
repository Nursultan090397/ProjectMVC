package peaksoft.repository;

import peaksoft.model.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> getAllCourses();

    void addCourse(Long id, Course course);

    Course getCourseById(Long id);

    void updateCourse(Course course, Long id);

    void deleteCourse(Long id);
}