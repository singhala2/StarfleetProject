public class Ship {

    private String name;
    private int hp = 100;
    private int maxHp = 100;
    private int firepower;
    private int price;

    Ship()
    {
        name = "Enterprise";
        hp = 100;
        maxHp = 100;
        firepower = 10;
        price = 8000;
    }

    Ship(String _name, int _hp, int _firepower, int _price)
    {
        name = _name;
        hp = _hp;
        maxHp = _hp;
        firepower = _firepower;
        price = _price;
    }

    public void Details()
    {
        System.out.println(name+", Health: "+hp+"/"+maxHp);
        System.out.println("Firepower: "+ firepower);
        System.out.println("Price: "+ price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getFirepower() {
        return firepower;
    }

    public void setFirepower(int firepower) {
        this.firepower = firepower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
