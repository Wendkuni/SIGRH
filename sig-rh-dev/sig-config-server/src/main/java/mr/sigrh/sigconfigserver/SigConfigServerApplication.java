package mr.sigrh.sigconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SigConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigConfigServerApplication.class, args);
    }

}
