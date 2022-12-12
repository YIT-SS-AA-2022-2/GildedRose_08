package com.gildedrose;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

import org.approvaltests.Approvals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class GildedRoseApprovalTest {

    @Test
    public void foo() {

        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();


        Approvals.verifyAll("foo", items);
    }

    @Test
    public void GlidedApprovalTest() {

        ByteArrayOutputStream fakeoutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeoutput));
        System.setIn(new ByteArrayInputStream("a\n".getBytes()));

        Program.main();
        String output = fakeoutput.toString();
        Approvals.verify(output);

    }
}