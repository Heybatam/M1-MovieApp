package com.example.Front.Web.Service;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;


@EnableCircuitBreaker
@SpringBootApplication
public class FrontWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontWebServiceApplication.class, args);
	}

}
