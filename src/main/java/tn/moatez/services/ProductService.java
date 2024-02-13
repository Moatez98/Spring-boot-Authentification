package tn.moatez.services;

import tn.moatez.dto.ProductDTO;

import java.util.Set;

public interface ProductService {
    ProductDTO saveProduct(ProductDTO productDTO);
    Set<ProductDTO> getAllProduct();

    ProductDTO updateProduct(ProductDTO productDTO);
    void deletProduct(ProductDTO productDTO);
}
