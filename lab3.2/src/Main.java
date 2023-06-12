enum Month {
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31),
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31);

    private int days;
    private Month(int days){
        this.days = days;
    }

    public Month getMonth() {
        return this;
    }

    int getDays() {
        return this.days;
    }
    public Month getPrevious() {
        if(this == SEPTEMBER)
            return AUGUST;
        else if(this == OCTOBER)
            return SEPTEMBER;
        else if(this == NOVEMBER)
            return OCTOBER;
        else if(this == DECEMBER)
            return NOVEMBER;
        else if(this == JANUARY)
            return DECEMBER;
        else if(this == FEBRUARY)
            return JANUARY;
        else if(this == MARCH)
            return FEBRUARY;
        else if(this == APRIL)
            return MARCH;
        else if(this == MAY)
            return APRIL;
        else if(this == JUNE)
            return MAY;
        else if(this == JULY)
            return JUNE;
        else
            return JULY;
    }
    public Month getNext() {
        if(this == SEPTEMBER)
            return OCTOBER;
        else if(this == OCTOBER)
            return NOVEMBER;
        else if(this == NOVEMBER)
            return DECEMBER;
        else if(this == DECEMBER)
            return JANUARY;
        else if(this == JANUARY)
            return FEBRUARY;
        else if(this == FEBRUARY)
            return MARCH;
        else if(this == MARCH)
            return APRIL;
        else if(this == APRIL)
            return MAY;
        else if(this == MAY)
            return JUNE;
        else if(this == JUNE)
            return JULY;
        else if(this == JULY)
            return AUGUST;
        else
            return SEPTEMBER;
    }
    public String getUkrainian() {
        if(this == SEPTEMBER)
            return "Вересень";
        else if(this == OCTOBER)
            return "Жовтень";
        else if(this == NOVEMBER)
            return "Листопад";
        else if(this == DECEMBER)
            return "Грудень";
        else if(this == JANUARY)
            return "Січень";
        else if(this == FEBRUARY)
            return "Лютий";
        else if(this == MARCH)
            return "Березень";
        else if(this == APRIL)
            return "Квітень";
        else if(this == MAY)
            return "Травень";
        else if(this == JUNE)
            return "Червень";
        else if(this == JULY)
            return "Липень";
        else
            return "Серпень";
    }

    public String getRussian() {
        if(this == SEPTEMBER)
            return "Сентябрь";
        else if(this == OCTOBER)
            return "Октябрь";
        else if(this == NOVEMBER)
            return "Ноябрь";
        else if(this == DECEMBER)
            return "Декабрь";
        else if(this == JANUARY)
            return "Январь";
        else if(this == FEBRUARY)
            return "Февраль";
        else if(this == MARCH)
            return "Март";
        else if(this == APRIL)
            return "Апрель";
        else if(this == MAY)
            return "Май";
        else if(this == JUNE)
            return "Июнь";
        else if(this == JULY)
            return "Июль";
        else
            return "Август";
    }
    public String getSeason(){
        if(this == JANUARY || this == FEBRUARY || this == DECEMBER)
            return "Зима";
        else if(this == MARCH || this == APRIL || this == MAY)
            return "Весна";
        else if(this == JUNE || this == JULY || this == AUGUST)
            return "Літо";
        else
            return "Осінь";
    }
    static void getAll(){
        System.out.print(SEPTEMBER);
        System.out.print(OCTOBER);
        System.out.print(NOVEMBER);
        System.out.print(DECEMBER);
        System.out.print(JANUARY);
        System.out.print(FEBRUARY);
        System.out.print(MARCH);
        System.out.print(APRIL);
        System.out.print(MAY);
        System.out.print(JUNE);
        System.out.print(JULY);
        System.out.print(AUGUST);
    }
    @Override
    public String toString() {
        return this.getUkrainian() + ": " + this.getDays() + " \n";
    }
}

public class Main {
    public static void main(String[] args) {
        Month test = Month.SEPTEMBER;
        System.out.println("Цей місяць: " + test.getMonth().getUkrainian());
        System.out.println("Попередній: " + test.getPrevious().getUkrainian());
        System.out.println("Наступний: " + test.getNext().getUkrainian());
        System.out.println("Українською: " + test.getUkrainian());
        System.out.println("Російською: " + test.getRussian());
        System.out.println("Сезон: " + test.getSeason());
        System.out.println("Усі дані: ");
        test.getAll();
    }
}