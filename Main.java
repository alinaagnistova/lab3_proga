import java.util.List;
import java.util.Scanner;

public class Main implements ExecuteActions{
    static Integer count = 0;
    public static void main(String[] args){
        Showcase showcase = new Showcase("Витрина", "Витрина, в которой были выставлены различные маски: и такие, которые закрывают лишь верхнюю часть лица, с прорезами для глаз, и такие, которые надеваются целиком на голову, в виде островерхого капюшона. Кроме масок, здесь были также грим, парики, накладные бороды и усы - все, что помогает изменить внешность");
        ScarecrowOfPoliceman scarecrowOfPoliceman = new ScarecrowOfPoliceman("Чучело полицейского", "Чучело полицейского в полном обмундировании, с блестящей медной каской на голове и дубинкой в руке.");
        ScarecrowOfRobber scarecrowOfRobber = new ScarecrowOfRobber("Чучело грабителя", "Чучело грабителя, подкрадывающегося к несгораемой кассе, с огромным пистолетом в одной руке и потайным электрическим фонарем в другой. Его шея была повязана пестрым клетчатым платком, на голове была клетчатая кепка с широким козырьком, такие же клетчатые брюки плотно облегали его ноги, лицо закрывала черная маска.");
        System.out.println("Добро пожаловать в игру. Теперь ты не сможешь выйти из комнаты пока не ответишь на вопрос, который мы озвучим позже, а пока советую осмотреться");
        System.out.println("Кстати, ты можешь смотреть на отдельные предметы в комнате look at");
        System.out.println("Чтобы закончить игру введи break");
        System.out.println("Если будешь внимателен, то можешь заметить что-нибудь интересное detect");
        List<Location> locations = List.of(new Location[]{Location.RIGHT, Location.LEFT, Location.DIRECTLY});
        System.out.println("Выбери куда хочешь посмотреть:"+ locations.toString());
        Scanner scanner = new Scanner(System.in);
        Location location = Location.NOWHERE;
        while (true){
            String text = scanner.nextLine(); //find a new line and read it
            Main main = new Main();
            switch (text) {
                case ("directly"):{
                    main.ExecuteSeeDirectly(showcase);
                    location = Location.DIRECTLY;
                    break;
                }
                case ("left"):{
                    main.ExecuteSeeLeft(scarecrowOfRobber);
                    location = Location.LEFT;
                    break;
                }
                case ("right"):{
                    main.ExecuteSeeRight(scarecrowOfPoliceman);
                    location = Location.RIGHT;
                    break;
                }
                case ("look at"):{
                    if (location.hashCode()==Location.NOWHERE.hashCode()){
                        System.out.println("Ничего интересного, один хлам");
                    }
                    else{
                        main.ExecuteLookAt(scarecrowOfRobber, scarecrowOfPoliceman, showcase, location);
                        location = Location.NOWHERE;
                        }
                    break;
                    }
                case ("detect"):{
                    if (Main.count == 2) {
                        System.out.println("Оба чучела были сделаны с таким мастерством, что их можно было принять за настоящих живых коротышек.");
                    }
                    else{
                        System.out.println("Надо приглядеться к чучелам получше");
                    }
                    break;
                }

            }
            if (text.equals("break")){
                System.exit(0);
            }
        }





    }
    @Override
    public void ExecuteSeeRight(ScarecrowOfPoliceman scarecrowOfPoliceman){
        Actions actions = new Actions();
        actions.SeeRight(scarecrowOfPoliceman);
    }
    @Override
    public void ExecuteSeeLeft(ScarecrowOfRobber scarecrowOfRobber){
        Actions actions = new Actions();
        actions.SeeLeft(scarecrowOfRobber);
    }
    @Override
    public void ExecuteSeeDirectly(Showcase showcase){
        Actions actions = new Actions();
        actions.SeeDirectly(showcase);
    }
    @Override
    public void ExecuteLookAt(ScarecrowOfRobber scarecrowOfRobber, ScarecrowOfPoliceman scarecrowOfPoliceman, Showcase showcase, Location location){
        Actions actions = new Actions();
        actions.LookAt(scarecrowOfRobber, scarecrowOfPoliceman, showcase, location);
    }
}
