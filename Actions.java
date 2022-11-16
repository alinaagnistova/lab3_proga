public class Actions implements CharacteristicsOfThings{

    void SeeLeft(ScarecrowOfRobber scarecrowOfRobber){
        Actions actions = new Actions();
        System.out.println("С левой стороны вы видите " + actions.ExecuteGetName(scarecrowOfRobber));
    }
    void SeeRight(ScarecrowOfPoliceman scarecrowOfPoliceman){
        Actions actions = new Actions();
        System.out.println("С правой стороны вы видите " + actions.ExecuteGetName(scarecrowOfPoliceman));
    }
    void SeeDirectly(Showcase showcase){
        Actions actions = new Actions();
        System.out.println("Перед собой вы видите " + actions.ExecuteGetName(showcase));
    }
    void LookAt(ScarecrowOfRobber scarecrowOfRobber, ScarecrowOfPoliceman scarecrowOfPoliceman, Showcase showcase, Location location){
        Actions actions = new Actions();
        switch(location){
            case LEFT -> {
                System.out.println(actions.ExecuteGetCondition(scarecrowOfRobber));
                Main.count++;
                break;
            }
            case RIGHT -> {
                System.out.println(actions.ExecuteGetCondition(scarecrowOfPoliceman));
                Main.count++;
                break;
            }
            case DIRECTLY -> {
                System.out.println(actions.ExecuteGetCondition(showcase));
                break;
            }
        }
    }
    @Override
    public String ExecuteGetName(Things things){
        return things.getName();
    }
    @Override
    public String ExecuteGetCondition(Things things){
        return things.getCondition();
    }
}
