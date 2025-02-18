package net.yunion.alltheonions.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yunion.alltheonions.block.custom.crate.CrateBlockEntity;

public class ModBlockEntityTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("tutorial", path), blockEntityType);
    }

    public static final BlockEntityType<CrateBlockEntity> CRATE = register("crate", FabricBlockEntityTypeBuilder
            .create(CrateBlockEntity::new, ModBlocks.CRATE).build());

    public static void initialize() {

    }
}
