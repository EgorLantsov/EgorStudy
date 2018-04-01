package school;

// 1. Представьте себе школу, подумайте, как можно спроектировать эту систему на классах, выделите
// основные сущности и подумайте, какие у них будут возможности. На основе этого опишите классы и методы

public class School {
    protected String schoolNumber; // номер школы
    protected int classNum; // колчество классов
    protected int pupilNum; // количество учеников

    School (String schoolNumber, int classNum, int pupilNum){
        this.schoolNumber = schoolNumber;
        this.classNum = classNum;
        this.pupilNum = pupilNum;
    }
    protected void studyWeekTime (PupilClass pupilClass){ // количество уроков по дням
        pupilClass.studyTime();
    }



    public static void main(String[] args) {
        School juniorSchool = new School("Number 15",3, 60);
        FirstClass classA = new FirstClass("1B", 11,20,25);
        juniorSchool.studyWeekTime(classA);
        classA.extraLessons();


    }


}
