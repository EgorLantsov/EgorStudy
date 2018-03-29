public class Figures {
//    2. Создать фигуры: Circle, Rectangle, Triangle, у которых будут координаты.
// Все фигуры должны иметь методы, которые возвращают площадь и периметр
// (для окружности - длина окружности).
    private int coordinates1;
    private int coordinates2;
    private double s;
    private double p;
    private int h1;
    private int l1;
    private int l2;
    private int l3;
    private int r;

    public Figures (int coordinates1, int coordinates2, int l1, int l2, int l3, int h1){
        this.coordinates1 = coordinates1;
        this.coordinates2 = coordinates2;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.h1 = h1;
    }
    public  Figures (int coordinates1, int coordinates2, int l1, int l2){
        this.coordinates1 = coordinates1;
        this.coordinates2 = coordinates2;
        this.l1 = l1;
        this.l2 = l2;
    }
    public  Figures (int coordinates1, int coordinates2, int r){
        this.coordinates1 = coordinates1;
        this.coordinates2 = coordinates2;
        this.r = r;
    }

    public void setSquare (){
        if (h1 == 0 && r == 0) {
            this.s = l1 * l2;
            System.out.println("Площадь четырехугольника " + s);
        } else if (l1 == 0) {
            this.s = 3.14 * r * r;
            System.out.println("Площадь круга " + s);
        } else {
            this.s = (l1 / 2) * h1;
            System.out.println("Площадь треугольника " + s);
        }
    }
    public double getSquare(){
        return this.s;
    }
    public void setPerimetre(){
        if (l3 == 0 && r == 0) {
            this.p = (l1 + l2) * 2;
            System.out.println("Периметр четырехугольника " + p);
        } else if (l1 == 0) {
            this.p = 2 * 3.14 *r;
            System.out.println("Периметр круга " + p);
        } else {
            this.p = l1 + l2 + l3;
            System.out.println("Периметр треугольника " + p);
        }
    }
    public double getPerimetre(){
        return this.p;
    }

    public static void main(String[] args) { // проверка
    Figures triangle = new Figures(3, 4, 8, 5, 4, 3);
    triangle.setSquare();
    triangle.setPerimetre();
    Figures circle = new Figures(5,7,8);
    circle.setSquare();
    circle.setPerimetre();
    Figures rectangle = new Figures(6,3,5,10);
    rectangle.setSquare();
    rectangle.setPerimetre();
    double sq = triangle.getSquare();
    System.out.println(sq);

    }
}
