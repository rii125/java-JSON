package main;

import Data.DataJson;
import jsonPack.Json;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataJson jsonD = new DataJson();
        Json json = new Json();

        json.getPath(jsonD.readJson("src\\jsonTest\\test1.json", true));
        json.write(1);

        DataJson jsonD2 = new DataJson();
        Json json2 = new Json();

        json2.getPath(jsonD2.readJson("src\\jsonTest\\test2.json", true));
        json2.write(1);
    }
}
