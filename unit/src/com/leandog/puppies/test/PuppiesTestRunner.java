package com.leandog.puppies.test;

import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

public class PuppiesTestRunner extends RobolectricTestRunner {

    public PuppiesTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }
    
    @Override
    public Object createTest() throws Exception {
        final Object theTest = super.createTest();
        MockitoAnnotations.initMocks(theTest);
        return theTest;
    }

}
