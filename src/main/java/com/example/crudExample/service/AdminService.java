package com.example.crudExample.service;

import com.example.crudExample.model.Admin;
import com.example.crudExample.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(String id) {
        return adminRepository.findById(id);
    }

    public Admin saveAdmin(@Valid Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(String id) {
        adminRepository.deleteById(id);
    }

    public Admin updateAdmin(String id, @Valid Admin adminDetails) {
        adminDetails.setAdminId(id);
        return adminRepository.save(adminDetails);
    }
}
