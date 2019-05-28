import org.junit.Assert.assertEquals
import org.junit.Test

class GildedRoseTest {

    @Test
    fun update_item() {
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
    fun update_item_with_zero_Quality() {
        //given
        val items = arrayOf(Item("+5 Dexterity Vest", -1, 0))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun update_item_with_zero_SellIn() {
        //given
        val items = arrayOf(Item("+5 Dexterity Vest", 0, 10))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun update_AgedBrie_item() {
        //given
        val items = arrayOf(Item("Aged Brie", 5, 10))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(4, app.items[0].sellIn)
        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun update_AgedBrie_item_with_50_Quality() {
        //given
        val items = arrayOf(Item("Aged Brie", 5, 50))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(4, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun update_Sulfuras_item() {
        //given
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 5, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(5, app.items[0].sellIn)
        assertEquals(40, app.items[0].quality)
    }

    @Test
    fun update_Backstage_item() {
        //given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 20, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(19, app.items[0].sellIn)
        assertEquals(41, app.items[0].quality)
    }

    @Test
    fun update_Backstage_item_with_SellIn_equal_or_less_than_10() {
        //given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(9, app.items[0].sellIn)
        assertEquals(42, app.items[0].quality)
    }

    @Test
    fun update_Backstage_item_with_SellIn_equal_or_less_than_5() {
        //given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(4, app.items[0].sellIn)
        assertEquals(43, app.items[0].quality)
    }

    @Test
    fun update_Backstage_item_with_SellIn_less_than_0() {
        //given
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun update_Conjured_item_with_SellIn_less_than_0() {
        //given
        val items = arrayOf(Item("Conjured", 0, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(36, app.items[0].quality)
    }


    @Test
    fun update_Conjured_item_with_SellIn_more_than_0() {
        //given
        val items = arrayOf(Item("Conjured", 5, 40))
        val app = GildedRose(items)
        //when
        app.updateQuality()
        //then
        assertEquals(4, app.items[0].sellIn)
        assertEquals(38, app.items[0].quality)
    }

}
