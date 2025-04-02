package net.em.firereborn;

import net.em.firereborn.block.ModBlocks;
import net.em.firereborn.component.ModDataComponentTypes;
import net.em.firereborn.item.ModItemGroups;
import net.em.firereborn.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FireReborn implements ModInitializer {
	public static final String MOD_ID = "firereborn";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.HOT_COAL, 3200);
	}
}