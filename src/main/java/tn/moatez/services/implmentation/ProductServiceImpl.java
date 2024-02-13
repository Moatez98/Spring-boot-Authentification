package tn.moatez.services.implmentation;

import org.springframework.stereotype.Service;
import tn.moatez.dto.ProductDTO;
import tn.moatez.model.Product;
import tn.moatez.repository.ProductRepository;
import tn.moatez.services.ProductService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        return ProductDTO.mapEntityToDTO(repository.save(Product.mapDTOtoEntity(productDTO)));
    }

    @Override
    public Set<ProductDTO> getAllProduct() {
        List<Product> products= repository.findAll();
        return products.stream().map(ProductDTO::mapEntityToDTO).collect(Collectors.toSet());
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product productToupdate = repository.findById(productDTO.getId()).orElse(null);
        assert productToupdate != null;
        productToupdate.setDescription(productDTO.getDescription());
        productToupdate.setLabel(productDTO.getLabel());
        productToupdate.setPrice(productDTO.getPrice());
        productToupdate.setQuantite(productDTO.getQuantite());

        return ProductDTO.mapEntityToDTO(repository.save(productToupdate));
    }

    @Override
    public void deletProduct(ProductDTO productDTO) {
            repository.deleteById(productDTO.getId());
    }
}
