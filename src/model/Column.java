package model;

import java.util.ArrayList;

public class Column {
    private int columnNumber;
    private ArrayList<Category> categories = new ArrayList<>();
    public Column(int columnNumber){
        this.columnNumber = columnNumber;
    }
    public void addToCategories(Category category){
        categories.add(category);
    }
}
