package com.example.gideonsassoon.avariel;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
//    @Test
//    public void useAppContext() throws Exception {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.example.gideonsassoon.avariel", appContext.getPackageName());
//    }
//

    @Test
    public void tabTest() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertTrue(appContext.getClass().getName().equals("SkillsSheetFragment"));
    }
}
