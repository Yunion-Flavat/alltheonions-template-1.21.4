package net.yunion.alltheonions;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.fabric.mixin.content.registry.FuelRegistryMixin;
import net.minecraft.item.FuelRegistry;
import net.yunion.alltheonions.block.ModBlockEntityTypes;
import net.yunion.alltheonions.block.ModBlocks;
import net.yunion.alltheonions.item.ModItemGroups;
import net.yunion.alltheonions.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllTheOnions implements ModInitializer {
	public static final String MOD_ID = "all_the_onions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static void registerFuels() {
		FuelRegistryEvents.BUILD.register((builder, context) -> {
			builder.add(ModItems.CHARCOAL_ONION, 300);
			builder.add(ModBlocks.CRATE, 300);
		});
	}

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		AllTheOnions.registerFuels();
		ModBlockEntityTypes.initialize();

	}
}