package tn.moatez.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import tn.moatez.model.Product;

@Data
public class ProductDTO {
    private Long id;
    private String label;
    private String description;
    private double price;
    private int quantite;
    public static ProductDTO mapEntityToDTO(Product entity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, ProductDTO.class);
    }
}
