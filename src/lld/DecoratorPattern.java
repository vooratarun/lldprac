package lld;

interface Character {
    String getAbilities();
}

class Mario implements Character {
    public String getAbilities() {
        return "lld.Mario";
    }
}

abstract class CharacterDecorator implements Character {
    protected Character character;

    public CharacterDecorator(Character c) {
        this.character = c;
    }
}

class HeightUp extends CharacterDecorator {
    public HeightUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + " with lld.HeightUp";
    }
}

class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Gun";
    }
}

class StarPowerUp extends CharacterDecorator {
    public StarPowerUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + " with Star Power (Limited Time)";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {

        Character mario = new Mario();
        System.out.println("Basic lld.Character: " + mario.getAbilities());

        mario = new HeightUp(mario);
        System.out.println("After lld.HeightUp: " + mario.getAbilities());

        mario = new GunPowerUp(mario);
        System.out.println("After lld.GunPowerUp: " + mario.getAbilities());

        mario = new StarPowerUp(mario);
        System.out.println("After lld.StarPowerUp: " + mario.getAbilities());

    }
}