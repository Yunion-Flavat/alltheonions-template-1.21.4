package net.yunion.alltheonions.block;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.yunion.alltheonions.AllTheOnions;


public class ModBlocks {

    /*public static Block registerBlock(String name, Function<Item.Settings, Block> factory, Item.Settings settings){
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID, name));

        return Items.register(registerKey, factory, settings);
    }*/

    public static final Block ONION_GEM_BLOCK = registerBlock("onion_gem_block",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_block")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static  final Block CRATE = registerBlock("crate",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "crate")))
                    .strength(2.5f).sounds(BlockSoundGroup.WOOD).burnable()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(AllTheOnions.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AllTheOnions.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(ONION_GEM_BLOCK);

    }

    public static void registerModBlocks() {
        AllTheOnions.LOGGER.info("Registering blocks for " + AllTheOnions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::customIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(ModBlocks.CRATE);
        });


    }

}
