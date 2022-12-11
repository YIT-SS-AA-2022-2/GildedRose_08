package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    private static void QualityTest(Item[] items, GildedRose app) {
        System.out.println("name, sellIn, quality");
        int days = 6;
        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();

        }
    }
    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        //assertEquals 는 두 객체의 값이 같은지 확인 fixme -> foo 로 수정
    }

    @Test // 유닛 테스트
    public void ItemUpdateQualityTest(){
        Item[] items = new Item[] {

                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);
        QualityTest(items, app);
    }



}
