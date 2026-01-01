package main;

import Data.DataJson;
import jsonPack.Json;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataJson jsonD = new DataJson();
        Json json = new Json();

        jsonD.readJson("src\\jsonTest\\test.json");

        json.conversion(0);
        json.write(1);
        json.read(2);
        json.readOnly(3);
    }
}
