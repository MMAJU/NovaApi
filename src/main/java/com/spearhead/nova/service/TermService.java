package com.spearhead.nova.service;

import java.util.List;

import com.spearhead.nova.model.Terms;

public interface TermService {

    public Terms saveTerms(Terms terms);

public List<Terms> fetchTerms();

public Terms updateTerms(Long termsId, Terms terms);

public void deleteTerms(Long termsId);
    
}
