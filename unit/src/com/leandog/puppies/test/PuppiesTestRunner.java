package com.leandog.puppies.test;

import static com.xtremelabs.robolectric.Robolectric.bindShadowClass;

import java.io.File;
import java.lang.reflect.Method;

import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;

import com.leandog.puppies.shadows.ShadowActionBarActivity;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class PuppiesTestRunner extends RobolectricTestRunner {

    public PuppiesTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass, new File("../app"));
    }

    @Override
    public void beforeTest(Method method) {
        bindShadowClass(ShadowActionBarActivity.class);
    }

    @Override
    public Object createTest() throws Exception {
        final Object theTest = super.createTest();
        MockitoAnnotations.initMocks(theTest);
        return theTest;
    }

}
