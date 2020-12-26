package com.doctorquantum.frostbite.common.block;

import com.doctorquantum.frostbite.common.util.ModRegistry;
import com.doctorquantum.frostbite.common.world.gen.VerglasTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

	public static final ModRegistry<Block> BLOCKS = new ModRegistry<>(ForgeRegistries.BLOCKS);

	public static final RegistryObject<Block> PERMAFROST = BLOCKS.register("permafrost", () -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 7.0f)));
	public static final RegistryObject<Block> PERMAFROST_BRICKS = BLOCKS.register("permafrost_bricks", () -> new Block(Block.Properties.from(PERMAFROST.get())));
	public static final RegistryObject<Block> PERMAFROST_BRICK_SLAB = BLOCKS.register("permafrost_brick_slab", () -> new SlabBlock(Block.Properties.from(PERMAFROST_BRICKS.get())));
	public static final RegistryObject<Block> PERMAFROST_BRICK_STAIRS = BLOCKS.register("permafrost_brick_stairs", () -> new StairsBlock(() -> PERMAFROST_BRICKS.get().getDefaultState(), Block.Properties.from(PERMAFROST_BRICKS.get())));
	public static final RegistryObject<Block> PERMAFROST_BRICK_WALL = BLOCKS.register("permafrost_brick_wall", () -> new WallBlock(Block.Properties.from(PERMAFROST_BRICKS.get())));
	public static final RegistryObject<Block> VERGLAS_LOG = BLOCKS.register("verglas_log", () -> new ThawableLogBlock(Blocks.SPRUCE_LOG, null, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> VERGLAS_WOOD = BLOCKS.register("verglas_wood", () -> new ThawableBlock(Blocks.SPRUCE_WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> VERGLAS_PLANKS = BLOCKS.register("verglas_planks", () -> new ThawableBlock(Blocks.SPRUCE_PLANKS, Block.Properties.from(Blocks.OAK_PLANKS).slipperiness(0.90f)));
	public static final RegistryObject<Block> VERGLAS_SLAB = BLOCKS.register("verglas_slab", () -> new ThawableSlabBlock(Blocks.SPRUCE_SLAB, Block.Properties.from(VERGLAS_PLANKS.get())));
	public static final RegistryObject<Block> VERGLAS_STAIRS = BLOCKS.register("verglas_stairs", () -> new ThawableStairsBlock(Blocks.SPRUCE_STAIRS, () -> VERGLAS_PLANKS.get().getDefaultState(), Block.Properties.from(VERGLAS_PLANKS.get())));
	public static final RegistryObject<Block> VERGLAS_FENCE = BLOCKS.register("verglas_fence", () -> new ThawableFenceBlock(Blocks.SPRUCE_FENCE, Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> VERGLAS_FENCE_GATE = BLOCKS.register("verglas_fence_gate", () -> new ThawableFenceGateBlock(Blocks.SPRUCE_FENCE_GATE, Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> VERGLAS_LEAVES = BLOCKS.register("verglas_leaves", () -> new ThawableLeavesBlock(Blocks.SPRUCE_LEAVES, Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> VERGLAS_SAPLING = BLOCKS.register("verglas_sapling", () -> new ModSaplingBlock(() -> new VerglasTree(), Block.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> NETHER_CHILLI = BLOCKS.register("nether_chilli", () -> new NetherChilliBlock(Block.Properties.from(Blocks.SWEET_BERRY_BUSH)));
	public static final RegistryObject<Block> FIREPLACE = BLOCKS.register("fireplace", () -> new FireplaceBlock(Block.Properties.from(Blocks.BRICKS)));

}