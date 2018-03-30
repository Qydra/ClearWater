package com.qydra.clearwater;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ClearWater.MODID, name = ClearWater.NAME, version = ClearWater.VERSION)
public class ClearWater
{
    public static final String MODID = "clearwater";
    public static final String NAME = "Clear Water";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	Blocks.WATER.setLightOpacity(0);
    	Blocks.FLOWING_WATER.setLightOpacity(0);
    	//cancel fog;
    }
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onViewRenderFogDensity(EntityViewRenderEvent.FogDensity event) {
        if (event.getEntity().isInsideOfMaterial(Material.WATER)) {
            event.setCanceled(true);
        }
    }
}
