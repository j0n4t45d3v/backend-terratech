package br.com.terratech.backendterratech.controllers;

import br.com.terratech.backendterratech.entities.Product;
import br.com.terratech.backendterratech.entities.User;
import br.com.terratech.backendterratech.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping
  public ResponseEntity<Product> create(@RequestBody Product product){
    Product create = productService.createProduct(product);
    if (create !=  null){
      return ResponseEntity.ok(create);
    }else {
      return ResponseEntity.badRequest().build();
    }
  }

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {
    List<Product> products = productService.findAllProducts();
    return ResponseEntity.ok(products);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@RequestBody Product product, @PathVariable("id") Long id){
    try {
      productService.updatedProduct(product,id);
      return ResponseEntity.ok("Produto Atualizado");
    }catch (Exception err){
      return ResponseEntity.internalServerError().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") long id){
    try{
      productService.delete(id);
      return ResponseEntity.ok("Produto removido");
    }catch (Exception err){
      return ResponseEntity.internalServerError().build();
    }
  }


}
