package com.spearhead.nova.service.impl;

import java.util.List;
import java.util.Objects;

import com.spearhead.nova.model.Faq;
import com.spearhead.nova.repository.FaqRepository;
import com.spearhead.nova.service.FaqService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqImpl implements FaqService{

    @Autowired
	private FaqRepository faqRepository;

	@Override
	public Faq saveFaq(Faq faq) {
		// TODO Auto-generated method stub
		return faqRepository.save(faq);
	}

	@Override
	public List<Faq> fetchFaq() {
		// TODO Auto-generated method stub
		return faqRepository.findAll();
	}

	@Override
	public Faq updateFaq(Long faqId, Faq faq) {
		// TODO Auto-generated method stub
		Faq faqDb = faqRepository.findById(faqId).get();
		if(Objects.nonNull(faq.getFaquest()) && !"".equalsIgnoreCase(faq.getFaquest())) {
			faqDb.setFaquest(faq.getFaquest());
		}
		if(Objects.nonNull(faq.getFaqans()) && !"".equalsIgnoreCase(faq.getFaqans())) {
			faqDb.setFaqans(faq.getFaqans());
		}
		return faqRepository.save(faqDb);
	}

	@Override
	public void deletefaq(Long faqId) {
		// TODO Auto-generated method stub
        faqRepository.deleteById(faqId);
		
	}
    
}
