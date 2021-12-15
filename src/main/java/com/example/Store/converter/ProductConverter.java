package com.example.Store.converter;

import com.example.Store.entity.Image;
import com.example.Store.entity.Product;
import com.example.Store.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends BaseConverter<ProductModel, Product>{
    public ProductConverter() {
        super(ProductConverter::convertToEntity, ProductConverter::convertToModel);
    }

    private static ProductModel convertToModel(Product entityToConvert){
        if (entityToConvert == null) return null;
        return ProductModel.builder()
                .name(entityToConvert.getName())
                .price(entityToConvert.getPrice())
                .imageId(entityToConvert.getImage().getId())
                .build();
    }

    private static Product convertToEntity(ProductModel modelToConvert){
        if (modelToConvert == null) return null;

        Product ProductToReturn = new Product();

        ProductToReturn.setName(modelToConvert.getName());
        ProductToReturn.setPrice(modelToConvert.getPrice());
        Image image = new Image();
        image.setId(modelToConvert.getImageId());
        ProductToReturn.setImage(image);

        return ProductToReturn;
    }
}
