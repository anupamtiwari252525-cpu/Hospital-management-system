package com.jdbcconnectivity.HospitalManagement.service.impl;

import com.jdbcconnectivity.HospitalManagement.dao.BillingDAO;
import com.jdbcconnectivity.HospitalManagement.dao.impl.BillingDAOImpl;
import com.jdbcconnectivity.HospitalManagement.model.Billing;
import com.jdbcconnectivity.HospitalManagement.service.BillingService;

import java.util.List;

public class BillingServiceImpl implements BillingService {

    private BillingDAO billingDAO = new BillingDAOImpl();

    @Override
    public void generateBill(Billing billing) {
        billingDAO.generateBill(billing);
    }

    @Override
    public void updatePaymentStatus(int billId, String status) {
        billingDAO.updatePaymentStatus(billId, status);
    }

    @Override
    public List<Billing> getAllBills() {
        return billingDAO.getAllBills();
    }
}
