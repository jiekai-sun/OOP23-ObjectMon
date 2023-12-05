package it.unibo.objectmon.model.environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class MapBuilder {
    public static List<List<Tile>> buildMap(final String pathname) {
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(pathname);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
