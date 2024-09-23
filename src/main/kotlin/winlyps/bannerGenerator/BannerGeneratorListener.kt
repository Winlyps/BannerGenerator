package winlyps.bannerGenerator

import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerJoinEvent

class BannerGeneratorListener(private val plugin: BannerGenerator) : Listener {

    // Example event handler (optional)
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        // Handle player join event if needed
    }
}