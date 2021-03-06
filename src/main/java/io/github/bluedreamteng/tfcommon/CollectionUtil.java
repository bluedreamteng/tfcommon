package io.github.bluedreamteng.tfcommon;

import java.util.*;

/**
 * 集合工具类
 */
public class CollectionUtil {
    public static<T> List<List<T>> splitList(List<T> list, int unit) {
        if (list == null) {
            throw new IllegalArgumentException();
        }
        if (unit < 1) {
            throw new IllegalArgumentException();
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        List<List<T>> result = new ArrayList<>();
        Queue<T> stack = new LinkedList<>(list);
        int groups = (int) Math.ceil((list.size() * 1.0) / (unit * 1.0));
        for (int i = 0; i < groups; i++) {
            List<T> eachGroup = new ArrayList<>();
            //last group
            if (i == groups - 1) {
                eachGroup.addAll(stack);
            }
            else {
                for (int j = 0; j < unit; j++) {
                    eachGroup.add(stack.remove());
                }
            }
            result.add(eachGroup);
        }
        return result;
    }
}
