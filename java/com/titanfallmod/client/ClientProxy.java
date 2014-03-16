package com.titanfallmod.client;

import com.titanfallmod.CommonProxy;
import com.titanfallmod.Titanfall;
import com.titanfallmod.entity.Atlas;
import com.titanfallmod.renderer.ItemRenderAtlas;
import com.titanfallmod.renderer.RenderAtlas;
import com.titanfallmod.tileentity.TileAtlas;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(Atlas.class, new RenderAtlas());
	}
	
}
