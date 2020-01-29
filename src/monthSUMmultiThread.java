import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class monthSUMmultiThread implements Runnable {
	
    private int intArrayRowMax = 100000;
    private int intArrayColumnMax = 11;
    private JTable table;
    private JProgressBar progressBar;
    private int[][] intArray = new int[intArrayRowMax][intArrayColumnMax];
    private int[][] intSum = new int[intArrayRowMax][intArrayColumnMax];

    @Override
    public void run() {
    	Thread t = Thread.currentThread();
        System.out.println("Thread started: "+t.getName());
        try {
            Thread.sleep(1000);
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            Object intArrayTemp[] = new Object[intArrayColumnMax];
            int i = 1;
            int intSumIndex = 0;
            intSum[0] = intArray[0];
            while (i < intArrayRowMax && intArray[i][0] != 0)
    		{
            	if(intArray[i][0] == intArray[i-1][0] && intArray[i][1] == intArray[i-1][1] )
            	{
            		intSum[intSumIndex][0] = intArray[i-1][0];
            		intSum[intSumIndex][1] = intArray[i-1][1];
            		for(int j = 2; j < intArrayColumnMax; j++)
            		{
            			intSum[intSumIndex][j] = intSum[intSumIndex][j] + intArray[i][j];
            		}
            	}
            	else
            	{
            		intSumIndex++;
            		intSum[intSumIndex] = intArray[i];
            	}
            	i++;
    		}
            i = 0;
            progressBar.setMaximum(intSumIndex);
            while (i < intArrayRowMax && intSum[i][0] != 0)
            	{
                	for (int j = 0; j < intArrayColumnMax; j++)
        			{
                		intArrayTemp[j] = intSum[i][j];
        			}
                	model.addRow(intArrayTemp);
                	progressBar.setValue(i);
                	i++;
                	Thread.sleep(100);
            	}
            progressBar.setValue(intArrayRowMax);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Thread ended: "+t.getName());
        
    }
    public void setValue(int tempArray[][])
    {
   	 intArray = tempArray;
    }
    
    public void setPanel(JTable tableTemp,JProgressBar progressBarTemp)
    {
   	 table = tableTemp;
   	 progressBar = progressBarTemp;
    }
}
