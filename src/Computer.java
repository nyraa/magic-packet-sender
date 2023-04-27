class Computer
{
    String mac_str;
    byte[] mac;
    String name;
    int state; // 0: unknown, 1: off, 2: on
    public Computer(String mac, String name, int state)
    {
        this.mac_str = mac;
        this.mac = new byte[6];
        String[] mac_arr = mac.split(":");
        for (int i = 0; i < 6; i++)
        {
            this.mac[i] = (byte) Integer.parseInt(mac_arr[i], 16);
        }
        this.name = name;
        this.state = state;
    }
    public Computer(String mac, String name)
    {
        this.mac_str = mac;
        this.mac = new byte[6];
        String[] mac_arr = mac.split(":");
        for (int i = 0; i < 6; i++)
        {
            this.mac[i] = (byte) Integer.parseInt(mac_arr[i], 16);
        }
        this.name = name;
        this.state = 0;
    }
    public String getMacStr()
    {
        return this.mac_str;
    }
    public byte[] getMac()
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