package io.github.some_example_name.lwjgl3.Collision;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;

public class CollidableObject {
    protected Rectangle bounds;
    private String objectId;

    public CollidableObject(String objId, float x, float y, float width, float height) {
        this.objectId = objId;
        this.bounds = new Rectangle(x, y, width, height);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(float x, float y, float width, float height) {
        this.bounds = new Rectangle(x, y, width, height);
    }

    public String getObjId() {
        return this.objectId;
    }

    public void setObjId(String newId) {
        this.objectId = newId;
    }
}
