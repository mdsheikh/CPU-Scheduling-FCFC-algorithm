
import java.util.Random;

public class Simulator {

    Random rand = new Random();
    private static int ai[];
    private int pid[];
    private static int ti[];
    private static int status[];
    private static int tti[];
    private static int ri[];
    private static int time = 0;

    public Simulator(int n, int k, int d, int v) {
    	randomGenerator c2= new randomGenerator();
        FCFS fcfs = new FCFS();
        int temp;

        pid = new int[n];
        ai = new int[n];
        ti = new int[n];
        ri = new int[n];
        tti = new int[n];
        status = new int[n];

        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            ai[i] =  (int)(c2.randomGaussianGiver()* k);
        }

        for (int i = 0; i < n; i++) {
            ti[i] = (int)((c2.randomGaussianGiver() * v) + d);
            ri[i] = ti[i];
        }

        for (int i = 0; i < n; i++) {
            status[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (ai[j] > ai[j + 1]) {
                    temp = ai[j];
                    ai[j] = ai[j + 1];
                    ai[j + 1] = temp;
                    temp = ti[j];
                    ti[j] = ti[j + 1];
                    ti[j + 1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ri[i] = ti[i];
        }

        System.out.print("\nPROCESS  ACTIVE  ARRIVAL_TIME  TOTAL_CPU_TIME  REMAINING_CPU_TIME  TRUNAROUND_TIME\n");

        while (!checkProcessesDone(ri)) {
            fcfs.fcfsExecution(pid, ai, ti, status, ri, tti, time);

            time++;
        }

        double att = 0.0;
        for (int i = 0; i < pid.length; i++) {
            att += tti[i];
        }

        System.out.println("Average Turnaround time: "+ att/pid.length);

    }
    public boolean checkProcessesDone(int [] ri) {
        for (int i = 0; i < ri.length; i++) {
            if (ri[i] != 0) {
                return false;
            }
        }
        return true;
    }


}
