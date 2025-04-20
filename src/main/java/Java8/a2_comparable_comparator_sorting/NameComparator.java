package Java8.a2_comparable_comparator_sorting;

import java.util.Comparator;

public class NameComparator implements Comparator<ComparatorExample> {
    @Override
    public int compare(ComparatorExample p1, ComparatorExample p2) {
        return p1.getName().compareTo(p2.getName()); // Sort by name
    }
}
