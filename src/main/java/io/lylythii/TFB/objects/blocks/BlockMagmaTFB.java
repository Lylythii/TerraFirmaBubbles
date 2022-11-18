package io.lylythii.TFB.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockMagma;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlockMagmaTFB extends BlockMagma {
	public BlockMagmaTFB() {
		setRegistryName("minecraft", "magma");
		setTranslationKey("magma");
		setHarvestLevel("pickaxe", 0);
		setHardness(0.5F);
		setLightLevel(3.0F);
		setSoundType(SoundType.STONE);
	}
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		BlockColumnDown.placeBubbleColumn(worldIn, pos.up());
	}
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		BlockColumnDown.placeBubbleColumn(worldIn, pos.up());
	}
}
