package solution;

import java.io.File;

/**
 * @author Zeluo
 * @date 2019/9/18 16:50
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.io.tmpdir") + "/xd/ftp");

        File localDir = new File(System.getProperty("java.io.tmpdir") + "/xd/ftp");
        System.out.println(localDir.getName());
        System.out.println(localDir.getPath());
    }
}
