package com.example.skuniv.fleamarket2.viewmodel;

import android.databinding.ObservableField;

public class ShopViewModel {
    public final ObservableField<String> section = new ObservableField<>();
    public final ObservableField<String> num = new ObservableField<>();

    public ShopViewModel(String section, String num) {
        this.section.set(section);
        this.num.set(num);
    }
}
