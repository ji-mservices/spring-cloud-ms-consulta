package com.bsoftgroup.springcloudmsconsulta.controller;

import com.bsoftgroup.springcloudmsconsulta.bean.BillingServiceBean;
import com.bsoftgroup.springcloudmsconsulta.bean.ClientBean;
import com.bsoftgroup.springcloudmsconsulta.bean.CompanyBean;
import com.bsoftgroup.springcloudmsconsulta.bean.ProductBean;
import com.bsoftgroup.springcloudmsconsulta.entity.BillingService;
import com.bsoftgroup.springcloudmsconsulta.service.BillingServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BillingServiceController {

    private final BillingServiceService billingServiceService;

    private final Environment environment;

    @GetMapping(path = "/billing")
    public List<BillingServiceBean> getServices() {

        log.info("Port: " + environment.getProperty(("local.server.port")));

        return billingServiceService.getServices()
                .stream()
                .map(this::toBillingServiceBean)
                .toList();
    }

    @GetMapping(path = "/billing/idClient/{idClient}/idCompany/{idCompany}")
    public List<BillingServiceBean> getServices(@PathVariable("idClient") Long idClient,
                                                @PathVariable("idCompany") Long idCompany) {

        log.info("Port: " + environment.getProperty(("local.server.port")));

        return billingServiceService.getServices(idClient, idCompany)
                .stream()
                .map(this::toBillingServiceBean)
                .toList();
    }

    private BillingServiceBean toBillingServiceBean(BillingService billingService) {

        CompanyBean companyBean =
                new CompanyBean(billingService.getClient().getCompany().getId(),
                        billingService.getClient().getCompany().getName());

        ClientBean clientBean =
                new ClientBean(billingService.getClient().getId(),
                        billingService.getClient().getName(), companyBean);

        ProductBean productBean =
                new ProductBean(billingService.getProduct().getId(),
                        billingService.getProduct().getDescription(),
                        billingService.getProduct().getPrice());

        return new BillingServiceBean(billingService.getId(),
                billingService.getStatus(),
                billingService.getAmount(),
                clientBean, productBean);

    }

}
