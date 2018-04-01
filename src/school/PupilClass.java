package school;

public class PupilClass {

    int pupilClassNum; // количество учеников в классе
    int lessonNum; // количество уроков у класса
    String numberClass; // номер класса
    protected int agePupil; //возраст учеников
    public PupilClass (String numberClass, int agePupil, int pupilClassNum, int lessonNum){
        this. numberClass = numberClass;
        this.agePupil = agePupil;
        this.pupilClassNum = pupilClassNum;
        this.lessonNum = lessonNum;
    }
    protected void studyTime () { // количество уроков по дням
        if (agePupil <= 10) {
            System.out.println("Понедельник " + (lessonNum / 5 + 1) + " уроков");
            System.out.println("Вторник " + (lessonNum / 5) + " уроков");
            System.out.println("Среда " + (lessonNum / 5) + " уроков");
            System.out.println("Четверг " + (lessonNum / 5 - 1) + " уроков");
            System.out.println("Пятница " + (lessonNum / 5) + " уроков");
        } else {
            System.out.println("Понедельник " + (lessonNum / 5) + " уроков");
            System.out.println("Вторник " + (lessonNum / 5 + 1) + " уроков");
            System.out.println("Среда " + (lessonNum / 5 + 1) + " уроков");
            System.out.println("Четверг " + (lessonNum / 5) + " уроков");
            System.out.println("Пятница " + (lessonNum / 5 - 1) + " уроков");
        }
    }
}
