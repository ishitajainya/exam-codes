package labTest.Q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Q1 {

    public static void main(String[] args) {

        ArrayList<Merchandise> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("labTest\\src\\labTest\\Q1\\input.dat"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\s+"); //spliiting the list with spaces

                String code = data[0];
                int quantity = Integer.parseInt(data[1]);
                double price = Double.parseDouble(data[2]);

                list.add(new Merchandise(code, quantity, price));
            }

        } catch (IOException e) {
            System.out.println(e);
        }

        // Sort by item Code (Ascending) - i am using custom comparator with the help of lamda expression
        Collections.sort(list,
                (m1, m2) -> m1.getItemCode().compareTo(m2.getItemCode()));

        System.out.println("Sorted by Item Code (asc):");
        for (Merchandise m : list) {
            System.out.println(m);
        }

        // Sort by price (Descending)
        Collections.sort(list,
                (m1, m2) -> Double.compare(m2.getUnitPrice(), m1.getUnitPrice()));

        System.out.println("Sorted by Price (desc):");
        for (Merchandise m : list) {
            System.out.println(m);
        }
    }
}
