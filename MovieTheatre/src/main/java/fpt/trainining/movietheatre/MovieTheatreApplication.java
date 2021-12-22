package fpt.trainining.movietheatre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieTheatreApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieTheatreApplication.class, args);
    }
}
