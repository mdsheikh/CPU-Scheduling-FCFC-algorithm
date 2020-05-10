
public class FCFS {

    public void fcfsExecution(int[] pid, int[] ai, int[] ti, int[] status, int[] ri, int[] tti, int t) {
        int currentPid = 0;
        for (int i = 0; i < pid.length; i++) {
            if (ri[i] != 0) {
                currentPid = i;
                break;
            }
        }

        ri[currentPid] = ri[currentPid] - 1;
        if (ri[currentPid] == 0) {
            status[currentPid] = 0;
        }

        tti[currentPid] = (t + 1) - ai[currentPid];

        System.out.println(pid[currentPid] + "    " + status[currentPid] + "   " + ai[currentPid] + "    " + ti[currentPid] + "    " + ri[currentPid] + "    " + tti[currentPid]+"\n");
    }
}
