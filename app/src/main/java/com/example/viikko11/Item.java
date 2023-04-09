package com.example.viikko11;

import java.util.Date;
import java.util.UUID;

public class Item implements Comparable<Item>{
    private String Item;
    private String Info;
    private String ID;

    private Date dateAdded;

    public Item (String Item, String Info) {
        this.Item = Item;
        this.Info = Info;
        this.ID = UUID.randomUUID().toString();
        this.dateAdded = new Date();
    }

    public String getItem() {return Item;}

    public String getInfo() {return Info;}

    public String getID() {return ID;}

    public void setItem(String Item) {this.Item = Item;}

    public void setInfo(String Info) {this.Info = Info;}

    public Date getDateAdded(){return dateAdded;}

    @Override
    public int compareTo(Item otherItem) {
        return this.dateAdded.compareTo(otherItem.getDateAdded());
    }
}
