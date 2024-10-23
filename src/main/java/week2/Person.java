package week2;

public class Person {
    int age;

    public Person(int age) {
        this.age = age;
        if(age < 0){
            throw new IllegalArgumentException("A person age cannot be less than 0");
        }
    }

    public boolean isAdult(){
        return age >= 18;
    }

    public boolean canGoToSchool(){
        return age >= 6;
    }
}
