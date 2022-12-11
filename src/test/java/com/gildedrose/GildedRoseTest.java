package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void quality_downTest(){ //일반 아이템일때 하루 지날때마다 1씩 줄어드는지 test
        Item[] items = new Item[]{new Item("normalknife",5,3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].quality);
    }

    @Test
    public void overSellin_twiceQualityDownTest(){ //일반 아이템일때 유통기한이 지난 아이템의 퀄리티가 2배로 떨어지는지 test
        Item[] items = new Item[]{new Item("nomalShoese",-2,4)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2,app.items[0].quality);
    }

    @Test
    public void qualityMaxTest(){//퀄리티의 최대가 50인지 test
        Item[] items = new Item[]{new Item("Aged Brie",5,50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }
    @Test
    public void AgedBrieTest(){//Aged Brie의 대한 test
        Item[] items = new Item[]{new Item("Aged Brie",5,42),new Item("Aged Brie",-2,30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43,app.items[0].quality);
        assertEquals(32,app.items[1].quality);
    }
    @Test
    public void BackstagePassTest(){//Backstage passes to a TAFKAL80ETC concert의 대한 test
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",13,10),
                new Item("Backstage passes to a TAFKAL80ETC concert",8,10),
                new Item("Backstage passes to a TAFKAL80ETC concert",3,10),
                new Item("Backstage passes to a TAFKAL80ETC concert",-1,10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11,app.items[0].quality);
        assertEquals(12,app.items[1].quality);
        assertEquals(13,app.items[2].quality);
        assertEquals(0,app.items[3].quality);
    }
    @Test
    public void SulfurasHandOfRagnarosTest(){//Sulfuras, Hand of Ragnaros의 대한 test
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros",5,34),
                new Item("Sulfuras, Hand of Ragnaros",-3,34)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(34,app.items[0].quality);
        assertEquals(34,app.items[1].quality);
    }

}
