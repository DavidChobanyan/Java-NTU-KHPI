import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас відповідає за зміну.
 * Його представлено кількістю відвідувачів та коментарем
 */
class Time implements Comparable<Time>{
    private int amount;
    private int shift;
    /**
     * Конструктор ініціалізує об'єкт вказаними значеннями
     * @param amount кількість відвідувачів
     * @param shift коментар
     */
    public Time(int amount, int shift) {
        if(amount >= 0) {
            this.amount = amount;
            if(shift == 2 || shift == 1)
                this.shift = shift;
        }
    }
    /**
     * Повертає кількість відвідувачів
     * @return кількість відвідувачів у вігляді цілого значення
     */
    public int getAmount(){
        return this.amount;
    }
    /**
     * Встановлює нову кількість відвідувачів
     * @param amount нова кількість відвідувачів у вігляді цілого значення
     */
    public void setAmount(int amount){
        this.amount = amount;
    }
    /**
     * Повертає коментар
     * @return коментар у вигляді строки
     */
    public int getShift(){
        return this.shift;
    }
    /**
     * Встановлює новий коментар
     * @param shift новий коментар
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

    public int hashCode() {
        return amount*shift;
    }

    @Override
    public String toString() {
        return "amount= " + amount
                + ", shift= " + shift;
    }
    /**
     * Повертає хеш-код змінної
     * @return хеш-код змінної у вігляді цілого значення
     */
    @Override
    public int compareTo(Time c) {
        return -1 * Integer.compare(getAmount(), c.getAmount());
    }
}

/**
 * Клас відповідає за майстерня.
 * Його представлено ім'ям та адресою
 */
abstract class AbstractWorkShop {
    private String name;
    private String address;
    /**
     * Конструктор ініціалізує об'єкт вказаними значеннями
     * @param name ім'я майстерняу
     * @param address адреса майстерняу
     */

    public AbstractWorkShop(String name, String address) {
        this.name = name;
        this.address = address;
    }
    /**
     * Повертає ім'я майстерняу
     * @return ім'я у вигляді строки
     */
    public String getName(){
        return this.name;
    }
    /**
     * Встановлює нове ім'я майстерняу
     * @param name ім'я майстерняу
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Повертає адресу майстерняу
     * @return адресу у вигляді строки
     */
    public String getAddress(){
        return this.address;
    }
    /**
     * Встановлює нову адресу майстерняу
     * @param address адреса майстерняу
     */
    public void setAddress(String address){
        this.address = address;
    }

    /**
     * Повертає загальну кількість покупців
     * @return загальну кількість покупців у вигляді цілого значення більшого за 0
     */
    public abstract int all();
    /**
     * Повертає массив змін
     * @return массив змін у вигляді одновимірного масиву
     */
    public abstract Time[] getArrayShift();
    /**
     * Встановлює новий массив змін
     * @param temp массив змін у вигляді одновимірного масиву
     */
    public abstract void setArrayShift(Time[] temp);
    /**
     * Повертає зміну з найменшою кількістю відвідувачів
     * @return зміну з найменшою кількістю відвідувачів у вигляді змінної time
     */
    public abstract Time most();
    /**
     * Повертає строку із входженням строки find
     * @return Повертає строку із входженням строки find у вигляді строки
     */
    public abstract int addressLenght();

    /**
     * Сортування за зменшенням кількості покупців методом бульбашки
     * @return массив time відсортований за зменшенням кількості покупців методом бульбашки
     */
    public Time[] sortless(){
        Time[] tem = getArrayShift();
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
     * Сортування за коментарем
     * @return массив time відсортований за коментарями методом входження
     */
    public Time[] sortShift(){
        Time[] tem = getArrayShift();
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
        Time[] tem = getArrayShift();
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
        return check.getName() == name && check.getAddress() == address && getArrayShift().equals(check.getArrayShift());
    }
    /**
     * Повертає хеш-код змінної
     * @return хеш-код змінної у вігляді цілого значення
     */
    @Override
    public int hashCode() {
        return getAddress().hashCode() * getName().hashCode() * java.util.Arrays.hashCode(getArrayShift());
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
     * @param name ім'я майстерняу
     * @param address адреса майстерняу
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
    public Time[] getArrayShift(){
        return temp;
    }
    /**
     * Встановлює новий массив змін
     * @param temp новий массив змін
     */
    public void setArrayShift(Time[] temp){
        this.temp = temp;
    }
    /**
     * Повертає загальну кількість покупців
     * @return загальну кількість покупців у вигляді цілого значення більшого за 0
     */
    public int all(){
        int all = 0;
        for(int a = 0; a < temp.length; a++){
            all+=temp[a].getAmount();
        }
        return all;
    }
    /**
     * Повертає зміну з найменшою кількістю відвідувачів
     * @return зміну з найменшою кількістю відвідувачів у вигляді змінної time
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
     * Сортування за зменшенням кількості покупців методом бульбашки
     * @return массив time відсортований за зменшенням кількості покупців методом бульбашки
     */
    public int addressLenght(){
        return this.getAddress().length();
    }

}

/**
 * Клас що представляє майстерня.
 * Дані про зміни представлені массивом
 * Сортування із використанням Arrays
 */
class WorkShopSort extends WorkShop {
    /**
     * Конструктор ініціалізує об'єкт вказаними значеннями
     * @param name ім'я майстерняу
     * @param address адреса майстерняу
     * @param temp массив змін
     */
    public WorkShopSort(String name, String address, Time[] temp) {
        super(name, address, temp);
    }
    /**
     * Сортування за зменшенням кількості покупців методом бульбашки
     * @return массив time відсортований за зменшенням кількості покупців методом Arrays
     */
    @Override
    public Time[] sortless(){
        Time[] temp = getArrayShift();
        Arrays.sort(temp);
        return temp;
    }
    /**
     * Сортування за коментарем
     * @return массив time відсортований за коментарями методом Arrays
     */
    @Override
    public Time[] sortShift(){
        Time[] temp = getArrayShift();
        Arrays.sort(temp, new secondsort());
        return temp;
    }
}

/**
 * Клас для реалізації інтерфейсу Comparator
 */
class secondsort implements Comparator<Time> {
    @Override
    /**
     * Повертає від'ємне значення, якщо коментар за алфавітом повинен бути раніше ніж
     * менше кількості відвідувачів comment2,
     * Повертає додатнє значення у усіх інших випадках
     * @param comment1 перший коментар
     * @param comment2 другий коментар
     * @return результат порівняння
     */

    public int compare(Time comment1, Time comment2) {
            if(comment1.getShift() < comment2.getShift()){
                return -1;
            }else if(comment1.getShift() > comment2.getShift()){
                return 1;
            }else
                return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Time[] test = new Time[5];
        Time[] test6 = new Time[5];
        Time testtime1 = new Time(15, 1);
        test[0] = new Time(23,  2);
        test[1] = new Time(23,  2);
        test[2] = new Time(8, 1);
        test[3] = new Time(9, 2);
        test[4] = new Time(16, 1);
        test6[0] = new Time(15,  1);
        test6[1] = new Time(3,  2);
        test6[2] = new Time(1, 2);
        test6[3] = new Time(6, 2);
        test6[4] = new Time(2, 2);
        WorkShop test2 = new WorkShop("Yellw", "Kharkiv", test);
        WorkShop test3 = new WorkShop("Yellw", "Kharkiv", test);
        WorkShop test4 = new WorkShop("Ylw", "Kiev", test);
        System.out.println("Print out Test time class results:");
        System.out.println(testtime1);
        System.out.println("\nPrint out getting time class data:");
        System.out.println(testtime1.getAmount());
        System.out.println(testtime1.getShift());
        System.out.println(testtime1.hashCode());
        System.out.println("Testing equals: ");
        System.out.println(("Test false equase: " + testtime1.equals(new Time(1, 1))));
        System.out.println(("Test true equase: " + testtime1.equals(new Time(15, 1))));
        System.out.println("\nPrint out changing time class data: ");
        testtime1.setAmount(3);
        testtime1.setShift(2);
        System.out.println(testtime1.getAmount());
        System.out.println(testtime1.getShift());

        System.out.println("\nPrint out workshop class:");
        System.out.println(test2);
        System.out.println("Array of times: ");
        Time[] getArray = test2.getArrayShift();
        for(Time time : getArray)
            System.out.println(time);
        System.out.println("\nAnother array before changing ");
        for(Time time : test4.getArrayShift())
            System.out.println(time);
        System.out.println("\nAfter: ");
        test4.setArrayShift(test6);
        for(Time time : test4.getArrayShift())
            System.out.println(time);
        System.out.println("\ntrue equals: " + test2.equals(test3));
        System.out.println("false equals: " + test2.equals(test4));
        System.out.println("hashcode: " + test2.hashCode());
        System.out.println();
        System.out.println("Whole amount: " + test2.all());
        System.out.println("Time with most amount: \n" + test2.most());
        System.out.println("Address lenght: " + test2.addressLenght());
        System.out.println("\nSort by amount:");
        test2.sortless();
        System.out.println(test2);
        System.out.println("\nSort by shift:");
        test2.sortShift();
        System.out.println(test2);
        WorkShopSort test5 = new WorkShopSort("Yellw", "Kharkiv", test);
        System.out.println("\nSort by amount using Arrays methods:");
        test5.sortless();
        System.out.println(test5);
        System.out.println("\nSort by shift using Arrays methods:");
        test5.sortShift();
        System.out.println(test5);
    }
}