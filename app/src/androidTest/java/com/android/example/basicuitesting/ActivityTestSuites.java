package com.android.example.basicuitesting;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {MainActivityTest.class,
        SecondActivityTest.class}
)
public class ActivityTestSuites {
}
