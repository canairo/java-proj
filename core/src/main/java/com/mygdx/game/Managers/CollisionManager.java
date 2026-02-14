package io.github.some_example_name.lwjgl3.Managers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.badlogic.gdx.math.Rectangle;


import io.github.some_example_name.lwjgl3.Collision.CollisionListener;
import io.github.some_example_name.lwjgl3.Collision.CollisionResolver;
import io.github.some_example_name.lwjgl3.Collision.ICollidable;

public class CollisionManager {

    private Set<ICollidable> colliders;
    private CollisionListener listener;
    private CollisionResolver resolver;

    public CollisionManager() {
        this.colliders = new HashSet<>();
        this.listener = null;
        this.resolver = null;
    }

    public void addCollidableObject(ICollidable obj) {
        colliders.add(obj);
    }

    public void removeCollidableObject(ICollidable obj) {
        colliders.remove(obj);
    }

    public void setResolver(CollisionResolver resolver) {
        this.resolver = resolver;
    }

    public void setListener(CollisionListener listener) {
        this.listener = listener;
    }

}

// entityManager, collisionManager
// e.g. wall = new Entity(400, 200, 120, 150);
// entityManager.add(wall)
// collisionManager.addCollidableObj()