package br.com.digitaldevilsaga.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.digitaldevilsaga.model.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
    Admin findByNome(String nome);
}
