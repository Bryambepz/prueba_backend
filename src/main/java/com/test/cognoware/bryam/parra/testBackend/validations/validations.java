package com.test.cognoware.bryam.parra.testBackend.validations;

import java.time.LocalDateTime;

public class validations {
    
    public boolean validaCedula(String cedula) {
        if (cedula.length() == 10) {
            int suma = 0;
            for (int i = 0; i < cedula.length() - 1; i++) {
                int value = 0;
                if ((i + 1) % 2 != 0) {
                    value = Integer.parseInt(cedula.substring(i, i+1)) * 2;
                    if (value > 9)
                        value = value - 9;
                } else {
                    value = Integer.parseInt(cedula.substring(i,i+1)) * 1;
                }
                suma += value;
            }
            if (Math.abs(30 - suma) == Integer.parseInt(cedula.substring(cedula.length()-1, cedula.length()))) {
                return true;
            } else if ( Math.abs(40 - suma) == Integer.parseInt(cedula.substring(cedula.length()-1, cedula.length()))
            ) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean validaFecha(LocalDateTime date){

        if (date.getYear() > 1957 && date.getYear() < 2000) {
            return true;
        }
        return false;
    }
}
