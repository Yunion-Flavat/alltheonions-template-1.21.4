package net.yunion.alltheonions.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.yunion.alltheonions.block.ModBlocks;
import net.yunion.alltheonions.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    private Object registryLookup;

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TUNER_BLOCK);
        addDrop(ModBlocks.ONION_GEM_BLOCK);
        addDrop(ModBlocks.CRATE);

        addDrop(ModBlocks.ONION_GEM_ORE, oreDrops(ModBlocks.ONION_GEM_ORE, ModItems.ONION_GEM));
        addDrop(ModBlocks.ONION_GEM_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.ONION_GEM_DEEPSLATE_ORE, ModItems.ONION_GEM, 4, 10));

        addDrop(ModBlocks.ONION_GEM_STAIRS);
        addDrop(ModBlocks.ONION_GEM_SLAB, slabDrops(ModBlocks.ONION_GEM_SLAB));

        addDrop(ModBlocks.ONION_GEM_BUTTON);
        addDrop(ModBlocks.ONION_GEM_PRESSURE_PLATE);

        addDrop(ModBlocks.ONION_GEM_WALL);
        addDrop(ModBlocks.ONION_GEM_FENCE);
        addDrop(ModBlocks.ONION_GEM_FENCE_GATE);

        addDrop(ModBlocks.ONION_GEM_DOOR, doorDrops(ModBlocks.ONION_GEM_DOOR));
        addDrop(ModBlocks.ONION_GEM_TRAPDOOR);

    }
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
