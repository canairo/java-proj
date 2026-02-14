package io.github.some_example_name.lwjgl3.Collision;

import java.util.List;

public class CollisionListener {
    protected   List<ICollidable> collidingSet;

    public void detectCollision(List<ICollidable> collidables) {
        for (int i = 0; i < collidables.size(); i++) {
            for (int j = i + 1; j < collidables.size(); j++) {
                ICollidable a = collidables.get(i);
                ICollidable b = collidables.get(j);

                if (checkCollision(a, b)) {
                    a.collide();
                    b.collide();
                }
            }
        }

    }

    public boolean checkCollision(ICollidable a, ICollidable b) {
        CollidableObject objA = (CollidableObject) a;
        CollidableObject objB = (CollidableObject) b;
        if (objA.getBounds().overlaps(objB.getBounds())) {
            return true;
        }
        return false;
    }
}