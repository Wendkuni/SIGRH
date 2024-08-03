package mr.sigrh.siggateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SigGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SigGatewayApplication.class, args);
    }

}
