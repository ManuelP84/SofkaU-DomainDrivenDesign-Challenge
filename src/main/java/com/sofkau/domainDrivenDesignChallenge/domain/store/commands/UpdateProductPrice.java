package com.sofkau.domainDrivenDesignChallenge.domain.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.Price;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class UpdateProductPrice extends Command {
    private final ProductId productId;
    private final Price price;

    public UpdateProductPrice(ProductId productId, Price price){
        this.productId = productId;
        this.price = price;
    }

    //Getter methods
    public ProductId getProductId() {
        return productId;
    }

    public Price getPrice() {
        return price;
    }
}
