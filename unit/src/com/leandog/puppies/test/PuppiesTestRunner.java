package com.leandog.puppies.test;

import org.junit.runners.model.InitializationError;
import org.mockito.MockitoAnnotations;
import org.robolectric.DefaultTestLifecycle;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.TestLifecycle;

public class PuppiesTestRunner extends RobolectricTestRunner {

    public PuppiesTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Class<? extends TestLifecycle> getTestLifecycleClass() {
        return MockitoTestLifecycle.class;
    }

    public static class MockitoTestLifecycle extends DefaultTestLifecycle {
        @Override
        public void prepareTest(Object test) {
            MockitoAnnotations.initMocks(test);
        }
    }
}