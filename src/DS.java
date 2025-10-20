
public class DS {
    public static void main(String[] args) throws Exception {
        // Array1D array1d = new Array1D(6);
        // array1d.add(4);
        // array1d.add(3);

        // array1d.add(4);
        // array1d.add(4);
        // array1d.add(9);
        // array1d.add(4);

        // array1d.deleteAllSkipFirst(4.0);
        // array1d.print();
        double[][] testArrays = {
                { 12, 45, 67, 12, 9, 45, 33, 45, 45 },
                { 88, 77, 23, 23, 14, 56, 88, 92, 1 },
                { 3, 3, 9, 12, 99, 99, 4, 25, 19 },
                { 50, 60, 70, 80, 90, 90, 100, 50, 40 },
                { 7, 14, 21, 28, 35, 42, 7, 14, 49 },
                { 99, 98, 97, 96, 95, 94, 93, 92, 91 },
                { 10, 20, 10, 30, 40, 50, 20, 60, 70 },
                { 1, 1, 1, 1, 2, 2, 3, 3, 3 },
                { 45, 12, 89, 45, 32, 56, 89, 12, 78 },
                { 5, 10, 15, 20, 25, 30, 35, 40, 45 }
        };

        // Array2D array2d = new Array2D(3, 3);
        // array2d.addAll(testArrays[0]);
        // array2d.deleteAndConvert(45);
        // array2d.print();

        // StackArray stackArray = new StackArray(5);
        Array1D array1d = new Array1D(9);
        array1d.addAll(testArrays[0]);
        array1d.deleteJump(45);
        array1d.print();
        // array1d.deleteAll(3);
        // array1d.print();
        // stackArray.push(4);
        // stackArray.push(3);
        // stackArray.push(5);
        // stackArray.push(4);
        // stackArray.push(3);
        // stackArray.push(5);

        // System.out.println(stackArray.print());

        // حذف مع التكرار للثتائية والاحدية
        // حذف عنصر من المصفوفة الثنائية وإزاحة العنصر المحذوف إلى اخر العنصر عن طريق
        // التحويل أو ناشف
        //
    }
}
