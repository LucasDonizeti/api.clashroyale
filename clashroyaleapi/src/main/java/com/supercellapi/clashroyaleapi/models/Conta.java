package com.supercellapi.clashroyaleapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import javax.persistence.*;

/**
 * author LucasDonizeti
 */
@Entity
public class Conta extends AbstractEntity {
    private String tag;
    @ManyToOne
    @JsonIgnore
    private User user;

    @JsonIgnore
    private final String TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjlhN2ViZDQwLWIwNjctNGNjMi1iMGMxLTZmMDNhMTVhNWMyYiIsImlhdCI6MTU4MDg0MzIwNiwic3ViIjoiZGV2ZWxvcGVyL2M1YTA2Njc3LTU0ODctY2RjNS02YTA3LTdhYTNhMjM1NDZkMyIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIxMzguMjA0LjkxLjg1Il0sInR5cGUiOiJjbGllbnQifV19.51E-ZvVxI6QpDfshQMSQybcglwrTRtrC-7V41BRbrPner-zb1xxUk9qp9mCTcA_NGz89XsugkqDHEnoF3nuGsA";

    public Conta() {

    }

    public Conta(String tag, User user, Long id) {
        this.tag = tag;
        this.user = user;
        super.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Player getPlayerFromSupercell() {
        try {
            String playerTag = "%" + getTag();
            RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://api.clashroyale.com/v1/players").
                    defaultHeader("Authorization", TOKEN).build();
            ResponseEntity<Player> req = restTemplate.getForEntity("/{playerTag}", Player.class, playerTag);
            Player player = req.getBody();
            return player;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
