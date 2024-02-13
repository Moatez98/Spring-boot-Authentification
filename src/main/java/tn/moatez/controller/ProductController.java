package tn.moatez.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.moatez.dto.ProductDTO;
import tn.moatez.services.ProductService;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getallproducts")
    public ResponseEntity<Set<ProductDTO>> getallproduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct());
    }
        @PostMapping("/saveproduct")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(request));
    }
    @PostMapping("/updateproduct")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.updateProduct(request));
    }
    @PostMapping("/deletproduct")
    public ResponseEntity<?> deletProduct(@RequestBody ProductDTO request){
        productService.deletProduct(request);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }
}
