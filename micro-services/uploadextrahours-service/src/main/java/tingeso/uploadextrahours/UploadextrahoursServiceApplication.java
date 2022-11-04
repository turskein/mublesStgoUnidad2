package tingeso.uploadextrahours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UploadextrahoursServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadextrahoursServiceApplication.class, args);
    }

}
