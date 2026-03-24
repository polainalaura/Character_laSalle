//creacion del personaje
public class Personaje {

    private String Name;
    private int level;
    private int experience;
//datos para la clase de personaje
    public Personaje(String name, int level, int experience) {
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }


    public int getExperience() {
        return experience;
    }
    
//salida de datos
    @Override
    public String toString() {
        return name + " | Nivel: " + level + " | Exp: " + experience;
    }
}
