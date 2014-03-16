package com.titanfallmod.renderer;

import com.titanfallmod.entity.Atlas;
import com.titanfallmod.model.ModelAtlas;
import net.minecraft.entity.passive.EntityHorse;
import org.lwjgl.opengl.GL11;
import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderAtlas extends Render
{
    private ModelAtlas head;
    private static final ResourceLocation Texture = new ResourceLocation("/modjam13/textures/items/1911.png");

    public RenderAtlas ()
    {
        head = new ModelAtlas();

    }
    public void renderHead(Atlas entity, double x, double y, double z, float par8, float par9)
    {
        GL11.glPushMatrix();
        final float var24 = (entity.rotationPitch - entity.prevRotationPitch) * par9;
        GL11.glTranslated(x, y, z);
        GL11.glScalef(0.015f, 0.015f, 0.015f);
        GL11.glRotatef(270 - par8, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-var24, 0.0F, 0.0F, 1.0F);
        head.render();
        GL11.glPopMatrix();

    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderHead((Atlas)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity var1) {
        return null;
    }
}