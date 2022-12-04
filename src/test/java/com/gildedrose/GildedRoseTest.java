package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {
    // 퀄리티 테스트용 메서드
    private static void QualityTest(Item[] items, GildedRose app) {
        System.out.println("name, sellIn, quality");
        int days = 7;
        for (int i = 1; i < days; i++) {

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

    @Test
    public void ItemUpdateQualityTest(){
        Item[] items = new Item[] {
                new Item("NormalItem", 5, 5),
                new Item("Aged Brie", 5, 5),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 30),
                                    };
        GildedRose app = new GildedRose(items);
        QualityTest(items, app);
    }



}
