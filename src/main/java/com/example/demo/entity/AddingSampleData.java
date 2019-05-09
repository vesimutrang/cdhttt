package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.repository.ProductRepository;

@Component
public class AddingSampleData {

    @Autowired
    private ProductRepository productRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

    	Image image1 = new Image("Dell_1.jpeg", "demo image1", "base64/bla");
    	Image image2 = new Image("Dell_2.jpeg", "demo image1", "base64/bla");
    	Image image3 = new Image("Dell_3.jpeg", "demo image1", "base64/bla");
    	
    	Set<Image> images = new HashSet<Image>();
    	images.add(image1);
    	images.add(image2);
    	images.add(image3);
    	
    	Product product = new Product("Dell 2245", 3000000, 20, "Dell", "Just is short description", "And this is full description", images);
    	productRepository.save(product);
    }
}