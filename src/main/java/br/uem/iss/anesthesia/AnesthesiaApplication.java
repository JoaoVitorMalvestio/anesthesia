package br.uem.iss.anesthesia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.*"})
public class AnesthesiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnesthesiaApplication.class, args);
    }
}
