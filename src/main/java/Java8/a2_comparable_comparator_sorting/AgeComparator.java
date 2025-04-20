package Java8.a2_comparable_comparator_sorting;

import java.util.Comparator;

public class AgeComparator implements Comparator<ComparatorExample> {
    @Override
    public int compare(ComparatorExample p1, ComparatorExample p2) {
        return Integer.compare(p1.getAge(), p2.getAge()); // Sort by age
    }
}
