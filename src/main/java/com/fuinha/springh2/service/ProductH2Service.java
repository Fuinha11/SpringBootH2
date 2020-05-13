package com.fuinha.springh2.service;

import java.util.List;
import java.util.Objects;

import com.fuinha.springh2.data.entity.Product;
import com.fuinha.springh2.data.entity.ProductCosif;
import com.fuinha.springh2.data.entity.ProductStatus;
import com.fuinha.springh2.data.repository.ProductCosifRepository;
import com.fuinha.springh2.data.repository.ProductRepository;
import com.fuinha.springh2.exception.EntityNotFoundException;
import com.fuinha.springh2.web.dto.CreateCosifDto;
import com.fuinha.springh2.web.dto.CreateProductDto;
import com.fuinha.springh2.web.dto.ProductCosifDto;
import com.fuinha.springh2.web.dto.ProductDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductH2Service implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCosifRepository cosifRepository;

    void initiatedb() {

    }

    @Override
    public List<Product> getAllProducts() throws EntityNotFoundException {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Integer id) throws EntityNotFoundException {
        Product product = productRepository.findById(id).orElse(null);
        if (Objects.isNull(product))
            throw new EntityNotFoundException(Product.class, id.toString());
        return product;
    }

    @Override
    public Product createProduct(CreateProductDto dto) throws EntityNotFoundException {
        Product product = new Product();
        product.setDescription(dto.getDescription());
        product.setStatus(ProductStatus.ACTIVE);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductDto dto) throws EntityNotFoundException {
        Product product = getProduct(dto.getId());
        product.setDescription(dto.getDescription());
        product.setStatus(dto.getStatus());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) throws EntityNotFoundException {
        Product product = getProduct(id);
        productRepository.delete(product);
    }

    @Override
    public List<ProductCosif> getAllCosifsByProductId(Integer productId) throws EntityNotFoundException {
        return cosifRepository.findAllByProduct(getProduct(productId));
    }

    @Override
    public ProductCosif getCosif(Integer id) throws EntityNotFoundException {
        ProductCosif cosif = cosifRepository.findById(id).orElse(null);
        if (Objects.isNull(cosif))
            throw new EntityNotFoundException(ProductCosif.class, id.toString());
        return cosif;
    }

    @Override
    public ProductCosif createCosif(CreateCosifDto dto) throws EntityNotFoundException {
        Product product = getProduct(dto.getProductId());
        ProductCosif cosif = new ProductCosif();
        cosif.setProduct(product);
        cosif.setClassification(dto.getClassification());
        cosif.setStatus(ProductStatus.ACTIVE);
        return cosifRepository.save(cosif);
    }

    @Override
    public ProductCosif updateCosif(ProductCosifDto dto) throws EntityNotFoundException {
        ProductCosif cosif = getCosif(dto.getId());
        cosif.setClassification(dto.getClassification());
        cosif.setStatus(dto.getStatus());
        return cosifRepository.save(cosif);
    }

    @Override
    public void deleteCosif(Integer id) throws EntityNotFoundException {
        ProductCosif cosif = getCosif(id);
        cosifRepository.delete(cosif);
    }

}