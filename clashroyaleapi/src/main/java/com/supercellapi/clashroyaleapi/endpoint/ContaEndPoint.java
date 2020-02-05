package com.supercellapi.clashroyaleapi.endpoint;

import com.supercellapi.clashroyaleapi.models.Conta;
import com.supercellapi.clashroyaleapi.repository.ContaRepository;
import com.supercellapi.clashroyaleapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * author LucasDonizeti
 */
@RestController
@RequestMapping("conta")
public class ContaEndPoint {
    private final ContaRepository contaDAO;

    @Autowired
    public ContaEndPoint(ContaRepository contaDAO) {
        this.contaDAO = contaDAO;
    }

    @Autowired
    public UserRepository userDAO;



    @GetMapping(path = "/{userId}")
    public ResponseEntity<?> contaByUserId(@PathVariable("userId") Long userId) {
        List<Conta> contas = contaDAO.getByUserId(userId);

        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @PostMapping(path = "/{userId}")
    public ResponseEntity<?> save(@RequestBody Conta conta, @PathVariable("userId") Long userId) {
        conta.setUser(userDAO.findById(userId).get());
        return new ResponseEntity<>(contaDAO.save(conta), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (contaDAO.existsById(id)) {
            contaDAO.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateConta(@RequestBody Conta conta) {
        if (contaDAO.existsById(conta.getId())) {
            return new ResponseEntity<>(contaDAO.save(conta), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
