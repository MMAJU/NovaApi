package com.spearhead.nova.service.impl;

import java.util.List;
import java.util.Objects;

import com.spearhead.nova.model.Terms;
import com.spearhead.nova.repository.TermRepository;
import com.spearhead.nova.service.TermService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermsImpl implements TermService{


    @Autowired
    private  TermRepository termRepository;
	@Override
	public Terms saveTerms(Terms terms) {
		// TODO Auto-generated method stub
		return termRepository.save(terms);
	}

	@Override
	public List<Terms> fetchTerms() {
		// TODO Auto-generated method stub
		return termRepository.findAll();
	}

	@Override
	public Terms updateTerms(Long termsId, Terms terms) {
		// TODO Auto-generated method stub
		Terms termDb = termRepository.findById(termsId).get();
		if(Objects.nonNull(terms.getTerms()) && !"".equalsIgnoreCase(terms.getTerms())) {
			termDb.setTerms(terms.getTerms());
		}
		return termRepository.save(termDb);
	}

	@Override
	public void deleteTerms(Long termsId) {
		// TODO Auto-generated method stub
        termRepository.deleteById(termsId);
		
	}
    
}
