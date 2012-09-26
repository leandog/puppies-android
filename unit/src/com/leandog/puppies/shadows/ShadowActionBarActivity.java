package com.leandog.puppies.shadows;

import android.app.ActionBar;
import android.app.Activity;

import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.shadows.ShadowActivity;

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
