package br.com.everson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication

@ComponentScan
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        //para add um usuario novo com uma senha personalizada, deve-se criar um metodo
       /* BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
        String result = bCryptPasswordEncoder.encode("admin1010");
        System.out.println("My hash " + result);*/

    }
}
