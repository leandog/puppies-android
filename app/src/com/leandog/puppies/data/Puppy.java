package com.leandog.puppies.data;

public class Puppy {

    private String name;

    public Puppy() {
        this("");
    }

    public Puppy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
