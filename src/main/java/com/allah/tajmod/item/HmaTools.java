package com.allah.tajmod.item;

import com.allah.tajmod.entity.HmaEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class HmaTools {
    public static class HmaSwordItem extends SwordItem {
        private Random random = new Random();

        public HmaSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }

        @Override
        public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
            int randomInt = random.nextInt(20);

            // formatted red text
            if (randomInt == 0) {
                tooltip.add(new TranslatableText("item.tajmod.hma_sword.tooltip").formatted(Formatting.RED));
            }
            else {
                tooltip.add(new TranslatableText("item.tajmod.hma_sword.tooltip").formatted(Formatting.byColorIndex(0)));
            }
        }

        @Override
        public Text getName(ItemStack stack) {
            int randomInt = random.nextInt(10);
            if (randomInt == 0) {
                return new TranslatableText("item.tajmod.hma_sword").formatted(Formatting.RED);
            } else if (randomInt == 1) {
                return new TranslatableText("item.tajmod.hma_sword_cor_1").formatted(Formatting.RED);
            }
            return new TranslatableText("item.tajmod.hma_sword");
        }

        @Override
        public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
            System.out.println("H1");
            System.out.println(target.getClass().toString());
            if (target instanceof HmaEntity) {
                System.out.println("H2");
                target.damage(DamageSource.GENERIC, 12);
            }
            return true;
        }
    }
    public static class HmaPickaxeItem extends PickaxeItem {
        public HmaPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class HmaHoeItem extends HoeItem {
        public HmaHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }

    public static class HmaAxeItem extends AxeItem {
        public HmaAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
            super(material, attackDamage, attackSpeed, settings);
        }
    }
}
