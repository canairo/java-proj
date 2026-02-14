package io.github.some_example_name.lwjgl3.Collision;

public class CollisionResolver {
    void resolve(ICollidable a, ICollidable b) {
        //connect to entity manager / game master to update the master state of entities
        //resolve logic shld be implemented in the indiv. subclass of entity
    }
}
