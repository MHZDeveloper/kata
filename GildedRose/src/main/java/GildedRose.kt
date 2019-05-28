class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (!items[i].name.contains("Sulfuras")) {
                items[i].sellIn--
                if (items[i].name.contains("Aged Brie")) {
                    if (items[i].quality in 0..49)
                        items[i].quality++
                } else if (items[i].name.contains("Backstage")) {
                    if (items[i].sellIn >= 0) {
                        if (items[i].sellIn in 0..5)
                            items[i].quality += 3
                        else if (items[i].sellIn in 0..10)
                            items[i].quality += 2
                        else
                            items[i].quality++
                    } else {
                        items[i].quality = 0
                    }
                } else {
                    var degradation = 1
                    if (items[i].name.contains("Conjured"))
                        degradation++
                    if (items[i].quality > 0) {
                        if (items[i].sellIn > 0)
                            items[i].quality-= degradation
                        else
                            items[i].quality -= 2*degradation
                    }
                }
            }
        }
    }

}