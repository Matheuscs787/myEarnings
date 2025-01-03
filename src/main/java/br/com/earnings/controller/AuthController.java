package br.com.earnings.controller;

import br.com.earnings.dto.LoginDTO;
import br.com.earnings.security.Token;
import br.com.earnings.util.TokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody LoginDTO dadosLogin) {
        if(dadosLogin.username().equals("admin") && dadosLogin.password().equals("admin")) {
            Token token = TokenUtil.encode(dadosLogin);

            if (token != null) {
                return ResponseEntity.ok(token);
            }
        }
        return ResponseEntity.status(403).build();
    }
}
