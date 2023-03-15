package com.vermeg.greenit.ProfileRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vermeg.greenit.profile.Profile;



@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long > {
	Profile findByEmail(String email);
   
    
    
}
