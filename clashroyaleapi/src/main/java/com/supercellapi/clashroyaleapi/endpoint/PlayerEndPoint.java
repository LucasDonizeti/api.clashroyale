package com.supercellapi.clashroyaleapi.endpoint;

import com.supercellapi.clashroyaleapi.models.Conta;
import com.supercellapi.clashroyaleapi.models.Player;
import com.supercellapi.clashroyaleapi.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * author LucasDonizeti
 */
@RestController
@RequestMapping("player")
public class PlayerEndPoint {
    @Autowired
    public ContaRepository contaDAO;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> playerByContaId(@PathVariable("id") Long id) {
        if (contaDAO.existsById(id)) {
            try {
                Conta conta = contaDAO.findById(id).get();
                System.out.println(conta.getTag());
                Player player = conta.getPlayerFromSupercell();
                return new ResponseEntity<>(player, HttpStatus.OK);
            }catch (Exception exception){
                return new ResponseEntity<>("player not exist",HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "user/{userId}")
    public ResponseEntity<?> contaByUserId(@PathVariable("userId") Long userId) {
        List<Conta> contas = contaDAO.getByUserId(userId);
        List<Player> players = new ArrayList<Player>();
        for (int x = 0; x < contas.size(); x++)
            players.add(contas.get(x).getPlayerFromSupercell());
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}
