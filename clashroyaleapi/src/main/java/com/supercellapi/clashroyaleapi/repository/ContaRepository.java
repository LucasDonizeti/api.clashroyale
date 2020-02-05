package com.supercellapi.clashroyaleapi.repository;

import com.supercellapi.clashroyaleapi.models.Conta;
import com.supercellapi.clashroyaleapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * author LucasDonizeti
 */
public interface ContaRepository extends JpaRepository<Conta,Long> {
    public List<Conta> getByUser(User user);
    public List<Conta> getByUserId(Long userId);
    public void deleteByUserId(Long userId);
}
