package winlyps.bannerGenerator

import org.bukkit.plugin.java.JavaPlugin

class BannerGenerator : JavaPlugin() {

    override fun onEnable() {
        // Register the command executor
        getCommand("bannergn")?.setExecutor(BannerCommandExecutor(this))

        // Register the event listener
        server.pluginManager.registerEvents(BannerGeneratorListener(this), this)

        logger.info("BannerGenerator plugin enabled!")
    }

    override fun onDisable() {
        logger.info("BannerGenerator plugin disabled!")
    }
}