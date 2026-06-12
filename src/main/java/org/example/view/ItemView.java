package org.example.view;

import org.example.model.Item;

import java.util.List;

// 출력만 담당 — 비즈니스 로직 없음, 데이터는 Controller에서 받아서 표시
public class ItemView {

    public void showMenu() {
        System.out.println("\n=== Item Manager ===");
        System.out.println("1. 목록 보기");
        System.out.println("2. 아이템 추가");
        System.out.println("3. 아이템 삭제");
        System.out.println("0. 종료");
        System.out.print("선택: ");
    }

    public void showItems(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("(아이템 없음)");
            return;
        }
        items.forEach(System.out::println);
    }

    public void showItem(Item item) {
        System.out.println("추가됨: " + item);
    }

    public void showDeleteResult(boolean success, int id) {
        if (success) System.out.println("삭제됨: ID " + id);
        else         System.out.println("존재하지 않는 ID: " + id);
    }

    public void showError(String message) {
        System.out.println("[오류] " + message);
    }

    public void showGoodbye() {
        System.out.println("종료합니다.");
    }

    public void promptInput(String label) {
        System.out.print(label + ": ");
    }
}
