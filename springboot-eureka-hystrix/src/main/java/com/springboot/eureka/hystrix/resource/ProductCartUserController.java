package com.springboot.eureka.hystrix.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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
@RequestMapping("/shopping")
public class ProductCartUserController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/getShoppingProductDetails/{id}")
    public String getShoppingProductDetails(@PathVariable("id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://products-micro-service/products/getProductsDetails/"+id, HttpMethod.GET, entity, String.class).getBody();

    }

    @GetMapping("/getShoppingCartDetails/{id}")
    public String getShoppingCartDetails(@PathVariable("id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://carts-micro-service/carts/getCartDetails/"+id, HttpMethod.GET, entity, String.class).getBody();

    }

    @GetMapping("/getShoppingUserDetails/{id}")
    public String getShoppingUserDetails(@PathVariable("id") String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://users-micro-service/users/getUserDetails/"+id, HttpMethod.GET, entity, String.class).getBody();

    }
}
