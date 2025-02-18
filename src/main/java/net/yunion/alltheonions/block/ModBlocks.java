package net.yunion.alltheonions.block;


import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.yunion.alltheonions.AllTheOnions;
import net.yunion.alltheonions.block.custom.FaceBlock;
import net.yunion.alltheonions.block.custom.TunerBlock;


public class ModBlocks {

    public static final Block ONION_GEM_BLOCK = registerBlock("onion_gem_block",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_block")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
       public static final Block ONION_GEM_ORE = registerBlock("onion_gem_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_ore")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));
    public static final Block ONION_GEM_DEEPSLATE_ORE = registerBlock("onion_gem_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,7), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_deepslate_ore")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static  final Block CRATE = registerBlock("crate",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "crate")))
                    .strength(2.5f).sounds(BlockSoundGroup.WOOD).burnable()));
    public static final Block TUNER_BLOCK = registerBlock("tuner_block",
            new TunerBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "tuner_block")))
                    .strength(1f).requiresTool()));

    public static final Block ONION_GEM_STAIRS = registerBlock("onion_gem_stairs",
            new StairsBlock(ModBlocks.ONION_GEM_BLOCK.getDefaultState(), AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_stairs")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block ONION_GEM_WALL = registerBlock("onion_gem_wall",
            new WallBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_wall")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block ONION_GEM_SLAB = registerBlock("onion_gem_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_slab")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block ONION_GEM_BUTTON = registerBlock("onion_gem_button",
            new ButtonBlock(BlockSetType.IRON, 5, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_button")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block ONION_GEM_PRESSURE_PLATE = registerBlock("onion_gem_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_pressure_plate")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block ONION_GEM_FENCE = registerBlock("onion_gem_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_fence")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block ONION_GEM_FENCE_GATE = registerBlock("onion_gem_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_fence_gate")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block ONION_GEM_DOOR = registerBlock("onion_gem_door",
            new DoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_door")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque()));
    public static final Block ONION_GEM_TRAPDOOR = registerBlock("onion_gem_trapdoor",
            new TrapdoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID, "onion_gem_trapdoor")))
                    .strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque()));


    public static final Block FACE_BLOCK = registerBlock("face_block",
            new FaceBlock(AbstractBlock.Settings.create()
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(AllTheOnions.MOD_ID)))
                    .strength(2f).requiresTool().luminance(state -> state.get(FaceBlock.HAPPY) ? 15 : 2)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);


        return Registry.register(Registries.BLOCK, Identifier.of(AllTheOnions.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(AllTheOnions.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AllTheOnions.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModBlocks() {
        AllTheOnions.LOGGER.info("Registering blocks for " + AllTheOnions.MOD_ID);

    }

}
