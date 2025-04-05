package net.em.firereborn;

import net.em.firereborn.block.ModBlocks;
import net.em.firereborn.component.ModDataComponentTypes;
import net.em.firereborn.item.ModItemGroups;
import net.em.firereborn.item.ModItems;
import net.em.firereborn.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonFight;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
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

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof EndermanEntity endermanEntity) {
				if(player.getMainHandStack().getItem() == ModItems.INFERIUM_HOE) {
					player.sendMessage(Text.translatable("event.firereborn.livingDamageEvent"));
					endermanEntity.kill();
					player.getMainHandStack().decrement(1);
				}

				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		});
	}
}