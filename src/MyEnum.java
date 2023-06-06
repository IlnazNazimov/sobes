import java.util.ArrayList;
import java.util.List;

public class MyEnum {
    public int number;
    public String name ="";
    public static List<MyEnum> enums = new ArrayList<>();

    public static MyEnum april = new MyEnum(1, "Апрель");
    public static MyEnum mart = new MyEnum(2, "Март");

    public MyEnum(int number, String name) {
        this.number = number;
        this.name = name;
        enums.add(this);
    }

    public int ordenal() {
        return this.number;
    }

    public static MyEnum valueOf(String name) {
        return enums.stream().filter(s -> s.name.equals(name)).findFirst().get();
    }
}
