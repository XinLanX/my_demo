package com.xxl.mydemo.demos.helloworld.entity;

import java.util.Collections;
import java.util.List;

public class Items<T> {

    private Long count;
    private List<T> items = Collections.emptyList();

    public static <T> Items<T> of(List<T> items) {
        Items<T> result = new Items();
        result.items = items;
        return result;
    }

    public static <T> Items<T> of(List<T> items, Long count) {
        Items<T> result = of(items);
        result.count = count;
        return result;
    }
    public Items() {
    }

    public Long getCount() {
        return this.count;
    }

    public List<T> getItems() {
        return this.items;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }


    protected boolean canEqual(Object other) {
        return other instanceof Items;
    }


}
