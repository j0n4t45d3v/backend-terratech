package br.com.terratech.backendterratech.services;

import br.com.terratech.backendterratech.entities.Product;
import br.com.terratech.backendterratech.entities.User;
import br.com.terratech.backendterratech.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product createProduct(Product product){
    Optional<Product> productExist = productRepository.findById(product.getId());

    if (
            productExist.isEmpty() &&
            product.getId() != null &&
            !product.getName().isEmpty() &&
            !product.getTypeProduct().isEmpty()
    ){
     return productRepository.save(product);
    }
    return null;
  }

  public List<Product> findAllProducts(){
    return productRepository.findAll();
  }



  public void updatedProduct(Product updatedProduct, Long id) throws Exception{
    Optional<Product> productExist = productRepository.findById(id);

    if (productExist.isPresent()){
      Product product = productExist.get();
      if (updatedProduct.getName() != null){
        product.setName(updatedProduct.getName());
      }
      if (updatedProduct.getTypeProduct() != null){
        product.setTypeProduct(updatedProduct.getTypeProduct());
      }
      if (updatedProduct.getQuantity() != null){
        product.setQuantity(updatedProduct.getQuantity());
      }

      productRepository.save(product);
    }else {
      throw new Exception("Produto não encontrado");
    }
  }

  public void delete (long id) throws Exception {
    Optional<Product> productExist = productRepository.findById(id);

    if (productExist.isPresent()){
      productRepository.deleteById(id);
    }else {
      throw new Exception("Produto não encontrado");
    }
  }
}
