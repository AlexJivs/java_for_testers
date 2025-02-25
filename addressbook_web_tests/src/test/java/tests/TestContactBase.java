package tests;

import ContactManager.ContactAppManager;
 import org.junit.jupiter.api.BeforeEach;

import java.util.Random;

public class TestContactBase {

    protected static ContactAppManager cntapp;

     @BeforeEach
    public void setUp() {
        if (cntapp == null) {
            cntapp = new ContactAppManager();
            cntapp.initCnt();
        }
    }
    public static String randomStr(int n) {
         var rnd = new Random();
         var result = "";
         for (int i = 0; i < n; i++) {
             result = result + (char)('a' + rnd.nextInt(26));
         }
        return result;
    }
 }
