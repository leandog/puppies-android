package com.leandog.puppies.shadows;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.shadows.ShadowActivity;

import android.app.ActionBar;
import android.app.Activity;


@Implements(Activity.class)
public class ShadowActionBarActivity extends ShadowActivity {
    
    private ActionBarStub actionBar;
    
    @Implementation
    public ActionBar getActionBar() {
        if( actionBar == null ) {
            actionBar = new ActionBarStub();
        }
        
        return actionBar;
    }
    
}
