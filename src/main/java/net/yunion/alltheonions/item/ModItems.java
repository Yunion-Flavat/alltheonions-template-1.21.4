package net.yunion.alltheonions.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.yunion.alltheonions.AllTheOnions;

public class ModItems {
    public static Item register(Item item, RegistryKey<Item> registryKey) {
        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

        // Return the registered item!
        return registeredItem;
    }
    public static final RegistryKey<Item> ONION_GEM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID, "onion_gem"));
    public static final RegistryKey<Item> ONION_GEM_CUT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_cut"));
    public static final Item ONION_GEM = register(
            new Item(new Item.Settings().registryKey(ONION_GEM_KEY)),
            ONION_GEM_KEY
    );
    public static final Item ONION_GEM_CUT = register(
            new Item(new Item.Settings().registryKey(ONION_GEM_CUT_KEY)),
            ONION_GEM_CUT_KEY
    );
    //public static final Item ONION_GEM = registerItem("onion_gem", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID)))));
    //public static final Item ONION_GEM_CUT = registerItem("onion_gem_cut", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID)))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(AllTheOnions.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AllTheOnions.LOGGER.info("Registering items for " + AllTheOnions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> itemGroup.add(ModItems.ONION_GEM));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> itemGroup.add(ModItems.ONION_GEM_CUT));

    }


        /*public static Item register(Item item, RegistryKey<Item> registryKey) {
            // Register the item.
            Item registeredItem = Registry.register(Registries.ITEM, registryKey.getValue(), item);

            // Return the registered item!
            return registeredItem;
        }

    public static final RegistryKey<Item> ONION_GEM_CUT = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_cut"));
    public static final Item SUSPICIOUS_SUBSTANCE = register(
            new Item(new Item.Settings().registryKey(ONION_GEM_CUT)),
            ONION_GEM_CUT
    );*/


}
