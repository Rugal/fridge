package config;

import ga.rugal.demo.core.entity.Course;
import ga.rugal.demo.core.entity.Registration;
import ga.rugal.demo.core.entity.Student;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author Rugal Bernstein
 */
@Configuration
public class TestApplicationContext {

  @Bean
  public Faker faker() {
    return new Faker();
  }

  @Bean
  @Scope("prototype")
  public Student student() {
    Student student = new Student();
    student.setName("TEST");
    student.setSid(100);
    return student;
  }

  @Bean
  @Scope("prototype")
  public Course course(final Faker faker) {
    Course course = new Course();
    course.setCid(faker.number().numberBetween(1, 100));
    course.setName(faker.name().fullName());
    return course;
  }

  @Bean
  @Scope("prototype")
  public Registration registration(Student student, Course course) {
    Registration registration = new Registration();
    registration.setRid(100);
    registration.setCourse(course);
    registration.setStudent(student);
    return registration;
  }
}
