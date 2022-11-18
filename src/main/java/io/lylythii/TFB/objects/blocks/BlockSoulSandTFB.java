package io.lylythii.TFB.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlockSoulSandTFB extends BlockSoulSand {
	public BlockSoulSandTFB() {
		setRegistryName("minecraft", "soul_sand");
		setTranslationKey("hellsand");
		setHarvestLevel("shovel", 0);
		setHardness(0.5F);
		setSoundType(SoundType.SAND);
	}
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		BlockColumnUp.placeBubbleColumn(worldIn, pos.up());
	}
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		BlockColumnUp.placeBubbleColumn(worldIn, pos.up());
	}
}
