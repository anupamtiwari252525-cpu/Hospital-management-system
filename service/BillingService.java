package com.jdbcconnectivity.HospitalManagement.service;

import com.jdbcconnectivity.HospitalManagement.model.Billing;
import java.util.List;

public interface BillingService {

    void generateBill(Billing billing);

    void updatePaymentStatus(int billId, String status);

    List<Billing> getAllBills();
}
