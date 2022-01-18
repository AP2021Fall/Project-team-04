package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Category {
    public static Set<String> categories = new HashSet<>();
    private String mod;
    public Category(String mod){
        this.mod = mod;
        categories.add(mod);
    }

    public void setMod(String mod) {
        this.mod = mod;
    }

    public String getMod() {
        return mod;
    }

}
