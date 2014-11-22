package com.minegusta.bungeeteleport;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin
{
    public static ProxyServer PROXY;
    @Override
    public void onEnable()
    {
        //Set the proxy.
        PROXY = getProxy();

        //Commands
        PROXY.getPluginManager().registerCommand(this, new Commands());
    }
}
