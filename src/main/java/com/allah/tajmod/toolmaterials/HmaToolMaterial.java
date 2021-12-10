package com.allah.tajmod.toolmaterials;

import com.allah.tajmod.TajMod;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class HmaToolMaterial implements ToolMaterial {
    public static final HmaToolMaterial INSTANCE = new HmaToolMaterial();

    @Override
    public int getDurability() {
        return 4000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }

    @Override
    public float getAttackDamage() {
        return 4.0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TajMod.HMA_CRYSTAL);
    }
}
