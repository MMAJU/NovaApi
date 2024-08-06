package com.spearhead.nova.service.impl;

import java.util.List;

import com.spearhead.nova.model.Stocks;
import com.spearhead.nova.repository.StocksRepository;
import com.spearhead.nova.service.StocksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StocksImpl implements StocksService {

    @Autowired
    private StocksRepository stockRepository;

    @Override
    public List<Stocks> getAllStocks() {
        // TODO Auto-generated method stub
        return stockRepository.findAll();
    }

    
}
