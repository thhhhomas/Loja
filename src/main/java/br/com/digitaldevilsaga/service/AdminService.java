package br.com.digitaldevilsaga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.digitaldevilsaga.dto.NovoAdministradorDto;
import br.com.digitaldevilsaga.model.entity.Admin;
import br.com.digitaldevilsaga.repository.AdminRepository;

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

    public void save(NovoAdministradorDto novoAdministradorDto){
        Admin adminSenhaCriptografada = new Admin();

        adminSenhaCriptografada.setNome(novoAdministradorDto.getNome());
        adminSenhaCriptografada.setSenha(new BCryptPasswordEncoder().encode(novoAdministradorDto.getSenha()));
        adminRepository.save(adminSenhaCriptografada);
    }

    public void excluir(int id){
        adminRepository.deleteById(id);
    }

    public void excluirbyNome(String nome){
        Admin admin = adminRepository.findByNome(nome);

        adminRepository.delete(admin);
    }
}
