public class AttackLock {
    private int attackLock;
    private int playerX;
    private int playerY;
    private int attackedFieldX;
    private int attackedFieldY;

    public AttackLock(){
        attackLock = 0;
    }

    public int getAttackLock() {
        return attackLock;
    }

    public void setAttackLock(int attackLock) {
        this.attackLock = attackLock;
    }


    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getAttackedFieldX() {
        return attackedFieldX;
    }

    public void setAttackedFieldX(int attackedFieldX) {
        this.attackedFieldX = attackedFieldX;
    }

    public int getAttackedFieldY() {
        return attackedFieldY;
    }

    public void setAttackedFieldY(int attackedFieldY) {
        this.attackedFieldY = attackedFieldY;
    }
}
