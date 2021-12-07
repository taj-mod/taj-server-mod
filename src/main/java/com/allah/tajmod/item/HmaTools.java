package com.allah.tajmod.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class HmaTools {
    public static class HmaSwordItem extends SwordItem {
        public HmaSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

            // default white text
            tooltip.add( new TranslatableText("item.tutorial.fabric_item.tooltip") );

            // formatted red text
            tooltip.add( new TranslatableText("item.tutorial.fabric_item.tooltip").formatted(Formatting.RED) );
        }

        @Override
        public Text getName(ItemStack stack){
            Random random = new Random();
            int randomInt = random.nextInt(10);
            if (randomInt == 0) {
                return new TranslatableText("item.tajmod.hma_sword").formatted(Formatting.RED);
            } else if (randomInt == 1) {
                return new TranslatableText("item.tajmod.hma_sword_cor_1").formatted(Formatting.RED);
            }
            return new TranslatableText("item.tajmod.hma_sword");
        }
    }
}
