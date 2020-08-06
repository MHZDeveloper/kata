import org.junit.Assert.assertEquals
import org.junit.Test

class GildedRoseTest {

    @Test
    fun should_decrement_sellin_and_quality_for_any_item() {
        //given
        val items = arrayOf(Item("+5 Dexterity Vest", 10, 20))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(9, app.items[0].sellIn)
        assertEquals(19, app.items[0].quality)
    }

    @Test
    fun should_not_decrement_quality_when_equal_to_zero_for_any_item() {
        //given
        val items = arrayOf(Item("Aged Brie", -5, 0),
                Item("+5 Dexterity Vest", -5, 0),
                Item("Sulfuras, Hand of Ragnaros", -5, 0),
                Item("Backstage passes to a TAFKAL80ETC concert", -20, 0),
                Item("Conjured", -5, 0))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(0, app.items[0].quality)
        assertEquals(0, app.items[1].quality)
        assertEquals(0, app.items[2].quality)
        assertEquals(0, app.items[3].quality)
        assertEquals(0, app.items[4].quality)
    }

    @Test
    fun should_not_increment_quality_when_equal_to_50_for_any_item() {
        //given
        val items = arrayOf(Item("Aged Brie", 5, 50),
                Item("Sulfuras, Hand of Ragnaros", 5, 50),
                Item("Backstage passes to a TAFKAL80ETC concert", 20, 50))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(50, app.items[0].quality)
        assertEquals(50, app.items[1].quality)
        assertEquals(50, app.items[2].quality)
    }

    @Test
    fun should_decrement_twice_quality_when_sellin_negative() {
        //given
        val items = arrayOf(Item("Aged Brie", 0, 10),
                Item("+5 Dexterity Vest", 0, 10),
                Item("Sulfuras, Hand of Ragnaros", 0, 10),
                Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
                Item("Conjured", 0, 10))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(8, app.items[0].quality)
        assertEquals(8, app.items[1].quality)
        assertEquals(10, app.items[2].quality)
        assertEquals(0, app.items[3].quality)
        assertEquals(6, app.items[4].quality)
    }

    @Test
    fun should_increment_quality_for_aged_brie_item_when_sellin_positive() {
        //given
        val items = arrayOf(Item("Aged Brie", 5, 10))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun should_not_update_sulfuras_item() {
        //given
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 5, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(40, app.items[0].quality)
    }

    @Test
    fun should_increment_quality_by_1_for_backstage_item_when_sellin_more_than_10_days() {
        //given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(41, app.items[0].quality)
    }

    @Test
    fun should_increment_quality_by_2_for_backstage_item_when_sellin_less_than_10_days() {
        //given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(42, app.items[0].quality)
    }

    @Test
    fun should_increment_quality_by_3_for_backstage_item_when_sellin_less_than_5_days() {
        //given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(43, app.items[0].quality)
    }

    @Test
    fun should_change_quality_to_0_for_backstage_item_when_sellin_negative() {
        //given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun should_decrement_quality_by_4_for_conjured_item_when_sellin_negative() {
        //given
        val items = arrayOf(Item("Conjured", 0, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(36, app.items[0].quality)
    }


    @Test
    fun should_decrement_quality_by_2_for_conjured_item_when_sellin_positive() {
        //given
        val items = arrayOf(Item("Conjured", 5, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(38, app.items[0].quality)
    }

}
