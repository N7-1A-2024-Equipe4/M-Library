package utils.image;

import javax.swing.ImageIcon;
import java.util.concurrent.ConcurrentHashMap;

public class ImageCache {
    private static ImageCache instance;
    private final ConcurrentHashMap<Integer, ImageIcon> cache;

    private ImageCache() {
        cache = new ConcurrentHashMap<>();
    }

    public static ImageCache getInstance() {
        if (instance == null) {
            instance = new ImageCache();
        }
        return instance;
    }

    public ImageIcon getImage(Integer id) {
        return cache.get(id);
    }

    public void addImage(Integer id, ImageIcon image) {
        cache.put(id, image);
    }
}
