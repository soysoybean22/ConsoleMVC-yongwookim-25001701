package org.example.controller;

import org.example.model.Item;
import org.example.model.ItemRepository;
import org.example.view.ItemView;

import java.util.Scanner;

// 사용자 입력 처리 및 Model ↔ View 중개 — 직접 출력하거나 도메인 로직 구현하지 않음
public class ItemController {
    private final ItemRepository repository;
    private final ItemView view;
    private final Scanner scanner;

    public ItemController(ItemRepository repository, ItemView view) {
        this.repository = repository;
        this.view = view;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            view.showMenu();
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> view.showItems(repository.findAll());
                case "2" -> handleAdd();
                case "3" -> handleDelete();
                case "0" -> { view.showGoodbye(); return; }
                default  -> view.showError("올바른 번호를 입력하세요.");
            }
        }
    }

    private void handleAdd() {
        view.promptInput("이름");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            view.showError("이름을 입력해야 합니다.");
            return;
        }
        Item item = repository.add(name);
        view.showItem(item);
    }

    private void handleDelete() {
        view.promptInput("삭제할 ID");
        try {
            int id = Integer.parseInt(scanner.nextLine().trim());
            boolean removed = repository.deleteById(id);
            view.showDeleteResult(removed, id);
        } catch (NumberFormatException e) {
            view.showError("숫자를 입력하세요.");
        }
    }
}
