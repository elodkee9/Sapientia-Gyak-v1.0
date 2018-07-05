package ro.sapientia.mihalyelod.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.sapientia.mihalyelod.pojo.StudentPojo;

@Repository
public interface StudentRepository extends JpaRepository<StudentPojo, Integer> {

}
