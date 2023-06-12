import java.io.Serializable;

public abstract class AbstractWorkShop implements Serializable {
    private static final long serialVersionUID = 8433147861334322335L;
    private String name;
    private String address;
    /**

    /**
     * Конструктор абстрактного класу
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
     * Повертає посилання на новий масив концертів які містять найбільшу кількість глядачів
     * @return масив концертів які містять найбільшу кількість глядачів
     */
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