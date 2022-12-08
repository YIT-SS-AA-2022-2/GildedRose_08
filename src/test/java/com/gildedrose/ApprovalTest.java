package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

public class ApprovalTest {
    @Test
    public void approvalTest(){
        Approvals approvals = new Approvals();


        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i< items.length;i++){
            stringBuilder.append(items[i]).append("\n");
        }
        approvals.verify(stringBuilder.toString());
    }
}
