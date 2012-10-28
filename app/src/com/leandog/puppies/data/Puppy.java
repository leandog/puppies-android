package com.leandog.puppies.data;

public class Puppy {

    private final String name;
    
    public Puppy() {
        this("");
    }

    public Puppy(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
