package io.github.bluedreamteng.tfcommon;

import java.util.Collections;
import java.util.List;

/**
 * sql工具类
 */
public class SqlUtil {
    public static String in(List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder();
        result.append("'");
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
            if (i != list.size() - 1) {
                result.append(",");
            }
        }
        result.append("'");
        return result.toString();
    }

    public static String in(String arr) {
        List<String> list = Collections.singletonList(arr);
        return in(list);
    }


}
