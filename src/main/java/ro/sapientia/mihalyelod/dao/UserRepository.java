package ro.sapientia.mihalyelod.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.sapientia.mihalyelod.pojo.UserPojo;

public interface UserRepository extends JpaRepository<UserPojo, Integer>{

}
