package com.vermeg.greenit.ProfilService;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.greenit.ProfileRepository.ProfileRepository;
import com.vermeg.greenit.profile.Profile;


@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }
    

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }
}