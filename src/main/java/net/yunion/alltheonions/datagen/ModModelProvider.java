package net.yunion.alltheonions.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;
import net.yunion.alltheonions.block.ModBlocks;
import net.yunion.alltheonions.block.custom.FaceBlock;
import net.yunion.alltheonions.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool onionGemPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ONION_GEM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ONION_GEM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TUNER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ONION_GEM_DEEPSLATE_ORE);

        onionGemPool.stairs(ModBlocks.ONION_GEM_STAIRS);
        onionGemPool.slab(ModBlocks.ONION_GEM_SLAB);
        onionGemPool.button(ModBlocks.ONION_GEM_BUTTON);
        onionGemPool.fence(ModBlocks.ONION_GEM_FENCE);
        onionGemPool.fenceGate(ModBlocks.ONION_GEM_FENCE_GATE);
        onionGemPool.pressurePlate(ModBlocks.ONION_GEM_PRESSURE_PLATE);
        onionGemPool.wall(ModBlocks.ONION_GEM_WALL);


        blockStateModelGenerator.registerDoor(ModBlocks.ONION_GEM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ONION_GEM_TRAPDOOR);

        Identifier sadFaceIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.FACE_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier happyFaceIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.FACE_BLOCK, "_happy", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.FACE_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(FaceBlock.HAPPY, happyFaceIdentifier, sadFaceIdentifier)));


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ONION_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHARCOAL_ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONION_GEM_CUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.REGULAR_ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.TUNING_FORK, Models.GENERATED);


    }
}
