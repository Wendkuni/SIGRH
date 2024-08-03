package mr.sigrh.sigdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SigDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigDiscoveryApplication.class, args);
    }

}
