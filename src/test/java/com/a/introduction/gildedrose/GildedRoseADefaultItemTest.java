package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {

    public static final String DEFAULT_ITEM_NAME = "DEFAULT_ITEM";
    public static final int DEFAULT_SELLIN = 15;
    public static final int DEFAULT_QUALITY = 3;
    public static final int EXPIRED_SELLIN = -1;

    @Test
    public void for_unexpiredDefaultItem_qualityAndSellInDecreasesBy1() {
        final GildedRose app = createGildedRoseWithAnItem(DEFAULT_ITEM_NAME, DEFAULT_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(DEFAULT_ITEM_NAME, DEFAULT_SELLIN - 1, DEFAULT_QUALITY - 1);
        assertItem(expected, app.items[0]);
    }

    @Test
    public void for_unexpiredDefaultItem_onExpiration_qualityDecreasesBy2_and_sellInDecreasesBy1() {
        GildedRose app = createGildedRoseWithAnItem(DEFAULT_ITEM_NAME, EXPIRED_SELLIN, DEFAULT_QUALITY);
        app.updateQuality();
        final Item expected = new Item(DEFAULT_ITEM_NAME, EXPIRED_SELLIN - 1, DEFAULT_QUALITY - 2);
        assertItem(expected, app.items[0]);
    }

    private void assertItem(
            final Item expected,
            final Item actual
    ) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }

    private GildedRose createGildedRoseWithAnItem(
            final String name,
            final int sellIn,
            final int quality
    ) {
        final Item item = new Item(name, sellIn, quality);
        final Item[] items = new Item[]{item};
        final GildedRose app = new GildedRose(items);
        return app;
    }
}