import java.io.IOException;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class MainProgram {

	public static void main(String[] args) throws IOException{
		World world = new World(new Vec2(0f, -10f));
		BodyDef groudBodyDef = new BodyDef();
		groudBodyDef.position.set(0.0f, -10.0f);
		Body groundBody = world.createBody(groudBodyDef);
		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(50.0f, 10.0f);
		groundBody.createFixture(groundBox, 0.0f);

		BodyDef bodyDef = new BodyDef();
		bodyDef.setType(BodyType.DYNAMIC);
		bodyDef.position.set(0, 4);
		Body body = world.createBody(bodyDef);
		PolygonShape dynamicBox = new PolygonShape();
		dynamicBox.setAsBox(1, 1);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = dynamicBox;
		fixtureDef.density = 1.0f;
		fixtureDef.restitution = 1f;
		body.createFixture(fixtureDef);

		while (true) {
			world.step(1f / 60f, 6, 2);
			Vec2 pos = body.getPosition();
			System.out.println(pos.x + ", " + pos.y);
			System.in.read();
		}
	}
}
