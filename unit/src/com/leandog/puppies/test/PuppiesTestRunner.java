package com.leandog.puppies.test;

import java.io.File;
import java.lang.reflect.Method;

import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.leandog.puppies.shadows.ShadowActionBarActivity;

@Config(manifest = "../app/AndroidManifest.xml")
public class PuppiesTestRunner extends RobolectricTestRunner {

    public PuppiesTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }
    
    

//    @Override
//    public void beforeTest(Method method) {
//        bindShadowClass(ShadowActionBarActivity.class);
//    }

    @Override
    public Object createTest() throws Exception {
        final Object theTest = super.createTest();
        MockitoAnnotations.initMocks(theTest);
        return theTest;
    }

}
