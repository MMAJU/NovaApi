package com.spearhead.nova.service.impl;

import java.util.List;
import java.util.Objects;

import com.spearhead.nova.model.About;
import com.spearhead.nova.repository.AboutRepository;
import com.spearhead.nova.service.AboutService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutImpl implements AboutService{


    @Autowired
    private AboutRepository aboutRepo;

	@Override
	public About saveAbout(About about) {
		// TODO Auto-generated method stub
		return aboutRepo.save(about);
	}

	@Override
	public List<About> fetchAbout() {
		// TODO Auto-generated method stub
		return aboutRepo.findAll();
	}

	@Override
	public About updateAbout(Long aboutId, About about) {
		// TODO Auto-generated method stub
		About aboutDb = aboutRepo.findById(aboutId).get();
		if(Objects.nonNull(about.getAboutText()) && !"".equalsIgnoreCase(about.getAboutText())) {
			aboutDb.setAboutText(about.getAboutText());
		}
		
		return aboutRepo.save(aboutDb);
	}

	@Override
	public void deleteAbout(Long aboutId) {
		// TODO Auto-generated method stub
        aboutRepo.deleteById(aboutId);
		
	}
    
}
