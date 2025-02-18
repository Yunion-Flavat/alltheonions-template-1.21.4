package net.yunion.alltheonions.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yunion.alltheonions.AllTheOnions;
import net.yunion.alltheonions.block.ModBlocks;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> All_THE_ONIONS_ITEMS_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(AllTheOnions.MOD_ID, "all_the_onions_items"));
    public static final RegistryKey<ItemGroup> All_THE_ONIONS_BLOCKS_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(AllTheOnions.MOD_ID, "all_the_onions_blocks"));


    public static final ItemGroup All_THE_ONIONS_BLOCKS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.ONION_GEM_BLOCK))
            .displayName(Text.translatable("itemgroup.all_the_onions.all_the_onions_blocks"))
            .build();

    public static final ItemGroup All_THE_ONIONS_ITEMS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.ONION_GEM))
            .displayName(Text.translatable("itemgroup.all_the_onions.all_the_onions_items"))
            .build();


//add items to item groups
private static void itemTab(FabricItemGroupEntries entries){
    //add items to the registry
    entries.add(ModItems.ONION_GEM);
    entries.add(ModItems.ONION_GEM_CUT);
    entries.add(ModItems.TUNING_FORK);
    entries.add(ModItems.REGULAR_ONION);
    entries.add(ModItems.CHARCOAL_ONION);
}

    private static void blockTab(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.ONION_GEM_BLOCK);
        entries.add(ModBlocks.CRATE);
        entries.add(ModBlocks.ONION_GEM_DEEPSLATE_ORE);
        entries.add(ModBlocks.ONION_GEM_ORE);
        entries.add(ModBlocks.TUNER_BLOCK);

        entries.add(ModBlocks.ONION_GEM_STAIRS);
        entries.add(ModBlocks.ONION_GEM_SLAB);
        entries.add(ModBlocks.ONION_GEM_BUTTON);
        entries.add(ModBlocks.ONION_GEM_PRESSURE_PLATE);
        entries.add(ModBlocks.ONION_GEM_FENCE);
        entries.add(ModBlocks.ONION_GEM_FENCE_GATE);
        entries.add(ModBlocks.ONION_GEM_WALL);
        entries.add(ModBlocks.ONION_GEM_DOOR);
        entries.add(ModBlocks.ONION_GEM_TRAPDOOR);
        entries.add(ModBlocks.FACE_BLOCK);

    }

    public static void registerItemGroups() {
        AllTheOnions.LOGGER.info("Registering Item Groups for " + AllTheOnions.MOD_ID);

        Registry.register(Registries.ITEM_GROUP, All_THE_ONIONS_BLOCKS_GROUP_KEY, All_THE_ONIONS_BLOCKS_GROUP);
        Registry.register(Registries.ITEM_GROUP, All_THE_ONIONS_ITEMS_GROUP_KEY, All_THE_ONIONS_ITEMS_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.All_THE_ONIONS_ITEMS_GROUP_KEY).register(ModItemGroups::itemTab);
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.All_THE_ONIONS_BLOCKS_GROUP_KEY).register(ModItemGroups::blockTab);
    }

}
