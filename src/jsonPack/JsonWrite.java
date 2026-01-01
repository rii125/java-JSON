package jsonPack;

import java.io.File;
import static java.lang.System.out;

public class JsonWrite {
    File file;
    public void getPath(String path){
        if (path != null) {
            file = new File(path);
            out.println("Path: " + path + "\n");
        } else {
            out.println("Null!!");
        }
    }
}
