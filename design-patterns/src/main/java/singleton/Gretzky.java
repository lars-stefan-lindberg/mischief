package singleton;

public enum Gretzky {
    INSTANCE;

    private int shootingPower;

    public int getShootingPower()  {
        return shootingPower;
    }

    public void setShootingPower(int shootingPower) {
        this.shootingPower = shootingPower;
    }
}
