package com.neo.repository;

import com.neo.model.Item;
import com.neo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findItemByItemName(String itemName);
}