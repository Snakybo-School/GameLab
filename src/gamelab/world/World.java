package gamelab.world;

import gamelab.tile.Tile;
import gamelab.world.chunk.Chunk;
import gamelab.world.chunk.ChunkProvider;

import java.util.Random;

import com.snakybo.sengine.components.Camera;

/** @author Kevin Krol
 * @since May 12, 2014 */
public class World {
	public static final int MIN_WORLD_X = -5000;
	public static final int MIN_WORLD_Y = -5000;
	public static final int MAX_WORLD_X = 5000;
	public static final int MAX_WORLD_Y = 5000;
	
	private ChunkProvider chunkProvider;
	private Random random;
	private Camera camera;	
	
	public World(Camera camera) {		
		this.camera = camera;
		
		random = new Random();
	}
	
	public void start() {
		chunkProvider = new ChunkProvider(this, random.nextLong());
		
		for(int x = 0; x < 2; x++)
			for(int y = 0; y < 2; y++)
				chunkProvider.provideChunk(x, y);
	}
	
	public boolean setTile(Chunk chunk, int x, int y, int tileId) {
		if(x >= MIN_WORLD_X && x <= MAX_WORLD_X && y >= MIN_WORLD_X && y <= MAX_WORLD_Y)
			return chunk.setTile(x & 0xF, y & 0xF, tileId);
		
		return false;
	}
	
	public Tile getTileAt(int x, int y) {
		return getChunkFromTileCoords(x, y).getTileAt(x / Tile.TILE_WIDTH, y / Tile.TILE_HEIGHT);
	}
	
	public Chunk getChunkFromTileCoords(int x, int y) {
		return getChunkFromChunkCoords((x / Tile.TILE_WIDTH) >> 4, (y / Tile.TILE_HEIGHT) >> 4);
	}
	
	public Chunk getChunkFromChunkCoords(int x, int y) {
		return chunkProvider.getChunkAt(x, y);
	}
	
	public Chunk getChunkFromMouseCoords(int x, int y) {
		if((float)x / 2 + 1 >= 16)
			x += 1;
		
		if((float)y / 2 + 1 >= 16)
			y += 1;
		
		x = (x / 2) >> 4;
		y = (y / 2) >> 4;
		
		return chunkProvider.getChunkAt(x, y);
	}
	
	public Camera getCamera() {
		return camera;
	}
}
