package br.com.digitaldevilsaga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digitaldevilsaga.model.entity.Admin;
import br.com.digitaldevilsaga.model.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public void salvarAdmin(String nome, String senha){
        Admin admin = new Admin(nome, senha);
        adminRepository.save(admin);
    }
}
