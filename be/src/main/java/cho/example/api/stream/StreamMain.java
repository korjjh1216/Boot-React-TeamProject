package cho.example.api.stream;

import lombok.Builder;

import java.util.*;
import java.util.stream.Stream;

import static cho.example.api.stream.RefUtil.*;


class Student implements Comparable<Student>{
    private String name;
    private int grade;
    private int score;
    private String username; // ID


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade(){
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score= score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Builder
    public Student(String name,int grade,int score,String username){
        this.name=name;
        this.grade=grade;
        this.score =score;
        this.username =username;
        return;
    }

    @Override
    public String toString() {
        return String.format("[%s,%d,%d,%s]",name,grade,score,username);
    }

    @Override
    public int compareTo(Student o) {
        return o.getScore()-this.getScore();
    }

}



public class StreamMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("메뉴: 0.EXIT 1.학년오름차순 2.성적내림차순 3.이름오름차순 4.ID오름차순 5.전학년내림차순");
            switch (scanner.nextInt()){
                case 0: return;
                case 1: ascGrade().forEach(System.out::println);break;
                case 2: ascScore().forEach(System.out::println);break;
                case 3: ascName().forEach(System.out::println);break;
                case 4: ascId().forEach(System.out::println);break;
                case 5: ascTotalScore().forEach(System.out::println);break;
            }
        }

    }
    public static Stream<Student> makeStream(){
        DummyGenerator dum =new DummyGenerator();
        return
                Stream.of(
                        new Student(dum.MakeName(),rangeRandom.apply(1, 3),rangeRandom.apply(1, 100),dum.makeUsername()),
                        new Student(dum.MakeName(),rangeRandom.apply(1, 3),rangeRandom.apply(1, 100),dum.makeUsername()),
                        new Student(dum.MakeName(),rangeRandom.apply(1, 3),rangeRandom.apply(1, 100),dum.makeUsername()),
                        new Student(dum.MakeName(),rangeRandom.apply(1, 3),rangeRandom.apply(1, 100),dum.makeUsername()),
                        new Student(dum.MakeName(),rangeRandom.apply(1, 3),rangeRandom.apply(1, 100),dum.makeUsername())
                );
    }
    public static Stream<Student> ascGrade() {
        return makeStream().sorted(Comparator.comparing(Student::getGrade)
                .thenComparing(Comparator.naturalOrder()));
    }

    public static Stream<Student> ascName() {
        return makeStream().sorted(Comparator.comparing(Student::getName)
                .thenComparing(Comparator.naturalOrder()));
    }

    //전학년 성적내림차순
    public static Stream<Student> ascTotalScore() {
        return makeStream().sorted(Comparator.naturalOrder());
    }

    public static Stream<Student> ascScore() {
        //반별 내림 성적 내림차순
        return makeStream().sorted(Comparator.comparing(Student::getGrade)
                .thenComparing(Comparator.comparing(Student::getScore).reversed()));
    }

   /* public static Stream<Student> ascId(){
       return makeStream()
               .map(Student->{Student.setUsername(Student.getUsername().toLowerCase(Locale.ROOT));return Student;})
               .distinct()
               .sorted(Comparator.comparing(Student::getUsername));
    }*/
   public static Stream<Student> ascId(){
       return makeStream()
               .distinct()
               .sorted(Comparator.comparing(Student::getUsername));}
}
