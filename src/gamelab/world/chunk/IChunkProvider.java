package gamelab.world.chunk;

/** @author Kevin Krol
 * @since May 20, 2014 */
public interface IChunkProvider {
	Chunk provideChunk(int x, int y);
	
	void loadChunk(int x, int y);
	
	void unloadQueuedChunks();
	
	int getLoadedChunkCount();
}
