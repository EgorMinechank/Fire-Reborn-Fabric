package net.em.firereborn.item.custom;

import net.em.firereborn.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class BurnerItem extends Item {
    private static final Map<Block, Block> BURNER_MAP =
            Map.of(
                    Blocks.STONE, Blocks.NETHERRACK,
                    Blocks.BAMBOO_BLOCK, Blocks.COAL_BLOCK,
                    Blocks.OAK_LOG, Blocks.COAL_BLOCK,
                    Blocks.SPRUCE_LOG, Blocks.COAL_BLOCK,
                    Blocks.JUNGLE_LOG, Blocks.COAL_BLOCK,
                    Blocks.BIRCH_LOG, Blocks.COAL_BLOCK,
                    Blocks.ACACIA_LOG, Blocks.COAL_BLOCK,
                    Blocks.DARK_OAK_LOG, Blocks.COAL_BLOCK,
                    Blocks.MANGROVE_LOG, Blocks.COAL_BLOCK,
                    Blocks.CHERRY_LOG, Blocks.COAL_BLOCK
            );

    public BurnerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(BURNER_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), BURNER_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.firereborn.burner.shift.down"));
        } else {
            tooltip.add(Text.translatable("tooltip.firereborn.shift.up"));
        }

        if(stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltip.add(Text.literal("Last Block Burned at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
