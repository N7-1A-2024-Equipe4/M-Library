package utils.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageUtil {
    private static final ImageCache imageCache = new ImageCache();

    public static Image getScaledImage(Image srcImage, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(srcImage, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public static ImageIcon getImageFromUrl(String imageUrl) throws IOException {
        ImageIcon cachedImage = imageCache.getImage(imageUrl);
        if (cachedImage != null) {
            return cachedImage;
        }

        URL url = new URL(imageUrl);
        BufferedImage bufferedImage = ImageIO.read(url);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        imageCache.addImage(imageUrl, imageIcon);
        return imageIcon;
    }
}
