package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

   //레거시 코드란? 더이상 수정이 힘든 코드!
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {  // i 번째 아이템이 일반 아이템이면 퀄리티 -1
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {  // 퀄리티는 50이 최대, i번째가 예외 아이템(Aged Brie, Backstage pass, Sulfuras)이면 퀄 +1
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {  // 유통기한이 10일 이하일때 +2
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {// 유통기한이 10일 이하일때 +3
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { //Sulfuras는 날이 지나도 퀄리티가 변하지 않음
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {  // 유통기한이 지나면
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { //i번째가 Sulfuras면서 퀄리티가 0 이상일때
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1; // Sulfuras는 퀄리티가 변하면 안됨 위에서 1을 더해줘서 다시 -1
                            }
                        }
                    } else { //Backstage pass가 유통기한이 지나면 0
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else { // i 번째가 Aged Brie 면서 유통기한이 지났을때+2
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}