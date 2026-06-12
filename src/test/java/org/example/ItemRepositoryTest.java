package org.example;

import org.example.model.Item;
import org.example.model.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    private ItemRepository repo;

    @BeforeEach
    void setUp() {
        repo = new ItemRepository();
    }

    @Test
    void add_항목이_저장되고_ID가_순차적으로_증가한다() {
        Item a = repo.add("Apple");
        Item b = repo.add("Banana");

        assertEquals(1, a.getId());
        assertEquals(2, b.getId());
        assertEquals(2, repo.findAll().size());
    }

    @Test
    void findById_존재하는_ID는_반환된다() {
        repo.add("Cherry");
        Optional<Item> found = repo.findById(1);
        assertTrue(found.isPresent());
        assertEquals("Cherry", found.get().getName());
    }

    @Test
    void findById_없는_ID는_empty를_반환한다() {
        assertTrue(repo.findById(99).isEmpty());
    }

    @Test
    void deleteById_삭제_후_목록에서_제거된다() {
        repo.add("Durian");
        boolean result = repo.deleteById(1);
        assertTrue(result);
        assertTrue(repo.findAll().isEmpty());
    }

    @Test
    void deleteById_없는_ID는_false를_반환한다() {
        assertFalse(repo.deleteById(999));
    }
}
