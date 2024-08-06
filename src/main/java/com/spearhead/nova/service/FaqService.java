package com.spearhead.nova.service;

import java.util.List;

import com.spearhead.nova.model.Faq;

public interface FaqService {

    public Faq saveFaq(Faq faq);

public List<Faq> fetchFaq();

public Faq updateFaq(Long faqId, Faq faq);

public void deletefaq(Long faqId);
    
}
