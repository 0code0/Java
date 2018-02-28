/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hopfield;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Hopfield extends JFrame implements ActionListener{

    public static final int NETWORK_SIZE = 4;

    JTextField matrix[][] = new JTextField[NETWORK_SIZE][NETWORK_SIZE];

    JComboBox input[] = new JComboBox[NETWORK_SIZE];

    JTextField Output[] = new JTextField[NETWORK_SIZE];

    JButton btnClean = new JButton("Clean");
    JButton btnTrain = new JButton("Train");
    JButton btnRun = new JButton("Run");

    public Hopfield() {

        setTitle("Hopfield Neural Network");

        JPanel connections = new JPanel();
        connections.setLayout(new GridLayout(NETWORK_SIZE, NETWORK_SIZE));

        for (int row = 0; row < NETWORK_SIZE; row++) {

            for (int col = 0; col < NETWORK_SIZE; col++) {

                matrix[row][col] = new JTextField(3);
                matrix[row][col].setText("0");
                connections.add(matrix[row][col]);

            }
        }

        Container content = getContentPane();

        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        content.setLayout(gridBag);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 1.0;

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.NORTHWEST;

        content.add(new Label("Weight Metrix for the Hopfield Neuron Network"), c);

        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = GridBagConstraints.REMAINDER;
        content.add(connections, c);
        c.gridwidth = 1;

        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridwidth = GridBagConstraints.REMAINDER;

        content.add(new Label("Click \"Train\" to  train the following pattern: "), c);

        String Option[] = {"0", "1"};

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        for (int i = 0; i < NETWORK_SIZE; i++) {

            input[i] = new JComboBox(Option);
            inputPanel.add(input[i]);
        }

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;
        
        content.add(inputPanel,c);

        
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridwidth = GridBagConstraints.REMAINDER;

        content.add(new Label("Click \"Run\" to see the output: "), c);

        JPanel outputpanel = new JPanel();
        outputpanel.setLayout(new FlowLayout());

        for (int i = 0; i < NETWORK_SIZE; i++) {

            Output[i] = new JTextField(3);
            Output[i].setEditable(false);
            outputpanel.add(Output[i]);
        }

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.anchor = GridBagConstraints.CENTER;

        content.add(outputpanel, c);

        JPanel btnpanel = new JPanel();

        btnClean = new JButton("Clear");
        btnTrain = new JButton("Train");
        btnRun = new JButton("Run");

        btnClean.addActionListener((ActionListener) this);
        btnTrain.addActionListener((ActionListener) this);
        btnRun.addActionListener((ActionListener) this);

        btnpanel.setLayout(new FlowLayout());
        btnpanel.add(btnClean);
        btnpanel.add(btnTrain);
        btnpanel.add(btnRun);

        content.add(btnpanel,c);

        pack();

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension d = toolkit.getScreenSize();

        setLocation((int) (d.width - this.getSize().getWidth()) / 2, (int) (d.height - this.getSize().getHeight()) / 2);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

   

    protected void run() {

        boolean pattern[] = new boolean[NETWORK_SIZE];
        int wt[][] = new int[NETWORK_SIZE][NETWORK_SIZE];

        for (int row = 0; row < NETWORK_SIZE; row++) {
            for (int col = 0; col < NETWORK_SIZE; col++) {
                wt[row][col] = Integer.parseInt(matrix[row][col].getText());

            }
        }

        for (int row = 0; row < NETWORK_SIZE; row++) {

            int i = input[row].getSelectedIndex();
            if (i == 0) {
                pattern[row] = false;
            } else {
                pattern[row] = true;
            }
        }

        Layer net = new Layer(wt);
        net.activation(pattern);

        for (int row = 0; row < NETWORK_SIZE; row++) {

            if (net.output[row]) {
                Output[row].setText("1");
            } else {
                Output[row].setText("0");
            }

            if (net.output[row] == pattern[row]) {
                Output[row].setBackground(java.awt.Color.green);
            } else {
                Output[row].setBackground(java.awt.Color.red);
            }

        }
    }

    protected void clear() {

        for (int row = 0; row < NETWORK_SIZE; row++) {
            for (int col = 0; col < NETWORK_SIZE; col++) {
                matrix[row][col].setText("0");
            }

        }

    }

    protected void Train() {

        int work[][] = new int[NETWORK_SIZE][NETWORK_SIZE];
        int bi[] = new int[NETWORK_SIZE];

        for (int x = 0; x < NETWORK_SIZE; x++) {
            if (input[x].getSelectedIndex() == 0) {
                bi[x] = -1;
            } else {
                bi[x] = 1;
            }
        }

        for (int row = 0; row < NETWORK_SIZE; row++) {
            for (int col = 0; col < NETWORK_SIZE; col++) {
                work[row][col] = bi[row] * bi[col];
            }
        }

        for (int x = 0; x < NETWORK_SIZE; x++) {
            work[x][x] -= 1;
        }

        for (int row = 0; row < NETWORK_SIZE; row++) {
            for (int col = 0; col < NETWORK_SIZE; col++) {
                int i = Integer.parseInt(matrix[row][col].getText());
                matrix[row][col].setText("" + (i + work[row][col]));
            }
        }
    }

    static public void main(String[] args) {

        JFrame f = new Hopfield();
        f.show();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRun) {
            run();
        } else if (e.getSource() == btnClean) {
            clear();
        } else if (e.getSource() == btnTrain) {
            Train();
        }
    }

    public class Layer {

        protected Neuron neuron[] = new Neuron[NETWORK_SIZE];
        protected boolean output[] = new boolean[NETWORK_SIZE];
        protected int neurons;
        public static final double lambda = 1.0;

        Layer(int weights[][]) {

            neurons = weights[0].length;

            neuron = new Neuron[neurons];
            output = new boolean[neurons];

            for (int i = 0; i < neurons; i++) {

                neuron[i] = new Neuron(weights[i]);

            }

        }

        public boolean threshold(int k) {

            double kk = k * lambda;

            double a = Math.exp(kk);
            double b = Math.exp(-kk);

            double tanh = (a - b) / (a + b);

            return (tanh > 0);

        }

        void activation ( boolean pattern[] ){
        
            int i,j;
            
            for(i=0;i<NETWORK_SIZE;i++){
            
                neuron[i].activation = neuron[i].act(pattern);
                output[i] = threshold(neuron[i].activation);
                
            }
        
        }
        
    }
    
    public class Neuron{
    
        public int Weightv[];
        public int activation;
        
        public Neuron( int in[] ){
        
            Weightv = in;
            
        }
        
        public int act(boolean x[]){
        
            int i;
            int a=0;
            
            for ( i=0; i<x.length;i++)
                if( x[i] )
                    a+=Weightv[i];
            return a;
        }
    }
}
