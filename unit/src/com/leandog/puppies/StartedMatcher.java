package com.leandog.puppies;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.robolectric.Robolectric;

import android.content.Intent;
import android.os.Bundle;

public class StartedMatcher extends BaseMatcher<Activity> {

    private Class<? extends Activity> expectedClass;
    private String expectedKey;
    private String expectedValue;

    public StartedMatcher(final Class<? extends Activity> expectedClass, final String expectedKey, final String expectedValue) {
        this.expectedClass = expectedClass;
        this.expectedKey = expectedKey;
        this.expectedValue =  expectedValue;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(String.format("have started %s with extra %s = %s", expectedClass.toString(), expectedKey, expectedValue));
    }

    @Override
    public void describeMismatch(Object actual, Description description) {
        final Intent startedActivity = startedActivity(actual);
        
        if( null == startedActivity )
            description.appendText("but no Activity was started");
        else if(!didStart(actual))
            description.appendText(String.format("but was %s (%s = %s)", actualClass(actual).toString(), expectedKey, actualValue(actual)));
    }

    @Override
    public boolean matches(Object actual) {
        return didStart(actual) &&
               hasExtra(actual);
    }
   
    private boolean hasExtra(Object actual) {
        return null != extras(actual) && extras(actual).get(expectedKey).equals(expectedValue);
    }

    private Bundle extras(Object actual) {
        final Bundle extras = startedActivity(actual).getExtras();
        return extras;
    }

    private boolean didStart(Object actual) {
        return actualClass(actual) == expectedClass;
    }

    private Class<?> actualClass(Object actual) {
        return Robolectric.shadowOf(startedActivity(actual)).getIntentClass();
    }

    private Intent startedActivity(Object actual) {
        return Robolectric.shadowOf((Activity) actual).peekNextStartedActivity();
    }    
    
    private String actualValue(Object actual) {
        final Bundle extras = extras(actual);
        return null != extras ? extras.getString(expectedKey) : "<was not set>";
    }
 

}
