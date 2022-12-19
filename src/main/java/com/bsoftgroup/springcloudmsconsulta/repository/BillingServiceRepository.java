package com.bsoftgroup.springcloudmsconsulta.repository;

import com.bsoftgroup.springcloudmsconsulta.entity.BillingService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingServiceRepository extends JpaRepository<BillingService, Long> {

    List<BillingService> findAllByClientIdAndClientCompanyId(Long clientId, Long clientCompanyId);

}
