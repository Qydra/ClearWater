package com.qydra.clearwater;

import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class ClearWaterEventHandler {

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onViewRenderFogDensity(EntityViewRenderEvent.FogDensity event) {
	    if (event.getEntity().isInWater()) {
	        event.setCanceled(true);
	    }
	}
	
}
