import javax.swing.*;

public class ResultFrame extends JFrame{
    private static ResultFrame instance = new ResultFrame();

    JLabel spmLabel;

    ResultFrame(){
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(ScreenHandler.getInstance().getScaledScreenWidth(), ScreenHandler.getInstance().getScaledScreenHeight());
        spmLabel = new JLabel();
        spmLabel.setAlignmentY(CENTER_ALIGNMENT);

        this.add(spmLabel);

    }

    public void showFrame() {
        this.setVisible(true);
    }

    public void setSpm(double spm){
       spmLabel.setText(Double.toString(spm));
    }

    public double getSpm(){
        return Double.valueOf(spmLabel.getText());
    }

    public static ResultFrame getInstance(){
        return instance;
    }
}
