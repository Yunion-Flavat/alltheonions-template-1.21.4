package net.yunion.alltheonions.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.yunion.alltheonions.AllTheOnions;
import org.spongepowered.include.com.google.common.base.Function;

public class ModItems {

    //create items to be added to the registry
    public static final Item ONION_GEM = registerItem("onion_gem", Item::new, new Item.Settings());
    public static final Item ONION_GEM_CUT = registerItem("onion_gem_cut", Item::new, new Item.Settings());


    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID, name));

        return Items.register(registerKey, factory, settings);
    }

    private static void customIngredients(FabricItemGroupEntries entries){
        //add items to the registry
        entries.add(ONION_GEM);
        entries.add(ONION_GEM_CUT);
    }

    public static void registerModItems() {
        AllTheOnions.LOGGER.info("Registering items for " + AllTheOnions.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);

    }

}
