class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (!items[i].name.contains("Sulfuras")) {
                items[i].sellIn--
                items[i].quality--
                if (items[i].sellIn >= 0) {
                    when {
                        items[i].name.contains("Aged Brie") -> items[i].quality += 2
                        items[i].name.contains("Backstage") -> {
                            when (items[i].sellIn) {
                                in 0..5 -> items[i].quality += 4
                                in 0..10 -> items[i].quality += 3
                                else -> items[i].quality += 2
                            }
                        }
                        items[i].name.contains("Conjured") -> items[i].quality--
                    }
                } else {
                    items[i].quality--
                    when {
                        items[i].name.contains("Conjured") -> items[i].quality -= 2
                        items[i].name.contains("Backstage") -> items[i].quality = 0
                    }
                }
                when {
                    items[i].quality < 0 -> items[i].quality = 0
                    items[i].quality > 50 -> items[i].quality = 50
                }
            }
        }
    }
}

