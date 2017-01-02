package com.ayutaki.chinjufumod.init.worldgene;

import java.util.Random;

import com.ayutaki.chinjufumod.init.ChinjufuModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ChinjufuWorldGene implements IWorldGenerator {

	public WorldGenerator BauxiteOre;


	public ChinjufuWorldGene() {
		BauxiteOre = new WorldGenMinable(ChinjufuModBlocks.BAUXITE_ORE.getDefaultState(), 8);

	}

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

		switch(world.provider.getDimension()) {

			case 0 :	//オーバーワールド Coal=142,Iron=77,RedStone=25,Gold=8,Lapiz=3.4
				this.runGenerator(BauxiteOre, world, random, chunkX, chunkZ, 40, 10, 70);
				break;

			case -1 :	//ネザー

				break;

			case 1 :	//エンド

				break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
            throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chancesToSpawn; i ++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x, y, z));
        }
    }
}
