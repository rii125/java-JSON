package main;

import Data.DataJson;
import jsonPack.Json;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        DataJson jsonD = new DataJson();
//        jsonD.readJson("src\\jsonTest\\test.json", true);

        Json json = new Json();
        json.conversion(0);
        json.write(1);
        json.read(2);
        json.readOnly(3);
    }
}
