class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        Heal heal = new Heal(bandage[0], bandage[1], bandage[2]);

        int physical = health;
        int init = 0;
        int relay = 0;
        for(int i = 0 ;i < attacks.length; i++){
            int[] attack = attacks[i];
            int atk = attack[0];
            int dgm = attack[1];
            Attack a = new Attack(atk, dgm);

            for(int j = init+1 ;j<=a.attime; j++){
                if(j == a.attime){
                    relay = 0;
                    physical = physical - a.damage;
                    if(physical <= 0){
                        return -1;
                    }
                }else{
                   if(physical < health){
                       physical = physical+heal.healing;
                       relay =  relay+ 1;
                       if(relay == heal.skillTime){
                           relay = 0;
                           physical = physical+heal.addHealing;
                                                
                       }
                   if(physical > health){
                           physical = health;
                       }
                   }else {
                       relay = 0;
                   }
                }
                init = a.attime;
            }

        }
        answer = physical >= 0 ? physical:-1;
        return answer;
    }
}

class  Attack {
    int attime;
    int damage;


    public Attack(int attime, int damage){
        this.attime = attime;
        this.damage = damage;
    }
}

class  Heal {
    int skillTime;
    int healing;
    int addHealing;

    public Heal(int skillTime, int healing, int addHealing){
        this.skillTime = skillTime;
        this.healing = healing;
        this.addHealing = addHealing;
    }
}
