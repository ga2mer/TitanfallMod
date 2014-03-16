package com.titanfallmod.renderer;

import com.titanfallmod.BlockAtlas;
import com.titanfallmod.Titanfall;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ItemRenderAtlas implements ISimpleBlockRenderingHandler
{

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
       // if (block instanceof BlockAtlas)
//            RenderAtlas.instance.renderTileEntityBLHAt(null, 0, 0, 0, true);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return Titanfall.renderIDHopper;
    }

}