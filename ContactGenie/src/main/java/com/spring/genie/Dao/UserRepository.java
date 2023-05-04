package com.spring.genie.Dao;
import com.spring.genie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
	

}
