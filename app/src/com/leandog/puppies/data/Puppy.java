package com.leandog.puppies.data;

public class Puppy {
    
    private Info puppy = new Info();

    public Puppy() {
        this("");
    }

    public Puppy(final String name) {
        puppy.name = name;
    }

    public String getName() {
        return puppy.name;
    }

    private class Info {
        String name;
    }
}
