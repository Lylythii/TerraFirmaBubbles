package io.lylythii.TFB;

import io.lylythii.TFB.objects.blocks.BlockColumnUp;
import io.lylythii.TFB.objects.blocks.BlockColumnDown;
import io.lylythii.TFB.objects.blocks.BlockMagmaTFB;
import io.lylythii.TFB.objects.blocks.BlockSoulSandTFB;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;


@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		ObfuscationReflectionHelper.setPrivateValue(Block.class, Blocks.MAGMA, (new BlockMagmaTFB()).getDefaultState(), new String[] { "field_176228_M", "defaultBlockState", "c" });
		ObfuscationReflectionHelper.setPrivateValue(Block.class, Blocks.SOUL_SAND, (new BlockSoulSandTFB()).getDefaultState(), new String[] { "field_176228_M", "defaultBlockState", "c" });
		event.getRegistry().register(new BlockColumnUp());
		event.getRegistry().register(new BlockColumnDown());
		event.getRegistry().register(new BlockMagmaTFB());
		event.getRegistry().register(new BlockSoulSandTFB());
	}
}
