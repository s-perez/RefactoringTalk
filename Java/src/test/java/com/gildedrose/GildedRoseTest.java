package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static Stream<Arguments> gildedRoseTestSource() {
        return Stream.of(
            Arguments.of("Arbitrary item", 2, 6, 1, 5),
            Arguments.of("Arbitrary item", 0, 6, -1, 4),
            Arguments.of("Aged Brie", 2, 0, 1, 1),
            Arguments.of("Aged Brie", 0, 1, -1, 3),
            Arguments.of("Aged Brie", 0, 50, -1, 50),
            Arguments.of("Sulfuras, Hand of Ragnaros", 0, 80, 0, 80),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 10, 5, 9, 7),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 5, 5, 4, 8),
            Arguments.of("Backstage passes to a TAFKAL80ETC concert", 0, 5, -1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("gildedRoseTestSource")
    void ItemsUpdateTheirValuesProperly(String name, int startingSellin, int startingQuality, int endSellin, int endQuality) {
        Item item = new Item(name, startingSellin, startingQuality);
        GildedRose app = new GildedRose(new Item[] { item });
        app.updateQuality();
        assertEquals(endQuality, item.quality);
        assertEquals(endSellin, item.sellIn);
    }
}
