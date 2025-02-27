package net.yunion.alltheonions.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.yunion.alltheonions.AllTheOnions;
import net.yunion.alltheonions.item.custom.TuningForkItem;
import org.spongepowered.include.com.google.common.base.Function;

public class ModItems {

    //create items to be added to the registry
    public static final Item ONION_GEM = registerItem("onion_gem", Item::new, new Item.Settings());
    public static final Item ONION_GEM_CUT = registerItem("onion_gem_cut", Item::new, new Item.Settings());
    public static final Item CHARCOAL_ONION = registerItem("charcoal_onion", Item::new, new Item.Settings());

    public static final Item TUNING_FORK = registerItem("tuning_fork", TuningForkItem::new, new Item.Settings().maxDamage(64));

    public static final Item REGULAR_ONION = registerItem("regular_onion", Item::new, new Item.Settings().food(ModFoodComponents.REGULAR_ONION, ModFoodComponents.REGULAR_ONION_EFFECT));


    public static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID, name));

        return Items.register(registerKey, factory, settings);
    }



    public static void registerModItems() {
        AllTheOnions.LOGGER.info("Registering items for " + AllTheOnions.MOD_ID);
    }

}
