package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

// 도메인 데이터와 비즈니스 로직만 담당 — View/Controller 의존 없음
public class ItemRepository {
    private final List<Item> items = new ArrayList<>();
    private int nextId = 1;

    public Item add(String name) {
        Item item = new Item(nextId++, name);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return Collections.unmodifiableList(items);
    }

    public Optional<Item> findById(int id) {
        return items.stream().filter(i -> i.getId() == id).findFirst();
    }

    public boolean deleteById(int id) {
        return items.removeIf(i -> i.getId() == id);
    }
}
