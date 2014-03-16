package com.titanfallmod;

import java.util.*;

import com.titanfallmod.tileentity.TileAtlas;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.potion.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;

public class BlockAtlas extends Block implements ITileEntityProvider {

	protected BlockAtlas(Material material) {
		super(material);
		// TODO Auto-generated constructor stub
		
	}
	
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube() {
		return false;
	}
	
	public int tickRate() {
		return 10;
	}

    @Override
    public int getRenderType()
    {
        return Titanfall.renderIDHopper;
    }
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileAtlas();
    }
	
	
	
}
