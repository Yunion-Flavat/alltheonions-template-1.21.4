package net.yunion.alltheonions.block.custom.crate;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.yunion.alltheonions.block.ModBlockEntityTypes;

public class CrateBlockEntity extends BlockEntity {


   //@Override
    public static void tick(World world, BlockPos pos, BlockState state, CrateBlockEntity blockEntity){

    }

    public CrateBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CRATE, pos, state);
    }
}
