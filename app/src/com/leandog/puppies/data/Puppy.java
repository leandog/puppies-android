package com.leandog.puppies.data;

public class Puppy {
    
    private Info puppy = new Info();

    public Puppy() {
        this("");
    }

    public Puppy(final String name) {
        puppy.name = name;
    }

    public Puppy(final String name, final String breed) {
        this(name);
        puppy.breed = breed;
    }

    public String getName() {
        return puppy.name;
    }

    public String getBreed() {
        return puppy.breed;
    }

    private class Info {
        public String breed;
        String name;
    }
}
