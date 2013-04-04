package com.leandog.puppies.test;

import android.app.Activity;

import com.xtremelabs.robolectric.matchers.StartedMatcher;

public class Util {
	
	public static class Matchers {
	    public static StartedMatcher started(Class<? extends Activity> activityClass, String extraKey, String extraValue) {
	        return new StartedMatcher(StartedMatcher.createIntent(activityClass, extraKey, extraValue));
	    }
	}
	

}
