package io.github.bluedreamteng.tfcommon;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CollectionUtilTest {

    @Test
    public void splitList_ListIsNull_throwIllegalArgumentException() {
        final List<String> list = null;
        final int unit = 1;

       assertThrows(IllegalArgumentException.class, () -> CollectionUtil.splitList(list,unit));
    }

    @Test
    public void splitList_unitLessThanOne_throwIllegalArgumentException(){
        final List<String> list = new ArrayList<>();
        final int unit = 0;

        assertThrows(IllegalArgumentException.class, new ThrowingRunnable() {
            public void run() {
                CollectionUtil.splitList(list,unit);
            }
        });
    }

    @Test
    public void splitList_ListIsEmpty_ReturnEmpty() {
        List<String> list = new ArrayList<>();
        List<List<String>> expectedList = new ArrayList<>();

        List<List<String>> actualList = CollectionUtil.splitList(list, 1);

        assertEquals(expectedList,actualList);
    }


    @Test
    public void splitList_ListWithFiveElementsAndUnitIsThree_returnTwoGroups() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        int unit = 3;

        List<List<String>> expectedList = new ArrayList<>();
        List<String> oneGroup = new ArrayList<>();
        oneGroup.add("1");
        oneGroup.add("2");
        oneGroup.add("3");
        expectedList.add(oneGroup);
        List<String> twoGroup = new ArrayList<>();
        twoGroup.add("4");
        twoGroup.add("5");
        expectedList.add(twoGroup);

        List<List<String>> actualList = CollectionUtil.splitList(list, unit);

        assertEquals(expectedList,actualList);

    }

}