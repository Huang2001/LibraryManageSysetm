package cn.edu.ecut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("cn.edu.ecut.service.feigninterface")
public class SystemManageService
{
    public static void main(String[] argv)
    {
        SpringApplication.run(SystemManageService.class);
    }
}
