package net.yunion.alltheonions;

import net.fabricmc.api.ModInitializer;

import net.yunion.alltheonions.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllTheOnions implements ModInitializer {
	public static final String MOD_ID = "all_the_onions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

	}
}