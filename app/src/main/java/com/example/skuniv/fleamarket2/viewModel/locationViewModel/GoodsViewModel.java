package com.example.skuniv.fleamarket2.viewModel.locationViewModel;

import android.databinding.ObservableField;

public class GoodsViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<Integer> price = new ObservableField<>();
    public final ObservableField<Integer> quantity = new ObservableField<>();
    public final ObservableField<String> category = new ObservableField<>();
    public final ObservableField<String> image = new ObservableField<>();

    public GoodsViewModel(String name, Integer price, Integer quantity,String category, String image) {
        this.name.set(name);
        this.price.set(price);
        this.quantity.set(quantity);
        this.category.set(category);
        this.image.set(image);
    }


    public ObservableField<String> getName() {
        return name;
    }

    public ObservableField<Integer> getPrice() {
        return price;
    }

    public ObservableField<Integer> getQuantity() {
        return quantity;
    }

    public ObservableField<String> getCategory() {
        return category;
    }

    public ObservableField<String> getImage() {
        return image;
    }
}