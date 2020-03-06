package com.zed;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Zeluo
 * @date 2019/9/23 9:56
 */


public class Reg {

    private static final String filePath = "D:\\workspace-commons\\log_api.log";

    public static void main(String args[]) {

        File file = new File(filePath);
        Long filelength = file.length(); // 获取文件长度
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = new String(filecontent);

        String str = "dccca52f-72c1-40c2-9cac-64ad11c3d91d";
        String requestId = "\\w*-\\w*-\\w*-\\w*-\\w*";
        String arg = "arg\\[\\w+\\]: \\\".*\\\"";
        String response = "\\{[\\w\\W]*?\\}";

        Pattern r = Pattern.compile(requestId);
        Pattern a = Pattern.compile(arg);
        Pattern res = Pattern.compile(response);

        Matcher m = r.matcher(content);
        Matcher matcher_a = a.matcher(content);
        Matcher matcher_res = res.matcher(content);
//            System.out.println(m.matches());
        while (m.find()) {
            System.out.println(m.group());
        }

//        while (matcher_a.find()) {
//            System.out.println(matcher_a.group());
//        }

        while (matcher_res.find()) {
            System.out.println(matcher_res.group());
        }

//            System.out.println(matcher_a.group());
//            System.out.println(matcher_res.group());

    }

}