package craftjakob.enderite.core.init;

import craftjakob.enderite.Enderite;
import craftjakob.enderite.common.block.EndRespawnAnchor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Enderite.MODID);

    public static final RegistryObject<Block> ENDERITE_ORE = BLOCKS.register("enderite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS)
                    .strength(35.0f, 1200.0F).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> RAW_ENDERITE_BLOCK = BLOCKS.register("raw_enderite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(35.0f, 1200.0F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ENDERITE_BLOCK = BLOCKS.register("enderite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .strength(40.0f, 1200.0F).requiresCorrectToolForDrops()));
    
    public static final RegistryObject<Block> END_RESPAWN_ANCHOR = BLOCKS.register("end_respawn_anchor",
            () -> new EndRespawnAnchor(BlockBehaviour.Properties.copy(Blocks.RESPAWN_ANCHOR)
                    .strength(40.0f, 1200.0F).requiresCorrectToolForDrops()));
   
    // Gilded Block
    public static final RegistryObject<Block> GILDED_ENDERITE_BLOCK = BLOCKS.register("gilded_enderite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .strength(45.0f, 1200.0F).requiresCorrectToolForDrops()));
    
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}