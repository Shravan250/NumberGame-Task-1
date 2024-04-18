
package number.game;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FontManager {
    private static final Map<String, String> fontPaths = new HashMap<>();

    static {
        // Load and register fonts in the static block
        fontPaths.put("PetitCochon", "E:\\Java\\Number Game\\src\\Fonts\\PetitCochon.ttf");
        fontPaths.put("Mansalva", "E:\\Java\\Number Game\\src\\Fonts\\Mansalva-Regular.ttf");
        fontPaths.put("OvertheRainbow", "E:\\Java\\Number Game\\src\\Fonts\\OvertheRainbow-Regular.ttf");
        // Add more fonts as needed
    }


    public static Font getFont(String fontName, int style, float size) {
        String fontPath = fontPaths.get(fontName);
        if (fontPath == null) {
            throw new IllegalArgumentException("Font not found: " + fontName);
        }

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(style, size);
            return font;
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null; // Return null or handle the exception as needed
        }
    }
}
