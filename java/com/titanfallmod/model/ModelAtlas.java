package com.titanfallmod.model;

import com.titanfallmod.entity.Atlas;
import com.titanfallmod.tileentity.TileAtlas;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.jglrxavpok.glutils.TessellatorModel;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelAtlas extends ModelBase
{
    private TessellatorModel model1911;

    public ModelAtlas()
    {
        model1911 = new TessellatorModel("/assets/titanfall/models/atlas.obj");
    }

    public void render()
    {
        model1911.render();
    }


    public void render(Atlas box, double x, double y, double z)
    {
        GL11.glPushMatrix();

        GL11.glTranslatef((float) x + 0.5f, (float) y + 0.5f, (float) z + 0.5f);

        GL11.glScalef(0.01f, 0.01f, 0.01f);
        //FMLClientHandler.instance().getClient().renderEngine.func_110577_a(textur);

        this.render();

        GL11.glPopMatrix();
    }
}