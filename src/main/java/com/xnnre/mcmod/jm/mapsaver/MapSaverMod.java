package com.xnnre.mcmod.jm.mapsaver;

import example.mod.ExampleMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author guoq
 * @date 2023/3/20
 */
@Mod(MapSaverMod.MODID)
@Mod.EventBusSubscriber(modid = ExampleMod.MODID)
public class MapSaverMod {

    public static final String MODID = "jmmapextra";
    public static final String VERSION = "1.9";
    public static final Logger LOGGER = LogManager.getFormatterLogger(MODID);

    public MapSaverMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }





}
