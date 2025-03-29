package net.em.firereborn;

import net.em.firereborn.blocks.ModBlocks;
import net.em.firereborn.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireReborn implements ModInitializer {
	public static final String MOD_ID = "firereborn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}