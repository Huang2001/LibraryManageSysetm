package cn.edu.ecut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("cn.edu.ecut.service.feigninterface")
public class BooksLendServiceApplicationService
{
    public static void main(String[] argv)
    {
        SpringApplication.run(BooksLendServiceApplicationService.class);
    }
}
