package com.minegusta.bungeeteleport;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Commands extends Command
{
    public Commands()
    {
        super("tele", "bungeeteleport.teleport", "tel", "t", "teleport", "teleportation", "bungeeteleport", "bteleport", "btele");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings)
    {
        if(!(commandSender instanceof ProxiedPlayer))return;
        ProxiedPlayer p = (ProxiedPlayer) commandSender;

        if(strings == null || strings.length < 1)
        {
            p.sendMessage(ChatMessageType.CHAT, new ComponentBuilder("Use it like this: /Tele <Name>").color(ChatColor.RED).create());
            return;
        }

        try
        {
            ProxiedPlayer victim = Main.PROXY.getPlayer(strings[0]);

            p.connect(victim.getServer().getInfo());


            p.sendMessage(ChatMessageType.CHAT, new ComponentBuilder("You teleported to " + victim.getName() + ".").color(ChatColor.DARK_GREEN).create());


        }catch (Exception ignored){
            p.sendMessage(ChatMessageType.CHAT, new ComponentBuilder("Player could not be found.").color(ChatColor.RED).create());
        }


    }
}
