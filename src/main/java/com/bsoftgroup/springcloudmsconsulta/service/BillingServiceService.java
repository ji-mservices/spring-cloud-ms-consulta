package com.bsoftgroup.springcloudmsconsulta.service;

import com.bsoftgroup.springcloudmsconsulta.entity.BillingService;
import com.bsoftgroup.springcloudmsconsulta.repository.BillingServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceService {

    @Autowired
    private BillingServiceRepository billingServiceRepository;

    public List<BillingService> getServices() {
        return billingServiceRepository.findAll();
    }

    public List<BillingService> getServices(Long idClient, Long idCompany) {
        return billingServiceRepository.findAllByClientIdAndClientCompanyId(idClient, idCompany);
    }
}
