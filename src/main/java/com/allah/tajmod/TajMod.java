package com.allah.tajmod;

import com.allah.tajmod.enchantment.BaneOfHmas;
import com.allah.tajmod.entity.HmaEntity;
import com.allah.tajmod.item.HmaTools;
import com.allah.tajmod.toolmaterials.HmaToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.GameRules;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import static com.allah.tajmod.biome.HmaHighwayBiome.createHmaHighway;

public class TajMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("tajmod");

	// ITEMS
	public static final Item HMA_SHARD = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item HMA_CRYSTAL = new Item(new FabricItemSettings().group(ItemGroup.MISC));

	public static ToolItem HMA_SHOVEL = new ShovelItem(HmaToolMaterial.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem HMA_SWORD = new HmaTools.HmaSwordItem(HmaToolMaterial.INSTANCE, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT));
	public static ToolItem HMA_PICKAXE = new HmaTools.HmaPickaxeItem(HmaToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem HMA_AXE = new HmaTools.HmaAxeItem(HmaToolMaterial.INSTANCE, 7, -3.2F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem HMA_HOE = new HmaTools.HmaHoeItem(HmaToolMaterial.INSTANCE, 7, -3.2F, new Item.Settings().group(ItemGroup.TOOLS));

	public static final EntityType<HmaEntity> HMA = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("tajmod", "hma"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, HmaEntity::new).dimensions(EntityDimensions.fixed(0.925f, 3.8125f)).trackRangeBlocks(8).fireImmune().build()
	);

	public static final EntityGroup HMAS = new EntityGroup();

	public static Enchantment BANE_OF_HMAS = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("tajmod", "bane_of_hmas"),
			new BaneOfHmas()
	);

	private static final Biome HMA_HIGHWAY = createHmaHighway();

	public static final RegistryKey<Biome> HMA_HIGHWAY_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("tajmod", "hma_highway"));
	public static final GameRules.Key<GameRules.BooleanRule> HMA_SPAWNING =
			GameRuleRegistry.register("spawnHmas", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));	@Override

	public void onInitialize() {
		GeckoLib.initialize();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		FabricDefaultAttributeRegistry.register(HMA, HmaEntity.createHmaAttributes());

		// ITEMS
		Registry.register(Registry.ITEM, new Identifier("tajmod", "hma_shard"), HMA_SHARD);
		Registry.register(Registry.ITEM, new Identifier("tajmod", "hma_crystal"), HMA_CRYSTAL);

		Registry.register(Registry.ITEM, new Identifier("tajmod", "hma_sword"), HMA_SWORD);
		Registry.register(Registry.ITEM, new Identifier("tajmod", "hma_shovel"), HMA_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier("tajmod", "hma_pickaxe"), HMA_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier("tajmod", "hma_axe"), HMA_AXE);
		Registry.register(Registry.ITEM, new Identifier("tajmod", "hma_hoe"), HMA_HOE);

		Registry.register(BuiltinRegistries.BIOME, HMA_HIGHWAY_KEY.getValue(), HMA_HIGHWAY);

		BiomeModifications.addSpawn(BiomeSelectors.spawnsOneOf(EntityType.ZOMBIE), SpawnGroup.MONSTER, TajMod.HMA, 1, 1, 1);
		LOGGER.info("Hello Fabric world!");
	}
}
