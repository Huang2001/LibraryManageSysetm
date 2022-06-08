package cn.edu.ecut;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BooksManageServiceApplicationStarter
{
    public static void main(String[] argv)
    {
        SpringApplication.run(BooksManageServiceApplicationStarter.class);
    }
}
