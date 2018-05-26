package android.mobile.micmen.mvvmsample;

import android.mobile.micmen.mvvmsample.core.TestApplication;
import android.support.test.runner.AndroidJUnit4;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Test
    public void testRepositoryReference() {
        Assert.assertNotNull(TestApplication.getInstance().getRepositoryFactory());
    }

}
