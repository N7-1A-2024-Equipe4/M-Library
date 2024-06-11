package utils.image;

import javax.swing.ImageIcon;
import java.util.concurrent.ConcurrentHashMap;

public class ImageCache {
    private final ConcurrentHashMap<Integer, ImageIcon> cache = new ConcurrentHashMap<>();

    public ImageIcon getImage(Integer id) {
        return cache.get(id);
    }

    public void addImage(Integer id, ImageIcon image) {
        cache.put(id, image);
    }
}