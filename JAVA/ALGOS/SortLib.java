// SortLib.java
import java.util.Arrays;;
import java.util.ArrayList;

class SortLib {

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> l, int first_index, int last_index) {

        ArrayList<Integer> sl = new ArrayList<Integer>();

        // int mid_index = (int)(l.size()/2);
        int mid_index = (int)((first_index + last_index)/2);

        if (first_index < mid_index) {
            mergeSort(l, first_index, mid_index);
        }
        
        if (mid_index+1 < last_index) {
            mergeSort(l, mid_index+1, last_index);
        }

        int index_a = first_index;
        int index_b = mid_index+1;
        int vl1, vl2, sv;

        while ((index_a <= mid_index) && (index_b <= last_index)) {
            vl1 = l.get(index_a);
            vl2 = l.get(index_b);

            if (vl1 <= vl2) {
                sl.add(vl1);
                index_a++;
            }
            else {
                sl.add(vl2);
                index_b++;
            }
        }

        while (index_a <= mid_index) {
            vl1 = l.get(index_a);
            sl.add(vl1);
            index_a++;
        }

        while (index_b <= last_index) {
            vl2 = l.get(index_b);
            sl.add(vl2);
            index_b++;
        }

        int l_index = first_index;
        int sl_index = 0;

        while (l_index <= last_index) {
            sv = sl.get(sl_index);
            l.set(l_index, sv);
            l_index++;
            sl_index++;
        }

        return l;
    }

    ///////////////////////////////////////////////

    public static void main( String[] args ) {

        ArrayList<Integer> ul = new ArrayList<Integer>(
            Arrays.asList(321, -23, 543, 8, -546, 890, 8, 21398, 1, 987, 2) );

        System.out.format("Initial array(list) is %s\n", ul.toString());

        int first_index = 0;
        int last_index = ul.size()-1;
        ArrayList<Integer> sorted_list = mergeSort(ul, first_index, last_index);

        System.out.format("Finale array(list) is %s\n", ul.toString());


    }
}
