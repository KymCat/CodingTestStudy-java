package Stream;

public class Member {
    private String name;
    private int age;
    private int weight;
    private boolean sex; // man(true)

    public Member(String name, int age, int weight, boolean sex) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.sex = sex;
    }

    // name getter
    public String getName() {
        return name;
    }

    // age getter
    public int getAge() {
        return age;
    }

    // weight getter
    public int getWeight() {
        return weight;
    }

    // sex getter
    public boolean isSex() {
        return sex;
    }

}
