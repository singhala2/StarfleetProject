import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args) {

        int repairPrice = 3000;

        Ship s1 = new Ship();
        Fleet fleet = new Fleet();

        Ship s2 = new Ship("Voyager", 100, 15, 20000);
        Ship s3 = new Ship("Kelvin", 150, 25, 35000);

        Mission m1 = new Mission();
        Mission m2 = new Mission("Medium Mission", 0.6f, 5000);
        Mission m3 = new Mission("Hard Mission", 0.4f, 8000);

        Scanner input = new Scanner(System.in);

        boolean mainLoop = true;
        int choice = -1;

        while(mainLoop == true){

            fleet.DeleteShip();
            System.out.println("Star Bucks: "+ fleet.getMoney());

            System.out.println("Starfleet Main Menu");
            System.out.println("1. View Fleet");
            System.out.println("2. Go on Mission");
            System.out.println("3. Repair Ship");
            System.out.println("4. Buy Ship");
            System.out.println("5. Exit");
            System.out.println("Please Enter Your Menu Option by Typing a Number");


            if(input.hasNextInt()) {
                choice = input.nextInt();

                switch(choice)
                {
                    case 1:
                        fleet.DisplayFleet();
                        break;

                    case 2:

                        System.out.println("Select the mission difficulty.");
                        System.out.print("1. ");
                        m1.Details();
                        System.out.print("2. ");
                        m2.Details();
                        System.out.print("3. ");
                        m3.Details();

                        Mission chosenMission = new Mission();

                        int missionDiffChoiceTemp = -1999;

                        if(input.hasNextInt()==true)
                        {
                            missionDiffChoiceTemp = input.nextInt();
                        }
                        else
                        {
                            System.out.println("Invalid input.");
                        }

                        int missionDiffChoice = missionDiffChoiceTemp;

                        if(missionDiffChoice == 1)
                        {
                            chosenMission = m1;
                        }
                        else if(missionDiffChoice == 2)
                        {
                            chosenMission = m2;
                        }
                        else if(missionDiffChoice == 3)
                        {
                            chosenMission = m3;
                        }
                        else
                        {
                            System.out.println("Invalid input. Your ineptitude has been noted with disdain and you have been fired from Starfleet.");
                            System.out.println("Exiting Program...");
                            System.exit(0);
                        }

                        System.out.println("And which ship would you like to use?");
                        fleet.DisplayFleet();
                        int missionShipChoice = input.nextInt();

                        Ship chosenShip = new Ship();

                        if(fleet.getHangar()[missionShipChoice] != null) {
                            chosenShip = fleet.getHangar()[missionShipChoice - 1];
                            runMission(chosenShip, chosenMission, fleet);
                        }
                        else
                        {
                            System.out.println("Invalid choice. Press 1 to return to the main menu.");
                        }

                        break;



                    case 3:
                        fleet.RepairShip();
                        break;

                    case 4:
                        System.out.println("Star Bucks: "+ fleet.getMoney());
                        System.out.println("Which ship would you like to buy?");
                        System.out.print("1. ");
                        s1.Details();
                        System.out.print("2. ");
                        s2.Details();
                        System.out.print("3. ");
                        s3.Details();

                        int shipChoiceTemp = -1999;
                        if(input.hasNextInt()==true)
                        {
                            shipChoiceTemp = input.nextInt();
                        }
                        else
                        {
                            System.out.println("Invalid Input.");
                        }

                        int shipChoice = shipChoiceTemp;

                        if(shipChoice == 1)
                        {
                            fleet.AddShip(s1);
                        }
                        else if(shipChoice == 2)
                        {
                            fleet.AddShip(s2);
                        }
                        else if(shipChoice == 3)
                        {
                            fleet.AddShip(s3);
                        }
                        else
                        {
                            System.out.println("Invalid Input.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting Program...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid menu choice; try again.");
                        break;
                }
            }
            else
            {
                System.out.println("Wildly invalid Input. Your ineptitude is noted with disdain and you have been fired from Starfleet.");
                System.out.println("Exiting Program...");
                System.exit(0);
                break;
            }
        }

    }

    static void runMission(Ship s, Mission m, Fleet f)
    {
        Random random = new Random();

        float r = random.nextFloat();

        System.out.println(s.getFirepower());
        m.setSuccessDet(s.getFirepower()*m.getRiskFactor()*r);
        System.out.println(m.successDet);

        if(m.successDet>=3)
        {
            m.setMissionSuccess(true);
        }
        else
        {
            m.setMissionSuccess(false);
        }

        if(m.isMissionSuccess() == true)
        {
            System.out.println("Mission Success!");
           f.setMoney(f.getMoney() + m.getValue());
            System.out.println("You gained " + m.getValue() + " Star Bucks");
        }
        else if(m.isMissionSuccess() == false)
        {
            System.out.println("Mission Failure :(");
            int hpLoss = random.nextInt(100);
            s.setHp(s.getHp()- hpLoss);
            System.out.println(s.getName()+ " lost " + hpLoss + " HP." + " Current HP: " + s.getHp());
        }
    }

}
