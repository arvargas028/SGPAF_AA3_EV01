package com.sgpaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación web SGPAF.
 * 
 * Esta clase configura el inicio del proyecto usando el framework Spring Boot.
 */

@SpringBootApplication
public class SgpafApplication {

    public static void main (String[] args) {
        SpringApplication.run(SgpafApplication.class,args);
    }
}

