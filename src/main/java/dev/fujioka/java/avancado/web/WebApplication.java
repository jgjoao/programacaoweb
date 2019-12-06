package dev.fujioka.java.avancado.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.github.javafaker.Faker;
import com.google.common.base.Optional;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.service.ProductService;

@SpringBootApplication
@EnableJpaAuditing
public class WebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
    	
    	
    	
		 Faker faker = new Faker();
		 for (int i = 0; i < 2001; i++) {
			 String v ;
			 Product test3 = new Product();
			 ProductService product = new ProductService();
			// aqui ta dando erro 
			 v = product.save(faker.animal());
			  
			
			  
	        }

    	
    	
        SpringApplication.run(WebApplication.class, args);
    }

}
