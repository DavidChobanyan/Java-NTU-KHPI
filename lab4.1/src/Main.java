import java.io.*;
import java.util.Scanner;

class WorkShopTXT extends WorkShop {
    public WorkShopTXT(String name, String address, Time[] temp) {
        super(name, address, temp);
    }

    public void readFromFile(String fileName) throws FileNotFoundException {
        clearTime();
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            setName(scanner.nextLine());
            setAddress(scanner.nextLine());
            while (scanner.hasNext()) {
                int amount = scanner.nextInt();
                int shift = scanner.nextInt();
                addTime(new Time(amount, shift));
            }
        }
    }

    public void writeToFile(String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            try (PrintWriter out = new PrintWriter(fw)) {
                out.println(getName());
                out.print(getAddress());
                out.println();
                for (Time c : getArrayTime()) {
                    out.print(c.getAmount() + " " + c.getShift() + "\n");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void test() throws FileNotFoundException {
        this.sortmost();
        writeToFile("WorkShopTXT.txt");
        System.out.println("Written to txt file: ");
        System.out.println(this);
        System.out.println("Readed from txt file: ");
        readFromFile("WorkShopTXT.txt");
        System.out.println(this);
    }
}

public class Main {
    public static void main(String args[]) throws Exception {
        Time[] test = new Time[5];
        test[0] = new Time(23,  2);
        test[1] = new Time(23,  2);
        test[2] = new Time(8, 1);
        test[3] = new Time(9, 2);
        test[4] = new Time(16, 1);
        WorkShopTXT test2 = new WorkShopTXT("Yellw", "Kharkiv", test);
        test2.test();
        System.out.println("\n--------------------------------------------\n");
        WorkShopDat test3 = new WorkShopDat("Yellw", "Kharkiv", test);
        test3.test();
    }
}

class WorkShopDat extends WorkShop{
    public WorkShopDat(String name, String address, Time[] temp) {
        super(name, address, temp);
    }
    public void readFromFile(String filename) throws Exception {
        clearTime();
        try (DataInputStream input = new DataInputStream(
                new FileInputStream(filename))) {
            setName(input.readUTF());
            setAddress(input.readUTF());
            int count = input.readInt();
            for (int i = 0; i < count; i++) {
                int amount = input.readInt();
                int shift = input.readInt();
                addTime(new Time(amount, shift));
            }
        }
    }
    public void writeToFile(String filename) throws Exception {
        try(DataOutputStream output = new DataOutputStream(
                new FileOutputStream(filename))) {
            output.writeUTF(getName());
            output.writeUTF(getAddress());
            output.writeInt(getArrayTime().length);
            Time[] tmp = getArrayTime();
            for (int i = 0; i < getArrayTime().length; i++) {
                output.writeInt(tmp[i].getAmount());
                output.writeInt(tmp[i].getShift());
            }

        }
    }


    public void test() throws Exception {
        this.sortmost();
        writeToFile("WorkShopdat.dat");
        System.out.println("Written to dat file: ");
        System.out.println(this);
        Time[] test2 = new Time[2];
        test2[0] = new Time(2, 1);
        test2[1] = new Time(6, 1);
        readFromFile("WorkShopdat.dat");
        System.out.println("Readed from dat file: ");
        System.out.println(this);
    }
}
