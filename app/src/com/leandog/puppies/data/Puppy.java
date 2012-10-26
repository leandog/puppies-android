package com.leandog.puppies.data;

public class Puppy {

    private class Info {
        String name;
    }
    
    private Info puppy = new Info();

    public Puppy() {
        this("");
    }

    public Puppy(String name) {
        puppy.name = name;
    }

    public String getName() {
        return puppy.name;
    }

}
