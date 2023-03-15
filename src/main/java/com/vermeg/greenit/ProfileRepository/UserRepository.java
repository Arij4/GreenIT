package com.vermeg.greenit.ProfileRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.greenit.profile.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   
    User findByMail(String mail);

	User getByMail(String userMail);

	

	void deleteByMail(int userMail);

	


    
}
