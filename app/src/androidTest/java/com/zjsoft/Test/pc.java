package com.zjsoft.Test;


import android.app.Instrumentation;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

@RunWith(JUnit4.class)
public class pc {
    public Instrumentation instrumentation;
    public UiDevice uiDevice;

    @Before
    public void setUp(){
        instrumentation = InstrumentationRegistry.getInstrumentation();
        uiDevice = UiDevice.getInstance(instrumentation);
    }
    @Test
    public void Test() throws RemoteException, InterruptedException,UiObjectNotFoundException {
        String[] lang = {};
        String[] lang1 = {"English","Français","Italiano","Deutsch","Español","한국어","日本語","ภาษาไทย","繁體中文","简体中文","العربية"
        ,"Русский","Indonesia","Türkçe","Português (Brasil)","Português (Portugal)","Ελληνικά","Српски","Български","Український","فارسی"
        ,"Nederlands","Polski","Slovenský","Dansk","Magyar","Română","Melayu","Shqiptar","Việt","Македонски","Hrvatski","हिंदी","עברית"
        ,"اردو","Svenska","Čeština","Norsk","Suomi"};

        uiDevice.pressHome();
        Thread.sleep(1000);
        uiDevice.findObject(By.desc("My Calendar")).click();
        Thread.sleep(3000);
        uiDevice.takeScreenshot(new File("/data/data/com.zjsoft.Test/" + 0 + "_homepage.jpg"));
        Thread.sleep(300);

        for(int i=1;i<39;i++){
            uiDevice.findObject(By.res("com.popularapp.periodcalendar:id/bt_go_setting_layout")).click();
            Thread.sleep(500);
            uiDevice.swipe(190,1700,190,300,100);
            uiDevice.findObject(By.text(lang1[i-1])).click();
            Thread.sleep(300);
            uiDevice.findObject(By.text(lang1[i])).click();
            Thread.sleep(1000);
            uiDevice.takeScreenshot(new File("/data/data/com.zjsoft.Test/" + i + "_homepage.jpg"));
            Thread.sleep(300);

        }



    }
}
