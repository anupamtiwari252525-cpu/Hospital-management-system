package com.jdbcconnectivity.HospitalManagement.dao.impl;

import com.jdbcconnectivity.HospitalManagement.dao.BillingDAO;
import com.jdbcconnectivity.HospitalManagement.model.Billing;
import com.jdbcconnectivity.HospitalManagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public void generateBill(Billing billing) {

        String sql =
            "INSERT INTO billing(patient_id, amount, bill_date, status) VALUES (?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billing.getPatientId());
            ps.setDouble(2, billing.getAmount());
            ps.setDate(3, billing.getBillDate());
            ps.setString(4, billing.getStatus());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePaymentStatus(int billId, String status) {

        String sql = "UPDATE billing SET status=? WHERE bill_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, billId);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Billing> getAllBills() {

        List<Billing> list = new ArrayList<>();
        String sql = "SELECT * FROM billing";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Billing b = new Billing();
                b.setBillId(rs.getInt("bill_id"));
                b.setPatientId(rs.getInt("patient_id"));
                b.setAmount(rs.getDouble("amount"));
                b.setBillDate(rs.getDate("bill_date"));
                b.setStatus(rs.getString("status"));
                list.add(b);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
