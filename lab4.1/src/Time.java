import java.io.Serializable;

class Time implements Comparable<Time>, Serializable {
    private static final long serialVersionUID = -6755942443306500892L;
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