package com.jdbcconnectivity.HospitalManagement.dao;

import com.jdbcconnectivity.HospitalManagement.model.Billing;
import java.util.List;

public interface BillingDAO {

    void generateBill(Billing billing);

    void updatePaymentStatus(int billId, String status);

    List<Billing> getAllBills();
}
