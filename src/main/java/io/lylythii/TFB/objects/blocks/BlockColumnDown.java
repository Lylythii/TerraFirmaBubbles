package io.lylythii.TFB.objects.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockColumnDown extends BlockLiquid {
	public BlockColumnDown() {
		super(Material.WATER);
		setRegistryName("column_down");
		setTranslationKey("Bubble Column Down");
		setDefaultState(this.blockState.getBaseState());
	}
	
	public void onEnterBubbleColumn(Entity entityIn) {
		entityIn.motionY = Math.max(-0.3D, entityIn.motionY - 0.03D);
		entityIn.fallDistance = 0.0F;
	}
	
	public void onEnterBubbleColumnWithAirAbove(Entity entityIn) {
		entityIn.motionY = Math.max(-0.9D, entityIn.motionY - 0.03D);
	}
	
	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		IBlockState iblockstate = worldIn.getBlockState(pos.up());
		if (iblockstate.getBlock() == Blocks.AIR) {
			onEnterBubbleColumnWithAirAbove(entityIn);
		}
		else {
			onEnterBubbleColumn(entityIn);
		} 
	}
	
	public static void placeBubbleColumn(World world, BlockPos pos) {
		if (canHoldBubbleColumn(world, pos))
			world.setBlockState(pos, BlocksTFB.COLUMN_DOWN.getDefaultState()
		); 
	}
	
	public static boolean canHoldBubbleColumn(World world, BlockPos pos) {
		return (world.getBlockState(pos).getMaterial() == Material.WATER && world.getBlockState(pos).getBlock() instanceof BlockLiquid && ((BlockLiquid)world.getBlockState(pos).getBlock()).getMetaFromState(world.getBlockState(pos)) == 0 && (world.getBlockState(pos.down()).getBlock() == Blocks.MAGMA || world.getBlockState(pos.down()) == BlocksTFB.COLUMN_DOWN.getDefaultState()));
	}
	
	@SideOnly(Side.CLIENT)
		public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		double d0 = pos.getX();
		double d1 = pos.getY();
		double d2 = pos.getZ();
		worldIn.spawnParticle(EnumParticleTypes.WATER_BUBBLE, d0 + 0.5D, d1, d2 + 0.5D, 0.0D, -1.0D, 0.0D, new int[0]);
		worldIn.spawnParticle(EnumParticleTypes.WATER_BUBBLE, d0 + rand.nextFloat(), d1 + rand.nextFloat(), d2 + rand.nextFloat(), 0.0D, -1.0D, 0.0D, new int[0]);
		worldIn.spawnParticle(EnumParticleTypes.WATER_BUBBLE, d0 + rand.nextFloat(), d1 + rand.nextFloat(), d2 + rand.nextFloat(), 0.0D, -1.0D, 0.0D, new int[0]);
	}
	
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!isValidPosition(worldIn, pos))
			worldIn.setBlockState(pos, Blocks.WATER.getDefaultState()); 
		placeBubbleColumn(worldIn, pos.up());
	}
	
	public boolean isValidPosition(World worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos.down()).getBlock();
			return (block == this || block == Blocks.MAGMA);
	}
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		placeBubbleColumn(worldIn, pos.up());
	}
}
