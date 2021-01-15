import java.util.InputMismatchException;
import java.util.Scanner;

public class Fleet {

    Scanner input = new Scanner(System.in);

    private Ship[] hangar;
    private int money = 20000;
    private String name;

    public Fleet()
    {
        hangar = new Ship[10];
        name = "Player's Hangar";
    }

    public void RepairShip()
    {
        if(money > 3000)
        {
            System.out.println("Please choose which ship you would like to repair. Repair Price: 3000 Star Bucks");
            for(int i = 0; i<hangar.length; i++)
            {
                if(hangar[i] != null)
                {
                    System.out.println((i+1) + " " + hangar[i].getName() + " HP: " + hangar[i].getHp() + " max HP: " + hangar[i].getMaxHp());
                }
            }

            int chooseShip = -1999;

            try
            {
                chooseShip = input.nextInt() - 1;
                if(chooseShip <= hangar.length && hangar[chooseShip] != null)
                {
                    hangar[chooseShip].setHp(hangar[chooseShip].getMaxHp());
                    money -= 3000;
                    System.out.println(hangar[chooseShip].getName()+ " has been repaired. Current hp = " + hangar[chooseShip].getMaxHp());
                    System.out.println("Account balance: " + money + " Star Bucks");
                }

                else
                {
                    System.out.println("There is no ship in that spot.");
                }
            }
            catch(InputMismatchException exception)
            {
                System.out.println("Invalid input. Your ineptitude has been noted with disdain and you have been fired from Starfleet.");
                System.out.println("Exiting Program...");
                System.exit(0);
            }
        }
    }

    public void AddShip(Ship s)
    {
        if(money >= s.getPrice())
        {
            for(int i=0; i<hangar.length; i++)
            {
                if(hangar[i] == null)
                {
                    hangar[i] = s;
                    break;
                }
            }

            money -= s.getPrice();
        }
        else
        {
            System.out.println("You cannot buy this ship as you have insufficient funds.");
        }
    }

    public void DeleteShip() {

        for(int i=0; i<hangar.length; i++)
        {
            if(hangar[i] != null) {
                if (hangar[i].getHp() <= 0) {
                    System.out.println(hangar[i].getName() + "has been destroyed in space. It is no longer available.");
                    hangar[i] = null;
                }
            }
        }
    }

    public void DisplayFleet()
    {
        System.out.println("Star Bucks: "+ money);

        if(hangar[0] == null)
        {
            System.out.println("Your hangar is currently empty. Buy a ship from the main menu.");
        }

        for (int i = 0; i < hangar.length; i++)
        {
            if(hangar[i] != null)
            {
                System.out.println("==============");
                System.out.print((i+1)+": ");
                hangar[i].Details();
            }
        }
    }

    public Ship[] getHangar() {
        return hangar;
    }

    public void setHangar(Ship[] hangar) {
        this.hangar = hangar;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
