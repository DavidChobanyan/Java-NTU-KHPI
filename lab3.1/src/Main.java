import java.util.*;

class Time implements Comparable<Time>{
    private int amount;
    private int shift;

    public Time(int amount, int shift) {
        if(amount >= 0) {
            this.amount = amount;
            if(shift == 2 || shift == 1)
                this.shift = shift;
        }
    }
    /**
     * Повертає кількість відремонтованих компьютерів
     * @return кількість відремонтованих компьютерів у вігляді цілого значення
     */
    public int getAmount(){
        return this.amount;
    }
    /**
     * Встановлює нову кількість відремонтованих компьютерів
     * @param amount нова кількість відремонтованих компьютерів у вігляді цілого значення
     */
    public void setAmount(int amount){
        this.amount = amount;
    }
    /**
     * Повертає зміну
     * @return зміну у вигляді числа
     */
    public int getShift(){
        return this.shift;
    }
    /**
     * Встановлює нову зміну
     * @param shift нову зміну
     */
    public void setShift(int shift){
        this.shift = shift;
    }
    /**
     * Перевіряє еквівалетність із обьєктом
     * @param compare об'єкт із яким перевіряємо
     * @return результат перевірки у вігляді boolean змінної
     */
    public boolean equals(Object compare) {
        if(this.getClass() != compare.getClass())
            return false;
        Time compare2 = (Time) compare;
        return this.amount == compare2.amount && this.shift == compare2.shift;
    }
    /**
     * Повертає хеш-код змінної
     * @return хеш-код змінної у вігляді цілого значення
     */
    public int hashCode() {
        return amount*shift;
    }

    @Override
    public String toString() {
        return "amount= " + amount
                + ", shift= " + shift;
    }

    @Override
    public int compareTo(Time c) {
        return -1 * Integer.compare(getAmount(), c.getAmount());
    }
}

/**
 * Клас відповідає за майстерню.
 * Його представлено ім'ям та адресою
 */
abstract class AbstractWorkShop {
    private String name;
    private String address;
    /**
     * Конструктор ініціалізує об'єкт вказаними значеннями
     * @param name ім'я майстерні
     * @param address адреса майстерні
     */
    public AbstractWorkShop(String name, String address) {
        this.name = name;
        this.address = address;
    }
    /**
     * Повертає ім'я майстерні
     * @return ім'я у вигляді строки
     */
    public String getName(){
        return this.name;
    }
    /**
     * Встановлює нове ім'я майстерні
     * @param name ім'я майстерні
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Повертає адресу майстерні
     * @return адресу у вигляді строки
     */
    public String getAddress(){
        return this.address;
    }
    /**
     * Встановлює нову адресу майстерні
     * @param address адреса майстерні
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * Повертає загальну кількість відремонтованих компьтерів
     * @return загальну кількість відремонтованих компьтерів у вигляді цілого значення більшого за 0
     */
    public abstract int all();
    /**
     * Повертає массив змін
     * @return массив змін у вигляді одновимірного масиву
     */
    public abstract Time[] getArrayTime();
    /**
     * Встановлює новий массив змін
     * @param temp массив змін у вигляді одновимірного масиву
     */
    public abstract void setArrayTime(Time[] temp);
    /**
     * Повертає зміну з найбільшою кількістю відремонтованих компьютерів
     * @return зміну з найбільшою кількістю відремонтованих компьютерів у вигляді змінної time
     */
    public abstract Time most();
    /**
     * Повертає длину адреси
     * @return Повертає длину адреси у вигляді числа
     */
    public abstract int addressLenght();

    /**
     * Сортування за збільшенням кількості відремонтованих компьтерів методом бульбашки
     * @return массив time відсортований за збільшенням кількості відремонтованих компьтерів методом бульбашки
     */
    public Time[] sortmost(){
        Time[] tem = getArrayTime();
        for(int a = 0; a < tem.length; a++){
            boolean swap = false;
            for(int b = 0; b < tem.length-1; b++){
                if(tem[b].getAmount() > tem[b+1].getAmount()){
                    int t = tem[b].getAmount();
                    tem[b].setAmount(tem[b+1].getAmount());
                    tem[b+1].setAmount(t);
                    swap = true;
                }
            }
            if(!swap)
                break;
        }
        return tem;
    }

    /**
     * Сортування за змінами
     * @return массив time відсортований за змінами методом входження
     */
    public Time[] sortShift(){
        Time[] tem = getArrayTime();
        for(int a = 0; a < tem.length; a++){
            boolean swap = false;
            for(int b = 0; b < tem.length-1; b++){
                if(tem[b].getShift() > tem[b+1].getShift()){
                    int t = tem[b].getShift();
                    tem[b].setShift(tem[b+1].getShift());
                    tem[b+1].setShift(t);
                    swap = true;
                }
            }
            if(!swap)
                break;
        }
        return tem;
    }
    /**
     * Вивід даних про майстерню у строку
     * @return строку даних про майстерня
     */
    public String toString() {
        Time[] tem = getArrayTime();
        StringBuilder result = new StringBuilder("Name: " + getName() + ";" + " Adress: " + getAddress() + ";\n");
        for (int i = 0; i < tem.length; i++) {
            result.append(tem[i]);
            result.append('\n');
        }
        return result+"";
    }
    /**
     * Перевіряє еквівалетність із обьєктом
     * @param compare об'єкт із яким перевіряємо
     * @return результат перевірки у вігляді boolean змінної
     */
    public boolean equals(Object compare) {
        if (compare == null || getClass() != compare.getClass())
            return false;
        WorkShop check = (WorkShop) compare;
        return check.getName() == name && check.getAddress() == address && getArrayTime().equals(check.getArrayTime());
    }
    /**
     * Повертає хеш-код змінної
     * @return хеш-код змінної у вігляді цілого значення
     */
    @Override
    public int hashCode() {
        return getAddress().hashCode() * getName().hashCode() * java.util.Arrays.hashCode(getArrayTime());
    }

}

/**
 * Клас що представляє майстерня.
 * Дані про зміни представлені массивом
 */
class WorkShop extends AbstractWorkShop {
    private Time[] temp;
    /**
     * Конструктор ініціалізує об'єкт вказаними значеннями
     * @param name ім'я майстерні
     * @param address адреса майстерні
     * @param temp массив змін
     */
    public WorkShop(String name, String address, Time[] temp) {
        super(name, address);
        this.temp = temp;
    }
    /**
     * Повертає массив змін
     * @return массив змін у вигляді массиву
     */
    public Time[] getArrayTime(){
        return temp;
    }
    /**
     * Встановлює новий массив змін
     * @param temp новий массив змін
     */
    public void setArrayTime(Time[] temp){
        this.temp = temp;
    }
    /**
     * Повертає загальну кількість відремонтованих компьтерів
     * @return загальну кількість відремонтованих компьтерів у вигляді цілого значення більшого за 0
     */
    public int all(){
        int all = 0;
        for(int a = 0; a < temp.length; a++){
            all+=temp[a].getAmount();
        }
        return all;
    }
    /**
     * Повертає зміну з найбільшою кількістю відремонтованих компьютерів
     * @return зміну з найбільшою кількістю відремонтованих компьютерів у вигляді змінної time
     */
    public Time most(){
        int less = 0;
        for(int a = 1; a < temp.length; a++){
            if(temp[less].getAmount() < temp[a].getAmount())
                less = a;
        }
        return temp[less];
    }
    /**
     * Сортування за зменшенням кількості відремонтованих компьтерів методом бульбашки
     * @return массив time відсортований за зменшенням кількості відремонтованих компьтерів методом бульбашки
     */
    public int addressLenght(){
        return this.getAddress().length();
    }

}

class WorkShopArrList extends AbstractWorkShop{
    private ArrayList<Time> temp;

    public WorkShopArrList(String name, String address, ArrayList<Time> temp){
        super(name, address);
        this.temp = temp;
    }

    public void addTime(int amount, int shift){
        temp.add(new Time(amount, shift));
    }
    public int count(){
        return temp.size();
    }
    public int getAmount(int i){
        return temp.get(i).getAmount();
    }
    public int getShift(int i){
        return temp.get(i).getShift();
    }

    public void setAmount(int i, int amount){
        temp.get(i).setAmount(amount);
    }
    public void setShift(int i, int numVis){
        temp.get(i).setShift(numVis);
    }
    public Time[] getArrayTime(){
        Time[] tmp = new Time[temp.size()];
        for(int a = 0; a < temp.size(); a++){
            tmp[a] = new Time(temp.get(a).getAmount(), temp.get(a).getShift());
        }
        return tmp;
    }

    public void setArrayTime(Time[] tmp){
        temp = new ArrayList<>();
        for(int a = 0; a < tmp.length; a++)
            temp.add(tmp[a]);
    }

    public int all(){
        int all = 0;
        for(int a = 0; a < temp.size(); a++){
            all+=temp.get(a).getAmount();
        }
        return all;
    }

    public Time most(){
        int less = 0;
        for(int a = 1; a < temp.size(); a++){
            if(temp.get(less).getAmount() < temp.get(a).getAmount())
                less = a;
        }
        return temp.get(less);
    }

    public int addressLenght(){
        return this.getAddress().length();
    }

    public void sort(){
        Comparator<Time> tmp = (Comparator.comparingInt(Time::getAmount));
        temp.sort(tmp);
    }

    public void secondSort(){
        Comparator<Time> tmp = (Comparator.comparingInt(Time::getShift));
        temp.sort(tmp);
    }

}

class WorkShopArr extends AbstractWorkShop{
    private ArrayList<Time> temp;

    public WorkShopArr(String name, String address, ArrayList<Time> temp){
        super(name, address);
        this.temp = temp;
    }

    public void addTime(int amount, int shift){
        temp.add(new Time(amount, shift));
    }
    public int count(){
        return temp.size();
    }
    public int getAmount(int i){
        return temp.get(i).getAmount();
    }
    public int getShift(int i){
        return temp.get(i).getShift();
    }

    public void setAmount(int i, int amount){
        temp.get(i).setAmount(amount);
    }
    public void setShift(int i, int numVis){
        temp.get(i).setShift(numVis);
    }
    public Time[] getArrayTime(){
        Time[] tmp = new Time[temp.size()];
        for(int a = 0; a < temp.size(); a++){
            tmp[a] = new Time(temp.get(a).getAmount(), temp.get(a).getShift());
        }
        return tmp;
    }

    public void setArrayTime(Time[] tmp){
        temp = new ArrayList<>();
        for(int a = 0; a < tmp.length; a++)
            temp.add(tmp[a]);
    }

    public int all(){
        int all = 0;
        for(int a = 0; a < temp.size(); a++){
            all+=temp.get(a).getAmount();
        }
        return all;
    }

    public Time most(){
        int less = 0;
        for(int a = 1; a < temp.size(); a++){
            if(temp.get(less).getAmount() < temp.get(a).getAmount())
                less = a;
        }
        return temp.get(less);
    }

    public int addressLenght(){
        return this.getAddress().length();
    }

    public void sort(){
        Comparator<Time> tmp = (Comparator.comparingInt(Time::getAmount));
        temp.sort(tmp);
    }

    public void secondSort(){
        Comparator<Time> tmp = (Comparator.comparingInt(Time::getShift));
        temp.sort(tmp);
    }
}
class secondsort implements Comparator<Time> {
    @Override
    public int compare(Time first, Time second) {
        return Integer.compare(first.getAmount(), second.getAmount());
    }
}
class WorkShopSetFirst extends AbstractWorkShop{
    private SortedSet<Time> temp;


    public WorkShopSetFirst(String name, String address, SortedSet<Time> temp){
        super(name, address);
        this.temp = new TreeSet<>((first, second) -> {
            if(first.getAmount() > second.getAmount()) return 1;
            if(first.getShift() == second.getShift() && first.getAmount() == second.getAmount()) return 0;
            return -1;
        });
        for(Time Time : temp)
            this.temp.add(Time);
    }

    public int count(){
        return temp.size();
    }
    public int getAmount(int i){
        if (i > temp.size()) return -1;
        int count = -1;
        for (Time Time : temp){
            count++;
            if (count == i) return Time.getAmount();
        }
        return -1;
    }
    public int getShift(int i){
        if (i < temp.size()){
            int count = -1;
            for (Time Time : temp){
                count++;
                if (count == i) return Time.getShift();
            }

        }
        return -1;
    }
    public Time[] getArrayTime(){
        Time[] tmp = new Time[temp.size()];
        int counter = 0;
        for(Time Time : temp){
            tmp[counter] = Time;
            counter++;
        }
        return tmp;
    }

    public void setArrayTime(Time[] tmp){
        temp = new TreeSet<>((first, second) -> {
            if(first.getAmount() > second.getAmount()) return 1;
            if(first.getShift() == second.getShift() && first.getAmount() == second.getAmount()) return 0;
            return -1;
        });
        for(int a = 0; a < tmp.length; a++)
            temp.add(tmp[a]);
    }
    public int all(){
        int all = 0;
        for(Time Time : temp)
            all += Time.getAmount();
        return all;
    }

    public Time most(){
        int less = 0;
        for (Time Time : temp){
            if(less < Time.getAmount())
                less = Time.getAmount();
        }
        for (Time Time : temp){
            if(less == Time.getAmount())
                return Time;
        }
        return new Time(0, 1);
    }

    public int addressLenght(){
        return this.getAddress().length();
    }

    public String toString(){
        String s = "";
        for (Time Time : temp){
            s += "Amount: " + Time.getAmount() + ", Shift: " + Time.getShift() + "\n";
        }
        return s;
    }
}

class WorkShopSetSecond extends AbstractWorkShop{

    private SortedSet<Time> temp;
    public WorkShopSetSecond(String name, String address, SortedSet<Time> temp){
        super(name, address);
        this.temp = new TreeSet<>((first, second) -> {
            if(first.getShift() > second.getShift()) return 1;
            if(first.getShift() == second.getShift() && first.getAmount() == second.getAmount()) return 0;
            return -1;

        });
        for(Time Time : temp)
            this.temp.add(Time);
    }

    public int count(){
        return temp.size();
    }
    public int getAmount(int i){
        if (i > temp.size()) return -1;
        int count = -1;
        for (Time Time : temp){
            count++;
            if (count == i) return Time.getAmount();
        }
        return -1;
    }
    public int getShift(int i){
        if (i < temp.size()){
            int count = -1;
            for (Time Time : temp){
                count++;
                if (count == i) return Time.getShift();
            }

        }
        return -1;
    }
    public Time[] getArrayTime(){
        Time[] tmp = new Time[temp.size()];
        int counter = 0;
        for(Time Time : temp){
            tmp[counter] = Time;
            counter++;
        }

        return tmp;
    }

    public void setArrayTime(Time[] tmp){
        temp = new TreeSet<>((first, second) -> {
            if(first.getShift() > second.getShift()) return 1;
            if(first.getShift() == second.getShift() && first.getAmount() == second.getAmount()) return 0;
            return -1;

        });
        for(int a = 0; a < tmp.length; a++)
            temp.add(tmp[a]);
    }
    public int all(){
        int all = 0;
        for(Time Time : temp)
            all += Time.getAmount();
        return all;
    }

    public Time most(){
        int less = 0;
        for (Time Time : temp){
            if(less < Time.getAmount())
                less = Time.getAmount();
        }
        for (Time Time : temp){
            if(less == Time.getAmount())
                return Time;
        }
        return new Time(0, 1);
    }

    public int addressLenght(){
        return this.getAddress().length();
    }

    public String toString(){
        String s = "";
        for (Time Time : temp){
            s += "Amount: " + Time.getAmount() + ", :Shift: " + Time.getShift() + "\n";
        }
        return s;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Time> tmp = new ArrayList<>();
        Time[] nw = new Time[3];
        nw[0] = new Time(1, 2);
        nw[1] = new Time(3, 2);
        nw[2] = new Time(2, 1);
        tmp.add(0, new Time(5, 1));
        tmp.add(1, new Time(8, 2));
        tmp.add(2, new Time(1, 2));
        WorkShopArrList test = new WorkShopArrList("test", "address", tmp);
        System.out.println(test);
        System.out.println("All: " + test.all());
        System.out.println("Most: " + test.most());
        System.out.println("Lenght: " + test.addressLenght());
        System.out.println("hashcode: " + test.hashCode());
        System.out.println("Get address: " + test.getAddress());
        System.out.println("Get Name: " + test.getName());
        System.out.println("Get first amount: " + test.getAmount(0));
        System.out.println("Get first shift: " + test.getShift(0));
        test.sort();
        System.out.println("\nFirst sort: ");
        Time[] print = test.getArrayTime();
        for(Time Time : print)
            System.out.println(Time);
        System.out.println("\nSecond sort: ");
        test.secondSort();
        print = test.getArrayTime();
        for(Time Time : print)
            System.out.println(Time);

        System.out.println("\nChanging Time array: ");
        test.setArrayTime(nw);
        System.out.println(test);

        System.out.println("--------------------------");
        System.out.println("FirstSet: ");
        SortedSet<Time> tmp2 = new TreeSet<>();
        SortedSet<Time> tmp3 = new TreeSet<>();
        SortedSet<Time> tmp4 = new TreeSet<>();
        tmp2.add(new Time(5, 1));
        tmp2.add(new Time(8, 2));
        tmp2.add(new Time(1, 2));
        tmp3.add(new Time(5, 1));
        tmp3.add(new Time(1, 2));
        tmp3.add(new Time(1, 2));
        WorkShopSetFirst test2 = new WorkShopSetFirst("test", "address", tmp2);
        System.out.println(test2);
        System.out.println("All: " + test2.all());
        System.out.println("Most: " + test2.most());
        System.out.println("Lenght: " + test2.addressLenght());
        System.out.println("hashcode: " + test2.hashCode());
        System.out.println("Get address: " + test2.getAddress());
        System.out.println("Get Name: " + test2.getName());
        System.out.println("Get first amount: " + test2.getAmount(0));
        System.out.println("Get first shift: " + test2.getShift(0));
        System.out.println("Get array Time: ");
        Time[] print2 = test2.getArrayTime();
        for(Time Time : print2)
            System.out.println(Time);
        System.out.println("\nChanging Time array: ");
        test2.setArrayTime(nw);
        System.out.println(test2);

        System.out.println("\nSecond set: ");
        WorkShopSetSecond test4 = new WorkShopSetSecond("test", "address", tmp2);
        System.out.println(test4);
        System.out.println("All: " + test4.all());
        System.out.println("Most: " + test4.most());
        System.out.println("Lenght: " + test4.addressLenght());
        System.out.println("hashcode: " + test4.hashCode());
        System.out.println("Get address: " + test4.getAddress());
        System.out.println("Get Name: " + test4.getName());
        System.out.println("Get first amount: " + test4.getAmount(0));
        System.out.println("Get first shift: " + test4.getShift(0));
        System.out.println("Get array Time: ");
        Time[] print3 = test4.getArrayTime();
        for(Time Time : print3)
            System.out.println(Time);
        System.out.println("\nChanging Time array: ");
        test2.setArrayTime(nw);
        System.out.println(test4);
    }
}