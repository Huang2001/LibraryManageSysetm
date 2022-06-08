package cn.edu.ecut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterCenterApplication
{
    public static void main(String[] argv)
    {
        SpringApplication.run(RegisterCenterApplication.class);
    }
}
