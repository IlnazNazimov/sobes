/**
 Представим, что в языке совсем нет енума.
 Нужно придумать и сделать один конкретный енум (валюта, цвета, статусы ответов, тд).
 Минимальные требования:
 - по семантике и удобству использования должен быть максимально похож на родной енум языка (если таковой есть)
 - внутри как можно меньше граблей, которые могут привести к багам при дальнейшем расширении енума
 - список значений задаётся на этапе компиялции, не может быть расширен в рантайме
 - значения безопасно сравниваются по ==
 - значения строго типизированы
 */
class Enums {
    public String name;
    public Integer number;

    private static int counter = 0;

    private static Enums GREEN = new Enums("Зеленый");
    private static Enums BLACK = new Enums("Черный");
    private static Enums WHITE = new Enums("Белый");

    public Enums(String name) {
        this.name = name;
        this.number = counter;
        counter++;
    }

}