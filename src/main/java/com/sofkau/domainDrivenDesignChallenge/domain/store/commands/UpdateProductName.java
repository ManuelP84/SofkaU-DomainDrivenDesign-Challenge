package com.sofkau.domainDrivenDesignChallenge.domain.store.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.domainDrivenDesignChallenge.domain.values.Name;
import com.sofkau.domainDrivenDesignChallenge.domain.values.ProductId;

public class UpdateProductName extends Command {
    private final ProductId productId;
    private final Name      name;

    public UpdateProductName(ProductId productId, Name name) {
        this.productId = productId;
        this.name = name;
    }

    //Getter methods
    public ProductId getProductId() {
        return productId;
    }

    public Name getName() {
        return name;
    }
}
