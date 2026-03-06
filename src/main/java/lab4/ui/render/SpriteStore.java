/**
 * SpriteStore.java
 */
package lab4.ui.render;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SpriteStore {

  private final Map<String, Image> sprites = new ConcurrentHashMap<>();

  public SpriteStore() {
    put("Volvo240", "/pics/Volvo240.jpg");
    put("Saab95", "/pics/Saab95.jpg");
    put("Scania", "/pics/Scania.jpg");
    put("VolvoFH16", "/pics/VolvoFH16.png");
    put("Garage", "/pics/VolvoBrand.jpg");
  }

  public Image get(String spriteId) {
    Image img = sprites.get(spriteId);
    if (img != null) return img;

    return null;
  }

  private void put(String spriteId, String resourcePath) {
    sprites.put(spriteId, load(resourcePath));
  }

  private static Image load(String resourcePath) {
    try (InputStream in = SpriteStore.class.getResourceAsStream(resourcePath)) {
      if (in == null) {
        System.err.println("Sprite missing on classpath: " + resourcePath);
        return null;
      }
      BufferedImage img = ImageIO.read(in);
      return img;
    } catch (IOException e) {
      throw new IllegalStateException("Failed to load sprite: " + resourcePath, e);
    }
  }
}
