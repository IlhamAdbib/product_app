package com.spring.student_app;

import com.spring.student_app.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.spring.student_app.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class StudentAppApplication implements CommandLineRunner {
   @Autowired
    private ProductRepository productRepository;



    public static void main(String[] args) {
        SpringApplication.run(StudentAppApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null, "computer", 2300, 3));
        productRepository.save(new Product(null, "printer", 1300, 5));
        productRepository.save(new Product(null, "scanner", 20000, 8));
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("*************");
        System.out.println("--------");
        List<Product> productList=productRepository.findByNameContains("c");
        for (Product p : productList) {
            System.out.println(p);
        }
        List<Product> productList1=productRepository.findByPriceGreaterThan(3000);
        for (Product p : productList1) {
            System.out.println(p);
        }

        List<Product> productList2=productRepository.searchByPrice(3000);
        for (Product p : productList2) {
            System.out.println(p);
        }
    }
}
