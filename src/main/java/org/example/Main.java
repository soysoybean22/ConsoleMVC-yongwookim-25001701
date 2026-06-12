package org.example;

import org.example.controller.ItemController;
import org.example.model.ItemRepository;
import org.example.view.ItemView;

public class Main {
    public static void main(String[] args) {
        ItemRepository repository = new ItemRepository();
        ItemView view = new ItemView();
        ItemController controller = new ItemController(repository, view);
        controller.run();
    }
}
