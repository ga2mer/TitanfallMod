package com.titanfallmod;

import com.titanfallmod.entity.Atlas;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.material.Material;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid=Titanfall.MODID, name=Titanfall.name, version=Titanfall.version)
public class Titanfall {
	
	public static final String MODID = "titanfall";
	public static final String version = "0.0.5";
	public static final String name = "Titanfall";
    @SidedProxy(clientSide = "com.titanfallmod.client.ClientProxy", serverSide = "com.titanfallmod.CommonProxy")
    public static CommonProxy proxy;

    public static int renderIDHopper;
		
	public static Block atlas;
    public static Item spawnAtlasItem;
    static int startEntityId = 300;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.registerRenderers();
        atlas = new BlockAtlas(Material.iron)
		.setBlockName("Atlas")
		.setHardness(5.0F)
		.setStepSound(Block.soundTypeMetal)
		.setCreativeTab(CreativeTabs.tabMisc)
		.setResistance(5.0F)
		.setBlockTextureName(Titanfall.MODID+":"+"atlas");
				
		atlas.setHarvestLevel("pickaxe", 3);

		GameRegistry.registerBlock(atlas, atlas.getUnlocalizedName().substring(5));
        spawnAtlasItem = new ItemSpawnAtlas().setUnlocalizedName("obsidianBoat");
        GameRegistry.registerItem(spawnAtlasItem, spawnAtlasItem.getUnlocalizedName().substring(5));
        int id = 0;
        EntityRegistry.registerModEntity(Atlas.class, "Atlas", id++, this, 80, 1, true);
        registerEntityEgg(Atlas.class, 0xffffff, 0x000010);
	}

    public void registerEntity(Class<? extends Entity> entityClass, String entityName) {
        int id = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerModEntity(entityClass, entityName, id, this, 80, 1, true);//Have to use this instead of commented out ones to make boat render
        //EntityRegistry.registerGlobalEntityID(entityClass, entityName, id);
        //EntityList.entityEggs.put(Integer.valueOf(id), new EntityEggInfo(id));
    }

    public static int getUniqueEntityId()
    {
        do
        {
            startEntityId++;
        }
        while (EntityList.getStringFromID(startEntityId) != null);

        return startEntityId;
    }

    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor)
    {
        int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
}
