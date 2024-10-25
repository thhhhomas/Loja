package br.com.digitaldevilsaga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.digitaldevilsaga.model.entity.Admin;
import br.com.digitaldevilsaga.model.repository.AdminRepository;

@Service
public class AdminService implements UserDetailsService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException{
        Admin admin =adminRepository.findByNome(nome);
        if(admin == null){
            throw new UsernameNotFoundException("Usuário não encontrado >> " + nome);
        }

        return org.springframework.security.core.userdetails.User
            .withUsername(admin.getNome())
            .password(admin.getSenha())
            .roles("ADMIN")
            .build();
    }

    public void save(Admin admin){
        adminRepository.save(admin);
    }
}
