package com.vermeg.greenit.ProfileController;

import java.util.HashMap;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vermeg.greenit.ProfilService.ProfileService;
import com.vermeg.greenit.ProfileRepository.ProfileRepository;
import com.vermeg.greenit.profile.Profile;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private ProfileService profileService;

	@GetMapping("/profile")

	public String getProfile() {
		return "ProfileController";
	}
	@GetMapping("/username")
	public String showUsernamen(Model model) {
		model.addAttribute("Profile", new Profile());

		return "username";
		
	}
	@PostMapping("/username")
	public String submitUsername(@ModelAttribute("Profile") Profile profile) {

		profileService.saveProfile(profile);
		return "redirect:/ProfileController/itinerary";
	}

	@GetMapping("/itinerary")
	public String showItinerary(Model model) {
		model.addAttribute("Profile", new Profile());

		return "itinerary";
	}

	@PostMapping("/itinerary")
	public String submitItinerary(@ModelAttribute("profile") Profile profile) {

		profileService.saveProfile(profile);
		return "redirect:/ProfileController/address";
	}

	@GetMapping("/address")
	public String showAddress(Model model) {
		model.addAttribute("Profile", new Profile());

		return "address";
	}

	@PostMapping("/address")
	public String submitAddress(@ModelAttribute("profile") Profile profile) {

		profileService.saveProfile(profile);
		return "redirect:/ProfileController/addressJob";
	}

	@GetMapping("/addressJob")
	public String showAddressJob(Model model) {
		model.addAttribute("Profile", new Profile());

		return "addressJob";
	}

	@PostMapping("/addressJob")
	public String submitAddressJob(@ModelAttribute("profile") Profile profile) {

		profileService.saveProfile(profile);
		return "redirect:/ProfileController/calendar";
	}

	@GetMapping("/calendar")
	public String showCalendar(Model model) {
		model.addAttribute("Profile", new Profile());

		return "calendar";
	}

	@PostMapping("/calendar")
	public String submitCalender(@ModelAttribute("profile") Profile profile) {

		profileService.saveProfile(profile);
		return "redirect:/ProfileController/number";
	}

	@GetMapping("/number")
	public String showNumber(Model model) {
		model.addAttribute("Profile", new Profile());

		return "number";
	}

	@PostMapping("/number")
	public String submitNumber(@ModelAttribute("profile") Profile profile) {

		profileService.saveProfile(profile);
		return "redirect:/ProfileController/confirmation";
	}

	@GetMapping("/confirmation")
	public String showConfirmation(Model model) {
		model.addAttribute("Profile", new Profile());

		return "confirmation";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Profile> getProfileById(@PathVariable Long id) throws Exception {
		Profile profile = profileService.getProfileById(id);
		if (profile == null) {
			throw new Exception("Profile not found with id: " + id);
		}
		return ResponseEntity.ok(profile);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Profile> updateProfile(@PathVariable(value = "id") Long profileId, @Validated

	@RequestBody Profile profileDetails) throws Exception {

		Profile profile = profileRepository.findById(profileId)

				.orElseThrow(() -> new Exception("Profile not found for this id ::" + profileId));
		profile.setUsername(profileDetails.getUsername());
		profile.setItinerary(profileDetails.getItinerary());
		profile.setAddress(profileDetails.getAddress());
		profile.setAddressJob(profileDetails.getAddressJob());

		profile.setCalendar(profileDetails.getCalendar());
		final Profile updatedProfile = profileRepository.save(profile);
		return ResponseEntity.ok(updatedProfile);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteProfile(@PathVariable(value = "id") Long profileId) throws Exception {
		Profile Profile = profileRepository.findById(profileId)
				.orElseThrow(() -> new Exception("profile not found for this id ::" + profileId));
		profileRepository.delete(Profile);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", true);

		return response;
	}

}