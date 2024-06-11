package utils.image;

import javax.swing.ImageIcon;
import java.util.concurrent.ConcurrentHashMap;

public class ImageCache {
    private final ConcurrentHashMap<String, ImageIcon> cache = new ConcurrentHashMap<>();

    public ImageIcon getImage(String url) {
        return cache.get(url);
    }

    public void addImage(String url, ImageIcon image) {
        cache.put(url, image);
    }
}