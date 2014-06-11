package gamelab.player;

import gamelab.GameLab;
import gamelab.tile.Tile;
import gamelab.world.chunk.Chunk;

import com.snakybo.sengine.components.Camera;
import com.snakybo.sengine.core.Component;
import com.snakybo.sengine.core.Input;
import com.snakybo.sengine.core.utils.Vector2f;
import com.snakybo.sengine.rendering.RenderingEngine;
import com.snakybo.sengine.rendering.Shader;

/** @author Kevin Krol
 * @since May 22, 2014 */
public class InputHandler extends Component {
	private Camera camera;
	private GameLab game;
	
	public InputHandler(GameLab game) {
		this.game = game;
	}
	
	@Override
	protected void input(float delta) {
		if(camera == null)
			return;
		
		if(Input.getMouse(0)) {
			final Vector2f mouseWorld = camera.mouseToWorld();
			
			Chunk chunk = game.getWorld().getChunkFromMouseCoords((int)mouseWorld.getX(), (int)mouseWorld.getY());
			
			if(chunk != null) {
				Tile tile = chunk.getTileFromMouseCoords((int)mouseWorld.getX(), (int)mouseWorld.getY());
				
				if(tile.getTileId() != Tile.GRASS)
					game.getWorld().setTile(chunk, tile.getPosition().getX(), tile.getPosition().getY(), Tile.GRASS);
			}
		}
	}
	
	@Override
	protected void render(Shader shader, RenderingEngine renderingEngine) {
		if(camera == null)
			camera = renderingEngine.getMainCamera();
	}
}
