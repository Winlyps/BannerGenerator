package winlyps.bannerGenerator

import org.bukkit.DyeColor
import org.bukkit.Material
import org.bukkit.block.banner.Pattern
import org.bukkit.block.banner.PatternType
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BannerMeta
import kotlin.random.Random

object BannerUtils {

    private val colors = DyeColor.values().toList()
    private val patterns = PatternType.values().toList()

    fun generateBanners(count: Int): List<ItemStack> {
        return (1..count).map { generateRandomBanner() }
    }

    private fun generateRandomBanner(): ItemStack {
        val banner = ItemStack(Material.WHITE_BANNER)
        val meta = banner.itemMeta as BannerMeta

        val patternCount = Random.nextInt(1, 5) // Generate 1 to 4 patterns
        repeat(patternCount) {
            val color = colors.random()
            val pattern = patterns.random()
            meta.addPattern(Pattern(color, pattern))
        }

        banner.itemMeta = meta
        return banner
    }
}