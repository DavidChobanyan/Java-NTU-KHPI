public class WorkShop extends AbstractWorkShop {
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

    public void clearTime(){
        Time[] clear = {};
        this.setArrayTime(clear);
    }
    public void addTime(Time element){
        Time[] arr1 = new Time[this.getArrayTime().length + 1];
        System.arraycopy(this.getArrayTime(), 0, arr1, 0, getArrayTime().length);
        arr1[getArrayTime().length] = element;
        setArrayTime(arr1);
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