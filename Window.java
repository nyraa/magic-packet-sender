import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

class Window extends JFrame {
    public Window() {
        super("wake on lan");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        // a select list of mac address on the top, some button on the bottom
        JPanel top = new JPanel();
        top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
        // add jlist of mac address to the top
        Vector<Computer> computers = DataLoader.readCSV("config.csv");
        JList macList = new JList(computers);
        macList.setCellRenderer(new MacListCellRenderer());
        macList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        macList.setLayoutOrientation(JList.VERTICAL);
        macList.setVisibleRowCount(-1);
        JScrollPane macListScroller = new JScrollPane(macList);
        macListScroller.setPreferredSize(new Dimension(250, 80));
        top.add(macListScroller);

        // add the bottom to the pane
        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
        // add the buttons to the bottom
        JButton add = new JButton("add");
        JButton remove = new JButton("remove");
        JButton wake = new JButton("wake");
        // add event to wake and print selected mac to console
        wake.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                byte[] mac = ((Computer)macList.getSelectedValue()).getMac();
                String mac_str = ((Computer)macList.getSelectedValue()).getMacStr();
                System.out.println(mac_str);
                try {
                    Magic.sendMagicPacket(mac);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        bottom.add(add);
        bottom.add(remove);
        bottom.add(wake);

        // add the top and bottom to the pane
        pane.add(top);
        pane.add(bottom);
        // add the pane to the window
        add(pane);
        // make the window visible
        
        setVisible(true);
    }
}
class MacListCellRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list,
                                 Object value,
                                 int index,
                                 boolean isSelected,
                                 boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Computer) {
            Computer computer = (Computer) value;
            setText(computer.getName() + " (" + computer.getMacStr() + ")");
        }
        return this;
    }
}