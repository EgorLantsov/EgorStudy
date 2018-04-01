package school;

public class FirstClass extends PupilClass {

    protected FirstClass (String numberClass, int agePupil, int pupilClassNum, int lessonNum){
        super(numberClass, agePupil, pupilClassNum, lessonNum);
    }
    protected void extraLessons (){
        if (pupilClassNum <= 18){
            System.out.println("Можно провести " + 2 + " дополнительных урока в неделю");
        } else if (pupilClassNum >= 19 && pupilClassNum <= 25){
            System.out.println("Можно провести " + 3 + " дополнительных урока в неделю");
        } else {
            System.out.println("Можно провести " + 4 + " дополнительных урока в неделю");
        }
    }
}
