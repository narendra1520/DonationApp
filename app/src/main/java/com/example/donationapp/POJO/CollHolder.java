package com.example.donationapp.POJO;

public class CollHolder {
    private static final CollHolder collHolder = new CollHolder();
    private Coll col = null;

    public static CollHolder getInstance() {
        return collHolder;
    }

    public Coll getNgo() {
        return col;
    }

    public void setNgo(Coll ngo) {
        this.col = ngo;
    }
}
