package com.sofkau.domainDrivenDesignChallenge.domain.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.Price;
import com.sofkau.domainDrivenDesignChallenge.domain.store.values.StoreId;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class CreateProduct extends Command {
    private final StoreId storeId;
    private final ProductId productId;
    private final Name      name;
    private final Price     price;

    public CreateProduct(StoreId storeId, ProductId productId, Name name, Price price) {
        this.storeId = storeId;
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    //Getter methods
    public StoreId getStoreId() {
        return storeId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Name getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
