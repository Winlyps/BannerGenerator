package winlyps.bannerGenerator

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class BannerCommandExecutor(private val plugin: BannerGenerator) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("This command can only be executed by a player.")
            return true
        }

        if (args.size != 1) {
            sender.sendMessage("Usage: /bannergn <NumberOfGeneratedBannersMax36>")
            return true
        }

        val numberOfBanners = args[0].toIntOrNull() ?: 0
        if (numberOfBanners <= 0 || numberOfBanners > 36) {
            sender.sendMessage("Number of banners must be between 1 and 36.")
            return true
        }

        val banners = BannerUtils.generateBanners(numberOfBanners)
        banners.forEach { sender.inventory.addItem(it) }

        sender.sendMessage("Generated $numberOfBanners banners!")
        return true
    }
}