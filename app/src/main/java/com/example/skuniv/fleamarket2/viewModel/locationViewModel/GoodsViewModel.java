package com.example.skuniv.fleamarket2.viewModel.locationViewModel;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import java.util.List;

public class GoodsViewModel {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<Integer> price = new ObservableField<>();
    public final ObservableField<Integer> quantity = new ObservableField<>();
    public final ObservableField<Integer> MainCategory = new ObservableField<>();
    public final ObservableField<Integer> MiddleCategory = new ObservableField<>();
    public final ObservableField<String> image = new ObservableField<>();

    public GoodsViewModel(String name, Integer price, Integer quantity, Integer MainCategory,Integer MiddleCategory, String image) {
        this.name.set(name);
        this.price.set(price);
        this.quantity.set(quantity);
        this.MainCategory.set(MainCategory);
        this.MiddleCategory.set(MiddleCategory);
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

    public ObservableField<Integer> getMiddleCategory() {
        return MiddleCategory;
    }

    public ObservableField<Integer> getMainCategory() {
        return MainCategory;
    }

    public ObservableField<String> getImage() {
        return image;
    }
}