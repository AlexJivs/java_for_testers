package tests;

import ContactManager.ContactAppManager;
 import org.junit.jupiter.api.BeforeEach;

public class TestContactBase {

    protected static ContactAppManager cntapp;

     @BeforeEach
    public void setUp() {
        if (cntapp == null) {
            cntapp = new ContactAppManager();
            cntapp.initCnt();
        }
    }
}
