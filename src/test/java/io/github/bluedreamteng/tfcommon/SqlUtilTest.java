package io.github.bluedreamteng.tfcommon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SqlUtilTest {
    @Test
    public void in_ListIsNull_throwIllegalArgumentException() {
        final List<String> list = null;
        assertThrows(IllegalArgumentException.class, () -> SqlUtil.in(list));
    }

    @Test
    public void in_ListIsEmpty_returnEmptyString() {
        final List<String> list = new ArrayList<>();
        String expectResult = "''";

        String actualResult = SqlUtil.in(list);

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void in_ListHasOneElement_returnString() {
        final List<String> list = new ArrayList<>();
        list.add("a");
        String expectResult = "'a'";

        String actualResult = SqlUtil.in(list);

        assertEquals(expectResult,actualResult);
    }

    @Test
    public void in_ListHasTwoElement_returnString() {
        final List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        String expectResult = "'a,b'";

        String actualResult = SqlUtil.in(list);

        assertEquals(expectResult,actualResult);
    }

}