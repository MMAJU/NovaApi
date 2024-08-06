package com.spearhead.nova.service;

import java.util.List;

import com.spearhead.nova.model.About;

public interface AboutService {
    

    public About saveAbout(About about);

public List<About> fetchAbout();

public About updateAbout(Long aboutId, About about);

public void deleteAbout(Long aboutId);
}
