package twoarraysmedian;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Storage arr = new DoubleArray(nums1, nums2);
        quickSort(arr, 0, arr.size() - 1);
        if (arr.size() % 2 == 1) {
            return arr.get(arr.size() / 2);
        }
        return (double) (arr.get(arr.size() / 2) + arr.get(arr.size() / 2 - 1)) / 2;
    }

    public void quickSort(Storage arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(Storage arr, int begin, int end) {
        int pivot = arr.get(end);
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                int swapTemp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, swapTemp);
            }
        }
        int swapTemp = arr.get(i + 1);
        arr.set(i + 1, arr.get(end));
        arr.set(end, swapTemp);
        return i + 1;
    }

    private static final class DoubleArray implements Storage {
        private final int[] a;
        private final int[] b;
        private final int size;

        public DoubleArray(int[] a, int[] b) {
            this.a = a;
            this.b = b;
            size = a.length + b.length;
        }

        @Override
        public int get(int i) {
            assert 0 <= i;
            assert i < size;
            if (i >= a.length) {
                return b[i - a.length];
            }
            return a[i];
        }

        @Override
        public void set(int i, int val) {
            assert 0 <= i;
            assert i < size;
            if (i >= a.length) {
                b[i - a.length] = val;
                return;
            }
            a[i] = val;
        }

        @Override
        public int size() {
            return size;
        }
    }

    private interface Storage {
        int get(int i);

        void set(int i, int val);

        int size();
    }
}
