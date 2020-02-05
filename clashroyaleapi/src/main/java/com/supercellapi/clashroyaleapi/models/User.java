package com.supercellapi.clashroyaleapi.models;

import javax.persistence.*;
import java.util.List;


/**
 * author LucasDonizeti
 */
@Entity
public class User extends AbstractEntity {
    private String name;
    private String username;
    private String password;
    private Boolean admin;
    @OneToMany
    private List<Conta> contas;

    public User() {
    }

    public User(String name, String username, String password, Boolean admin, Long id) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.admin = admin;
        super.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

}
