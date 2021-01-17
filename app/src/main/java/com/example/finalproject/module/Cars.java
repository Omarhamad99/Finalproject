package com.example.finalproject.module;

public class Cars {
    private int id ;
    private String name;
    private String Descreption;
    private String img;

    public Cars(int id, String name, String descreption, String img) {
        this.id = id;
        this.name = name;
        Descreption = descreption;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescreption() {
        return Descreption;
    }

    public void setDescreption(String descreption) {
        Descreption = descreption;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Descreption='" + Descreption + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}