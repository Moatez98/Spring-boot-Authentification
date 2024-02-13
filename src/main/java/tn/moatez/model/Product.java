package tn.moatez.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import tn.moatez.dto.ProductDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product extends AbstractBaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private String description;
    private double price;
    private int quantite;
    public static Product mapDTOtoEntity(ProductDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Product.class);
    }

}
