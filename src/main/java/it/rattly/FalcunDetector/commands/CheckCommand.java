package it.rattly.FalcunDetector.commands;

import it.rattly.FalcunDetector.FalcunDetector;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if(args.length < 1) {
            p.sendMessage(ChatColor.RED + "Use: /checkfalcun <player>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if(target == null) {
            p.sendMessage(ChatColor.RED + "Player not found.");
        }

        if (target != null) {
            p.sendMessage(ChatColor.DARK_AQUA + "Player " + ChatColor.BOLD + target.getName() + ChatColor.RESET.toString() + ChatColor.DARK_AQUA + " is using Falcun Client: " + (FalcunDetector.getProfileManager().getProfile(target.getUniqueId()).isFalcun() ? "Yes" : "No"));
        }
        return false;
    }
}
