package com.khch.androidscreen.utils;

import com.khch.androidscreen.entity.Pixel;
import com.khch.androidscreen.entity.PixelCollection;
import com.khch.androidscreen.entity.StandardPixel;
import com.khch.androidscreen.main.AndroidScreenMain;
import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class PixelConfigurationUtils {
    private static String sStandardPixelStr;
    private static List<String> sPixelStrList;

    public static PixelCollection readConfiguration() {
        Digester digester = new Digester();

        digester.setValidating(false);

        digester.addObjectCreate("pixelcollection", "com.khch.androidscreen.entity.PixelCollection");
        digester.addSetProperties("pixelcollection");

        digester.addObjectCreate("pixelcollection/standardpixel", "com.khch.androidscreen.entity.StandardPixel");
        digester.addSetProperties("pixelcollection/standardpixel");
        digester.addSetNext("pixelcollection/standardpixel", "addStandardPixel", "com.khch.androidscreen.entity.StandardPixel");

        digester.addObjectCreate("pixelcollection/pixel", "com.khch.androidscreen.entity.Pixel");
        digester.addSetProperties("pixelcollection/pixel");
        digester.addSetNext("pixelcollection/pixel", "addPixel", "com.khch.androidscreen.entity.Pixel");

        PixelCollection pixelCollection = null;
        try {
            pixelCollection = (PixelCollection) digester.parse(AndroidScreenMain.class.getClassLoader().getResourceAsStream("configuration.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        for (StandardPixel standardPixel : pixelCollection.getStandardPixelList()) {
            System.out.println(standardPixel.getValue());
        }

        for (Pixel pixel : pixelCollection.getPixelList()) {
            System.out.println(pixel.getValue());
        }

        return pixelCollection;
    }

    private static void setStandardPixel(String standardPixel) {
        sStandardPixelStr = standardPixel;
    }

    public static void setPixelStrList(List<String> pixelStrList) {
        sPixelStrList = pixelStrList;
    }

    public static String getStandardPixelStr() {
        return sStandardPixelStr;
    }

    public static List<String> getPixelStrList() {
        return sPixelStrList;
    }
}
