package Data;

import java.io.*;

import static java.lang.System.out;

public class DataJson {
    /* ##### MEMO #####
     * seed : 属性名
     * type : 型（int, float, string）
     * value : 値（型チェックも行えるようにする）
     */

    String seed;
    final String[] type = {"int", "float", "string"};
    String value;

    String authority;
    final String[] authorityList = {"Customer", "Writer", "Reader", "ReaderOnly"};

    public DataJson() {
        authority = authorityList[2];
    }

    private static class JsonInstanceData extends RuntimeException {
        public JsonInstanceData(String m) {
            super(m);
        }
    }

    /**
     * <p>JSONファイルを読み書きするためには権限が必要になります。JSONをJava側で編集しようとしても権限によって制限がかけられるような仕様です。
     * <p>もし、権限を無視したい場合には直接編集するかオーバーライドが可能なメソッドを使用して変更することをお勧めします。
     * <p>デフォルトは、Readerとして設定されています。
     * @version 1.0.0
     * @param listNum authorityListの権限の番号を指しています。0: 管理者(Customer), 1: ライター(Writer), 2: 読者(Reader) ,3:観察者 (ReaderOnly)
     * @throws IllegalArgumentException 指定された数値は権限を付与することができませんでした。　指定しようとした数値: {@code listNum(authorityList[listNum])}
     * */
    public final void authority(int listNum, char auth) {
        switch (listNum) {
            case 0 -> {
                switch (auth) {
                    case 'r', 'o', 'w' -> { throw new JsonInstanceData("指定した数値は無効です。 指定した数値: " + listNum + "(" + authorityList[listNum] + ")"); }
                    case 'c' -> { out.println("Accuses!!"); }
                }
            }
            case 1 -> {
                switch (auth) {
                    case 'c', 'r', 'o' -> { throw new JsonInstanceData("指定した数値は無効です。 指定した数値: " + listNum + "(" + authorityList[listNum] + ")"); }
                    case 'w' -> { out.println("Accuses!!"); }
                }
            }
            case 2 -> {
                switch (auth) {
                    case 'c', 'w', 'o' -> { throw new JsonInstanceData("指定した数値は無効です。 指定した数値: " + listNum + "(" + authorityList[listNum] + ")"); }
                    case 'r' -> { out.println("Accuses!!"); }
                }
            }
            case 3 -> {
                switch (auth) {
                    case 'r', 'w', 'c' -> { throw new JsonInstanceData("指定した数値は無効です。 指定した数値: " + listNum + "(" + authorityList[listNum] + ")"); }
                    case 'o' -> { out.println("Accuses!!"); }
                }
            }
            default -> {
                throw  new IllegalArgumentException("指定された数値は権限を付与することができませんでした。　指定しようとした数値:" + listNum + "(" + authorityList[listNum] + ")");
            }
        }
    }

    /**
     * <p>このメソッドはファイルパスを指定して、JSONファイルを読み込みます。先に{@link Data.DataJson}をインスタンス化した後{@link jsonPack.Json}をインスタンス化して利用してください。
     * <pre>{@code
     * // 例
     * DataJson jsonD = new DataJson();
     * Json json = new Json();
     *
     * jsonD.readJson("src\\jsonData\\list.json");
     * }</pre>
     * @param path {@link java.io.File}のファイルパスの書き方にしたがって書いてください。{@code src}や{@code app}などメインフォルダよりも一段以下か同じところにJSONファイルをおいておくと認識しやすくなります。
     * <pre>{@code
     * /
     * src/
     * ├─ main.java
     * └─ data.json
     * }</pre>
     *
     * <pre>{@code
     * /
     * src/
     * └─ main.java
     * data/
     * └─ data.json
     * }</pre>
     * @version 1.0.0
     * */
    public void readJson(String path) throws InterruptedException {
        File file = new File(path);
        out.println("読み込み中...\n");
        Thread.sleep(1000);
        out.println("| " + path + " |");
        out.println("=========================================================");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Thread.sleep(1500);
            out.println("ファイルが見つかりません: " + file.getAbsolutePath());
        }
    }

    public void readJson(String path, boolean display) throws InterruptedException {
        File file = new File(path);
        out.println("読み込み中...\n");
        Thread.sleep(1000);
        if (display) {
            out.println("| " + path + " |");
            out.println("=========================================================");
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Thread.sleep(1500);
                out.println("ファイルが見つかりません: " + file.getAbsolutePath());
            }
        } else {
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    out.println(path + "の読み込み完了");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Thread.sleep(1500);
                out.println("ファイルが見つかりません: " + file.getAbsolutePath());
            }
        }
    }

    boolean check = false;
    public boolean isCheck() {
        return this.check = true;
    }
}