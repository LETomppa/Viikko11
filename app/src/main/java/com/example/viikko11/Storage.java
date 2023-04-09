package com.example.viikko11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Storage {
    ArrayList<Item> items = new ArrayList<>();
    ArrayList<Item> backupItems = new ArrayList<>();
    private static Storage storage = null;

    private Storage() {}

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addItem(Item item) {
        backupItems.add(item);
        items.add(item);
    }

    public ArrayList<Item> getItems() {return items;}

    public Item getItemByID(int id) {return items.get(id);}

    public void removeItem(String id) {
        Item itemToRemove = null;
        for (Item item : items) {
            if (item.getID().equals(id)) {
                itemToRemove = item;
                break;
            }
        }
        items.remove(itemToRemove);
        backupItems.remove(itemToRemove);
    }


    public void sortByDateAdded() {
        if (!backupItems.isEmpty()) {
            items.clear();
            items.addAll(backupItems);
        }
    }

    public void sortByAlphabeticalOrder() {
        if (backupItems.isEmpty()){
            backupItems.addAll(items);
        }
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getItem().compareToIgnoreCase(item2.getItem());
            }
        });
    }
}
