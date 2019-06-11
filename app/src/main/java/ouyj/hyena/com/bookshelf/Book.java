package ouyj.hyena.com.bookshelf;

public class Book {
    private int id;
    private String name;
    private int pictureId;
    private String codePath;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.pictureId = 0;
        this.codePath="";
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

    public int getPicture() { return pictureId; }
    public void setPicture(int picture) { this.pictureId = picture; }
    public String getCodePath() { return codePath; }
    public void setCodePath(String codePath) { this.codePath = codePath; }
}
