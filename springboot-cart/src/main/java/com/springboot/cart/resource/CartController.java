package com.springboot.cart.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author mahenderloka
 */
@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getCartDetails/{id}")
    public String getProductsDetails(@PathVariable("id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("https://fakestoreapi.com/carts/"+id, HttpMethod.GET, entity, String.class).getBody();

    }
}
