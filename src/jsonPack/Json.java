package jsonPack;

import Data.DataJson;

public class Json {
    DataJson data =  new DataJson();

    /**
     * <p>{@code read(int)}メソッドはJSONファイルを読み込むときにのみ使用が推奨されています。readは読むことができるのはもちろん、値の変更を行うことができます。
     * <p>一方で、値の変更を望まない場合には{@link jsonPack.Json#readOnly(int)}の使用を推奨しています。
     * <p>オーバーライドすることで使用できる権限を変更することができます。
     * @version 1.0.0
     * @param auth int型で指定し、数値は{@code 2}で指定できる。他の数値を含めることができない。詳しい数値の詳細は{@link Data.DataJson#authority(int, char)}から。
     * @throws IllegalArgumentException {@link Data.DataJson#authority(int, char)}の例外を参考
     * */
    public void read(int auth) {
        final char authChar = 'r';
        data.authority(auth, authChar);
    }
    /**
     * <p>{@code readOnly(int)}メソッドは値の変更を行わずに読み取りにのみ使用することができます。読み取りには{@link jsonPack.Json#read(int)}もありますが、値の変更を行えることができます。
     * <p>値の保守性を考える場合はこのメソッドを使うことを推奨します。
     * <p>オーバーライドは許可されていません。よって権限の変更は認められません。
     * @version 1.0.0
     * @param auth int型で指定し、数値は{@code 3}で指定できる。他の数値を含めることができない。詳しい数値の詳細は{@link Data.DataJson#authority(int, char)}から。
     * @throws IllegalArgumentException {@link Data.DataJson#authority(int, char)}の例外を参考
     * */
    public final void readOnly(int auth) {
        final char authChar = 'o';
        data.authority(auth,authChar);
    }
    /**
     * <p>{@code write(int)}メソッドは属性と値の両方を変更することができます。値を変更する目的であれば{@link jsonPack.Json#read(int)}を使用することを推奨します。
     * <p>オーバーライドすることで使用できる権限を変更することができます。
     * @version 1.0.0
     * @param auth int型で指定し、数値は{@code 1}で指定できる。他の数値を含めることができない。詳しい数値の詳細は{@link Data.DataJson#authority(int, char)}から。
     * @throws IllegalArgumentException {@link Data.DataJson#authority(int, char)}の例外を参考
     * */
    public void write(int  auth) {
        final char authChar = 'w';
        data.authority(auth, authChar);
    }
    /**
     * <p>{@code conversion(int)}メソッドはJSONからJava形式、JavaからJSON形式に変換する機能を持っています。また、属性や値の変更を行うことができます。
     * <p>属性や値の変更を行いたい場合には{@link jsonPack.Json#write(int)}を使用することを推奨しています。
     * <p>オーバーライドすることで使用できる権限を変更することができます。
     * @version 1.0.0
     * @param auth int型で指定し、数値は{@code 0}で指定できる。他の数値を含めることができない。詳しい数値の詳細は{@link Data.DataJson#authority(int, char)}から。
     * @throws IllegalArgumentException {@link Data.DataJson#authority(int, char)}の例外を参考
     * */
    public void conversion(int auth) {
        final char authChar = 'c';
        data.authority(auth, authChar);
    }

}
