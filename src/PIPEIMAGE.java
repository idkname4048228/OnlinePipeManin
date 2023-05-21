import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public enum PIPEIMAGE {
    STRAIGHT_PIPE(new ImageIcon("src/img/pipeImage/straightPipe.png")),
    STRAIGHT_PIPE_WITH_WATER(new ImageIcon("src/img/pipeImage/straightPipeWithWater.png")),
    BENT_PIPE(new ImageIcon("src/img/pipeImage/bentPipe.png")),
    BENT_PIPE_WITH_WATER(new ImageIcon("src/img/pipeImage/bentPipeWithWater.png")),
    T_PIPE(new ImageIcon("src/img/pipeImage/tPipe.png")),
    T_PIPE_WITH_WATER(new ImageIcon("src/img/pipeImage/tPipeWithWater.png")),
    CROSS_PIPE(new ImageIcon("src/img/pipeImage/crossPipe.png")),
    CROSS_PIPE_WITH_ONE_WATER(new ImageIcon("src/img/pipeImage/crossPipeWithOneWater.png")),
    CROSS_PIPE_WITH_TWO_WATER(new ImageIcon("src/img/pipeImage/crossPipeWithTwoWater.png")),
    UP_IN_WATER_STORE(new ImageIcon("src/img/pipeImage/upInWaterStore.png")),
    RIGHT_IN_WATER_STORE(new ImageIcon("src/img/pipeImage/rightInWaterStore.png")),
    DOWN_IN_WATER_STORE(new ImageIcon("src/img/pipeImage/downInWaterStore.png")),
    LEFT_IN_WATER_STORE(new ImageIcon("src/img/pipeImage/leftInWaterStore.png")),
    UP_IN_WATER_STORE_WITH_WATER(new ImageIcon("src/img/pipeImage/upInWaterStoreWithWater.png")),
    RIGHT_IN_WATER_STORE_WITH_WATER(new ImageIcon("src/img/pipeImage/rightInWaterStoreWithWater.png")),
    DOWN_IN_WATER_STORE_WITH_WATER(new ImageIcon("src/img/pipeImage/downInWaterStoreWithWater.png")),
    LEFT_IN_WATER_STORE_WITH_WATER(new ImageIcon("src/img/pipeImage/leftInWaterStoreWithWater.png"));

    private ImageIcon image;

    private PIPEIMAGE(ImageIcon image) {
        this.image = image;
    }

    public ImageIcon getImage(int angle, int width, int height) {
        return scaledIcon(rotateIcon(this.image, angle), width, height);
    }

    private ImageIcon rotateIcon(ImageIcon icon, int angle) {// 旋轉圖片直到特定角度
        // 創建一個 BufferedImage 來儲存旋轉後的圖像
        BufferedImage rotatedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);

        // 創建一個 Graphics2D 對象，用於繪製旋轉後的圖像
        Graphics2D g2d = rotatedImage.createGraphics();

        // 設置繪圖質量，以達到更好的旋轉效果
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        // 計算旋轉的中心點
        int centerX = icon.getIconWidth() / 2;
        int centerY = icon.getIconHeight() / 2;

        // 創建一個 AffineTransform 對象，用於旋轉圖像
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(angle), centerX, centerY);

        // 繪製旋轉後的圖像
        g2d.drawImage(icon.getImage(), transform, null);
        g2d.dispose();

        // 返回旋轉後的 ImageIcon
        return new ImageIcon(rotatedImage);
    }

    private ImageIcon scaledIcon(ImageIcon icon, int width, int height) {// 縮放圖片直到特定大小
        // 從ImageIcon對象中獲取原始圖像
        Image img = icon.getImage();

        // 創建一個具有所需尺寸的新圖像
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // 創建一個新的ImageIcon對象，使用新的圖像作為參數
        return new ImageIcon(newImg);
    }
}