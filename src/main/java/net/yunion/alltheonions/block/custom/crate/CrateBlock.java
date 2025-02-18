package net.yunion.alltheonions.block.custom.crate;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.yunion.alltheonions.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class CrateBlock extends BlockWithEntity {
    public CrateBlock (Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends CrateBlock> getCodec() {
        return createCodec(CrateBlock::new);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrateBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

   /* @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlocks.CRATE, CrateBlockEntity::tick);
    }*/


}
