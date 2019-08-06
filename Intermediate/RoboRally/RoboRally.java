public class RoboRally{
    public void Robot(int posx, int posy, String facing){
        System.out.println("Robot is in position " + posx + "by" + posy + " facing " + facing);
    }
    
    public static void main(String args){
        Robot robot1 = new Robot(1,1,"West");
        System.out.print(robot1);
    }
}