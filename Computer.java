class Computer
{
    String mac;
    String name;
    int state; // 0: unknown, 1: off, 2: on
    public Computer(String mac, String name, int state)
    {
        this.mac = mac;
        this.name = name;
        this.state = state;
    }
    public Computer(String mac, String name)
    {
        this.mac = mac;
        this.name = name;
        this.state = 0;
    }
    public String getMac()
    {
        return this.mac;
    }
    public String getName()
    {
        return this.name;
    }
    public int getState()
    {
        return this.state;
    }
    public void setState(int state)
    {
        this.state = state;
    }
}