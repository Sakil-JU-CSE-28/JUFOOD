package com.example.jufood;

import java.io.Serializable;
import java.io.StringReader;

public class item implements Serializable {

    String name;
    int image;

    public item(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
