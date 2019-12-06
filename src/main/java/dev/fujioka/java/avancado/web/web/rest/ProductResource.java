package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.repository.ProductRepository;
import dev.fujioka.java.avancado.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;


    @GetMapping("/product")
    public List<Product> getProductList() {

        return productService.findAll();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(
            @RequestBody Product product) {
    	   
        
        product = productService.save(product).get(); ;

        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> update(
            @RequestBody Product product) {
         
    	
    	
        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> delete(
            @RequestBody Product product) {

        productService.delete(product);
        return ResponseEntity.ok().body("Product excluded " + product.getId());
    }

    @PostMapping("/teste")
    public JsonNode getRandomPersons() {

        Faker faker = new Faker();
        ArrayNode persons = productService.createArrayNode();

        for (int i = 0; i < 2001; i++) {
            //persons.add(productService.createObjectNode()
            persons.add( faker.name().firstName());
            persons.add( faker.name().lastName());
            persons.add( faker.name().title());
            persons.add( faker.name().suffix());
            persons.add(faker.address().streetAddress());
            persons.add( faker.address().cityName());
            persons.add( faker.address().country());
        }

        return persons;
    }
    

}
