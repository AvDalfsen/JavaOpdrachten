import java.util.ArrayList;

public class RoboRally{
    public static void main(String[] args){
        Robot robOne = new Robot(0, 0, "North", 1); //Starting positions, facings, and robot number
        Robot robTwo = new Robot(1, 1, "East", 2);
        
        robOne.turnLeft(); //Commands are stored separately per robot, regardless of the order of the commands
        robOne.turnLeft(); //A user interface should be more than possible, even with two 'players'. Solid foundation for the actual game, I'd say
        robOne.moveForward();
        robTwo.moveBackward();
        robOne.moveForward(3);
        robOne.moveForward(4);
        robOne.moveForward(9);
        robTwo.turnLeft();
        robOne.turnLeft();

        robOne.executeMoves(); //I'm honestly unsure how the commands are separated between the two robots. At the end of executing the commands
        robTwo.executeMoves(); //the lists are cleared. I don't see how the commands for robTwo aren't removed after those for robOne have been executed

        robOne.moveForward(4);
        robTwo.moveForward(4);
        
        robTwo.executeMoves();
        robOne.executeMoves();
    }
}

class Robot{
    int posX;
    int posY;
    String direction;
    int speed;
    ArrayList<Integer> exeList = new ArrayList<Integer>(); //Chronological list of commands given
    ArrayList<Integer> spdList = new ArrayList<Integer>(); //Chronological list of speeds provided to the moveForward method
    int robNumber;

    Robot(int x, int y, String facing, int number){
        posX = x;
        posY = y;
        direction = facing;
        robNumber = number;
    }

    void turnLeft(){ //Separated the methods into two: one to call when giving a command, which is stored in exeList, which then gives the actual command to be executed. Rather a roundabout approach, but it works
        exeList.add(1); //When called it adds a number to the executable list, which identifies the thing that the user wants the robot to do
    }

    void turnRight(){
        exeList.add(2);
    }

    void moveForward(){
        exeList.add(3);
    }

    void moveForward(int speed){
        if(speed > 0 && speed < 4) {
            exeList.add(4);
            spdList.add(speed);
        }
        else{
            System.out.println("Please enter a speed of 1, 2, or 3. The robot cannot go faster or slower.");
        }
    }

    void moveBackward(){
        exeList.add(5);
    }

    void turnLeftExe(){
        if(direction.equals("North")){
            direction = "West";
        }
        else if(direction.equals("East")){
            direction = "North";
        }
        else if(direction.equals("South")){
            direction = "East";
        }
        else if(direction.equals("West")){
            direction = "South";
        }
    printState();
    }

    void turnRightExe(){
        if(direction.equals("North")){
            direction = "East";
        }
        else if(direction.equals("East")){
            direction = "South";
        }
        else if(direction.equals("South")){
            direction = "West";
        }
        else if(direction.equals("West")){
            direction = "North";
        }
    printState();
    }

    void moveForwardExe(){
        if(direction.equals("North")){
            posY++; //Movement based on standard x-y axis with 0,0 being the middle. Moving forward when facing the north gives + y movement
        }
        else if(direction.equals("East")){
            posX++; //Facing East gives + x
        }
        else if(direction.equals("South")){
            posY--; //Facing South gives - y
        }
        else if(direction.equals("West")){
            posX--; //And West for - x // unsure how feasible or convenient such a system is for an actual game, but it serves its purpose
        }
    printState();
    }

    void moveForwardExe(int speed){
        if(direction.equals("North")){
            posY = posY + speed; //Fairly straightforward
        }
        else if(direction.equals("East")){
            posX = posX + speed;
        }
        else if(direction.equals("South")){
            posY = posY - speed;
        }
        else if(direction.equals("West")){
            posX = posX - speed;
        }
    printState();
    }

    void moveBackExe(){
        if(direction.equals("North")){
            posY--; //Going backwards has the opposite results as forwards (obviously)
        }
        else if(direction.equals("East")){
            posX--;
        }
        else if(direction.equals("South")){
            posY++;
        }
        else if(direction.equals("West")){
            posX++;
        }
    printState();
    }

    void executeMoves(){
        int j = 0;
        for(int i = 0; i < exeList.size(); i++){
            switch(exeList.get(i)){ //Iterates over the exeList based on its length. Switch makes it 'runnable', saving a boatload of if statements
                case 1: turnLeftExe();
                    break;
                case 2: turnRightExe();
                    break;
                case 3: moveForwardExe();
                    break;
                case 4: moveForwardExe(spdList.get(j));
                    j++;
                    break;
                case 5: moveBackExe();
                    break;
            }
        }
        exeList.clear(); //Clears the list to prevent repeated commands
        spdList.clear();
    }

    void printState(){
        System.out.println("Robot #" + robNumber + " is facing the " + direction + ", at position: x|" + posX + " by y|" + posY);
    }
}