package com.mygdx.game.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
  private Map<String, Texture> textures = new HashMap<>();

  public void loadTexture(String key, String path) {
    if (!textures.containsKey(key)) {
      Texture tex = new Texture(Gdx.files.internal(path));
      textures.put(key, tex);
    }
  }

  public TextureRegion getRegion(String key) {
    Texture tex = textures.get(key);
    if (tex == null) {
      Gdx.app.error("ResourceManager", "Texture not found: " + key);
      return null;
    }
    return new TextureRegion(tex);
  }

  public Texture getRawTexture(String key) {
    return textures.get(key);
  }

  public void dispose() {
    for (Texture tex : textures.values()) {
      tex.dispose();
    }
    textures.clear();
  }

  public void initialize() {
    this.loadTexture("player", "player.png");
  }
}
