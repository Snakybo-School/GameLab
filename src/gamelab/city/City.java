package gamelab.city;

import com.snakybo.sengine.core.Component;

/** @author Kevin Krol
 * @since May 13, 2014 */
public class City extends Component {
	private int size;
	
	public City() {
		size = 1;
	}
	
	/*@Override
	protected void render(Shader shader, RenderingEngine renderingEngine) {
		glPushMatrix();
		glLoadIdentity();
		
		glBindTexture(GL_TEXTURE_2D, 0);
		glColor3f(0, 0, 0);
		
		glBegin(GL_LINE_LOOP);
		
		for(int i = 0; i <= 300; i++) {
			double angle = 2 * Math.PI * i / 300;
			
			double x = (15f * size) * Math.cos(angle);
			double z = (7.5f * size) * Math.sin(angle);
			
			glVertex3d(x, 0, z);
		}
		
		glEnd();
		
		glPopMatrix();
	}*/
}