package net.gestion.pgrecrutement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PgRecrutementApplication {
    public static void main(String[] args) {
        SpringApplication.run(PgRecrutementApplication.class, args);
    }

}
