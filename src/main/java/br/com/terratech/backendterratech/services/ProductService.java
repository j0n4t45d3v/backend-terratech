package br.com.terratech.backendterratech.services;

import br.com.terratech.backendterratech.entities.Product;
import br.com.terratech.backendterratech.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  @GetMapping
  public List<Product> findAllProducts(){
    return productRepository.findAll();
  }
}
