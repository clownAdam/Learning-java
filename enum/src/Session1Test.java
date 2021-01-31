/**
 * @author clown
 */
public class Session1Test {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer.getSeasonName());
        System.out.println(Season1.class.getSuperclass());
        Season1[] values = Season1.values();
        Season1 spring = Season1.valueOf("SPRING");
        spring.show();
        for (Season1 value : values) {
            value.show();
        }
    }
}

interface Info {
    /**
     * show : show
     */
    void show();
}

/**
 *
 */
enum Season1 implements Info {
    /**
     *
     */
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("c");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("x");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("q");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("d");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    /**
     * 1.私有化类的构造器
     */
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}