package com.zed;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Zeluo
 * @date 2019/9/23 11:36
 */
public class RegLine {
    private static final String FILEPATH = "D:\\workspace-commons\\log_api.log";

    public static void main(String[] args) throws IOException
    {
        int lineCount = -1;
        long start = System.currentTimeMillis();
        String requestId = "\\w*-\\w*-\\w*-\\w*-\\w*";
        String requestArg = "arg\\[[0-9]*\\]:\\s.*";
//        String requestArg_num = "arg\\[[0-9]*\\]:\\s[0-9]{1,}";//request arg 后面是数字的
//        String requestArg_json = "arg\\[[0-9]*\\]:\\s\\\".*?\\\"";//request arg 后面是json格式的
//        String requestArg_json_object = "arg\\[[0-9]*\\]:\\s\\{.*\\}";//request arg 后面是json对象格式
//        String requestArg_null = "arg\\[[0-9]*\\]:\\snull";//request arg 后面是null的
        String responseArg = "response params: \\{.*\\}";//response params 后面是json对象格式

        Pattern pattern_requestId = Pattern.compile(requestId);
//        Pattern pattern_requestArg_num = Pattern.compile(requestArg_num);
//        Pattern pattern_requestArg_json = Pattern.compile(requestArg_json);
//        Pattern pattern_requestArg_json_object = Pattern.compile(requestArg_json_object);
//        Pattern pattern_requestArg_null = Pattern.compile(requestArg_null);
        Pattern pattern_responseArg = Pattern.compile(responseArg);
        Pattern pattern_requestArg = Pattern.compile(requestArg);

        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream(FILEPATH);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while((str = bufferedReader.readLine()) != null)
        {
            lineCount++;
            Matcher matcher_requestId = pattern_requestId.matcher(str);
//            Matcher matcher_requestArg_num = pattern_requestArg_num.matcher(str);
//            Matcher matcher_requestArg_json = pattern_requestArg_json.matcher(str);
//            Matcher matcher_requestArg_json_object = pattern_requestArg_json_object.matcher(str);
//            Matcher matcher_requestArg_null = pattern_requestArg_null.matcher(str);
            Matcher matcher_responseArg = pattern_responseArg.matcher(str);

            Matcher matcher_requestArg = pattern_requestArg.matcher(str);

            if (matcher_requestId.find())
                System.out.println("requestId: " + matcher_requestId.group());
            if ((lineCount &1) == 0 && matcher_requestArg.find()) {
                String target_str_request = matcher_requestArg.group();
                int end = target_str_request.indexOf("access");
                String substring = target_str_request.substring(0, end);
                System.out.println("request params: " + substring);
            }
//            if (matcher_requestArg.find())
//                System.out.println("request params: " + matcher_requestArg.group());
            else if (matcher_responseArg.find())
                System.out.println(matcher_responseArg.group());

//            while (matcher_requestArg_json.find())
//                System.out.println("request args: " + matcher_requestArg_json.group());
//            while (matcher_requestArg_json_object.find())
//                System.out.println("request args: " + matcher_requestArg_json_object.group());
//            while (
////                    !matcher_requestArg_json_object.find() &&
////                            !matcher_requestArg_json.find() &&
//                            matcher_requestArg_num.find()
//                )
//                System.out.println("request args: " + matcher_requestArg_num.group());
//            while (matcher_requestArg_null.find())
//                System.out.println("request args: " + matcher_requestArg_null.group());

        }

        //close
        inputStream.close();
        bufferedReader.close();
        System.out.println(start - System.currentTimeMillis());
    }
}
