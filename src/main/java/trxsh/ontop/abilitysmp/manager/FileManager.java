package trxsh.ontop.abilitysmp.manager;

import trxsh.ontop.abilitysmp.util.DropUtility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileManager {

    public static File drops = new File("drops.mgr");
    public static String separator = System.getProperty("line.separator");

    public static void writeDrops() throws IOException {

        FileWriter writer = new FileWriter(drops);

        StringBuilder b = new StringBuilder();

        b.append(DropUtility.drops[0] + separator);
        b.append(DropUtility.drops[1] + separator);
        b.append(DropUtility.drops[2] + separator);

        writer.write(b.toString());

        writer.close();

    }

    public static void readDrops() throws IOException {

        List<String> lines = Files.readAllLines(drops.toPath());

        if(lines.size() == 0)
            return;

        DropUtility.drops[0] = Boolean.parseBoolean(lines.get(0));
        DropUtility.drops[1] = Boolean.parseBoolean(lines.get(1));
        DropUtility.drops[2] = Boolean.parseBoolean(lines.get(2));

    }

    public static boolean fileExists() {

        return drops.exists();

    }

}
