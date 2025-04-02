package net.em.firereborn.block.custom;

import net.em.firereborn.item.ModItems;
import net.em.firereborn.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class BurnerBlock extends Block {
    public BurnerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getStack())) {
                itemEntity.setStack(new ItemStack(ModItems.INFERIUM, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.ACACIA_LOG) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.OAK_LOG) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.SPRUCE_LOG) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.BIRCH_LOG) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.DARK_OAK_LOG) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.MANGROVE_LOG) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.CHERRY_LOG) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.JUNGLE_LOG) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.BAMBOO_BLOCK) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.COBBLESTONE) {
                itemEntity.setStack(new ItemStack(Items.STONE, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.COBBLED_DEEPSLATE) {
                itemEntity.setStack(new ItemStack(Items.DEEPSLATE, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.BAMBOO_BLOCK) {
                itemEntity.setStack(new ItemStack(Items.COAL_BLOCK, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.APPLE) {
                itemEntity.setStack(new ItemStack(ModItems.FIRE_APPLE, itemEntity.getStack().getCount()));
            }

            if(itemEntity.getStack().getItem() == Items.COAL) {
                itemEntity.setStack(new ItemStack(ModItems.HOT_COAL, itemEntity.getStack().getCount()));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.firereborn.burner_block.tooltip.1"));
            tooltip.add(Text.translatable("tooltip.firereborn.burner_block.tooltip.2"));
            tooltip.add(Text.translatable("tooltip.firereborn.burner_block.tooltip.3"));
            tooltip.add(Text.translatable("tooltip.firereborn.burner_block.tooltip.4"));
            tooltip.add(Text.translatable("tooltip.firereborn.burner_block.tooltip.5"));
            tooltip.add(Text.translatable("tooltip.firereborn.burner_block.tooltip.6"));
            tooltip.add(Text.translatable("tooltip.firereborn.burner_block.tooltip.7"));
        } else {
            tooltip.add(Text.translatable("tooltip.firereborn.shift.up"));
        }
        super.appendTooltip(stack, context, tooltip, options);
    }
}
