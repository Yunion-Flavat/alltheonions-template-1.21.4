package net.yunion.alltheonions.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.yunion.alltheonions.block.ModBlocks;

import java.util.Map;

public class TuningForkItem extends Item {
    private static final Map<Block, Block> TUNING_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.NETHERRACK, Blocks.NETHER_BRICKS,
                    ModBlocks.ONION_GEM_ORE, ModBlocks.ONION_GEM_DEEPSLATE_ORE,
                    ModBlocks.ONION_GEM_DEEPSLATE_ORE, ModBlocks.ONION_GEM_ORE
            );
    public TuningForkItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(TUNING_MAP.containsKey(clickedBlock) && !world.isClient()) {

            world.setBlockState(context.getBlockPos(), TUNING_MAP.get(clickedBlock).getDefaultState());
            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 2f, 1f);
        }


        return ActionResult.SUCCESS;
    }
}
