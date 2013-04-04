package com.leandog;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class Utils {
	
	public static final class Strings {
		
		public static final String from(InputStream stream) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder content = new StringBuilder();
            try {
            	for(String line = reader.readLine(); line != null; line = reader.readLine()) {
            		content.append(line);
            	}
            }catch (Exception e) {
            	e.printStackTrace();
            }
			return content.toString();
		}
	}

}
