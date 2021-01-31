/**
 * @author clown
 */
public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name.equals(person.name);
    }*/

   /* @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person person = (Person) o;
            int compare = this.name.compareTo(person.name);
            if (compare != 0) {
                return compare;
            } else {
                Integer.compare(this.age, person.age);
            }

        }
        return -1;
    }*/

/*    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        return result;
    }*/
}
