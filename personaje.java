
public class Personaje {

    private String Name;
    private int level;
    private int experience;


    public Personaje(String name, int level, int experience) {
        this.Name = name;
        this.level = level;

    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }


    public int getExperience() {
        return level;
    }

    @Override
    public String toString() {

        return nombre + " | Nivel: " + level + " | Exp: " + experience;
    }
}
