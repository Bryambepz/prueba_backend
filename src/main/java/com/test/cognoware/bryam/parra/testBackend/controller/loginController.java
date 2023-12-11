package com.test.cognoware.bryam.parra.testBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.cognoware.bryam.parra.testBackend.response.ResponseWS;

@RestController
@RequestMapping("login")
@CrossOrigin(origins = "*")
public class loginController {
    
    private ResponseWS responseWS;

    @GetMapping( path = "login")
    public ResponseEntity<ResponseWS> login(@RequestParam("user") String user, @RequestParam("password") String password){
        System.out.println("se inicia?");
        if ( user.equals("AdminWebTest") && password.equals("bryamParraTest")) {
            this.responseWS = new ResponseWS(HttpStatus.OK.value(), "Bienvenido", "");
            return ResponseEntity.ok(this.responseWS);
        }
        this.responseWS = new ResponseWS(HttpStatus.UNAUTHORIZED.value(), "Credenciales incorrectas, revise e intente nuevamente", "");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(this.responseWS);
        // return "Credenciales incorrectas, revise e intente nuevamente";
    }

}
