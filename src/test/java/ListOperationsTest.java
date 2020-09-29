import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author <a href='mailto:sabrinee.ayachi@gmail.com">Sabrine Ayachi</a>
 *
 * @since 28 sept. 2020
 */
public class ListOperationsTest {

    /**
     * Test method for ListOperations.partition(List, int)
     */
    @Test
    public void testListOperations() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListOperations<Integer> l1 = new ListOperations<Integer>(list,1);
        Collection<List<Integer>> listOne = l1.partition();
        verifyListOne(listOne);

        ListOperations<Integer> l2 = new ListOperations<Integer>(list,2);
        Collection<List<Integer>> listTwo = l2.partition();
        verifyListTwo(listTwo);

        ListOperations<Integer> l3 = new ListOperations<Integer>(list,3);
        Collection<List<Integer>> listThree = l3.partition();
        verifyListThree(listThree);

        //test for empty list
        List<Integer>list1 = new ArrayList<Integer>();
        ListOperations<Integer> listFoor = new ListOperations<Integer>(list1,1);
        Assert.assertTrue(listFoor.isEmpty());
    }

    public static void verifyListOne(Collection<List<Integer>> listOne) {
        List<Object> subList1 = new ArrayList<Object>();
        subList1.add(1);
        Assert.assertEquals(new ArrayList<>(listOne).get(0), subList1);

        List<Object> subList2 = new ArrayList<Object>();
        subList2.add(2);
        Assert.assertEquals(new ArrayList<>(listOne).get(1), subList2);

        List<Object> subList3 = new ArrayList<Object>();
        subList3.add(3);
        Assert.assertEquals(new ArrayList<>(listOne).get(2), subList3);

        List<Object> subList4 = new ArrayList<Object>();
        subList4.add(4);
        Assert.assertEquals(new ArrayList<>(listOne).get(3), subList4);

        List<Object> subList5 = new ArrayList<Object>();
        subList5.add(5);
        Assert.assertEquals(new ArrayList<>(listOne).get(4), subList5);
    }

    public static void verifyListTwo(Collection<List<Integer>> listTwo) {
        List<Object> subList1 = new ArrayList<Object>();
        subList1.add(1);
        subList1.add(2);
        Assert.assertEquals(new ArrayList<>(listTwo).get(0), subList1);

        List<Object> subList2 = new ArrayList<Object>();
        subList2.add(3);
        subList2.add(4);
        Assert.assertEquals(new ArrayList<>(listTwo).get(1), subList2);

        List<Object> subList3 = new ArrayList<Object>();
        subList3.add(5);
        Assert.assertEquals(new ArrayList<>(listTwo).get(2), subList3);
    }

    public static void verifyListThree(Collection<List<Integer>> listThree) {
        List<Object> subList1 = new ArrayList<Object>();
        subList1.add(1);
        subList1.add(2);
        subList1.add(3);
        Assert.assertEquals(new ArrayList<>(listThree).get(0), subList1);

        List<Object> subList2 = new ArrayList<Object>();
        subList2.add(4);
        subList2.add(5);
        Assert.assertEquals(new ArrayList<>(listThree).get(1), subList2);
    }
}
