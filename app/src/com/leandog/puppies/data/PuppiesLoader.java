package com.leandog.puppies.data;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.leandog.Utils;

public class PuppiesLoader {

    private static final String PUPPIES_URL = "http://puppies.herokuapp.com/puppies.json";

	public List<Puppy> load() {
		List<Puppy> puppies = new ArrayList<Puppy>();
		try {
			String content = Utils.Strings.from(new URL(PUPPIES_URL).openStream());
			puppies.addAll(Arrays.asList(new Gson().fromJson(content, Puppy[].class)));
		} catch (Exception e) {
			e.printStackTrace();
		}
        return puppies;
    }

}
