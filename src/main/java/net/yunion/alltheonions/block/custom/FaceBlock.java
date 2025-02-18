package net.yunion.alltheonions.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FaceBlock extends Block {
    public static final BooleanProperty HAPPY = BooleanProperty.of("happy");


    public FaceBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(HAPPY, false));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if(!world.isClient()){
            world.setBlockState(pos, state.cycle(HAPPY));
        }


        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HAPPY);
    }
}
