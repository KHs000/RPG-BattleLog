

package rpg;

/**
 *
 * @author Felipe Rabelo
 */
public class Combate {
    
    
    public Combate () {}
    
    public int DanoFisico (int str, int weaponDam) {
        return (str * 10) + weaponDam;
    }
    
    public int DanoMagico (int wis, int weaponDam) {
        return (wis * 10) + weaponDam;
    }
    
    public int DefesaFisica (int vit, int armorBonus) {
        return (vit * 10) + armorBonus;
    }
    
    public int DefesaMagica (int wil, int armorBonus, int resElemental) {
        return (wil * 10) + armorBonus + resElemental;
    }
}
