package com.nero.interview;

/**
 *  print 1 -> 100 in order
 *  
 *  thread a print n % 3 == 0;
 *  thread b print n % 5 == 0;
 *  thread c print other
 */
public class MultiThreadPrintNumberInOrder {

    public static class Task {

        private int number;
        private boolean finished;

        public Task(int number) {
            this.number = number;
            this.finished = false;
            this.finished = Boolean.FALSE;
        }

        public void runTask(WorkThread workThread) {
            System.out.println(workThread.getWorkName() + "\t" + number);
        }

        public void finish() {
            this.finished = true;
        }

        public boolean thisTaskFinished() {
            return this.finished;
        }
    }

    public static class WorkThread extends Thread {

        private String name;
        private boolean finished;
        private Task task;

        public WorkThread(String name) {
            this.name = name;
            this.finished = false;
        }

        public Task addTask(int number) throws InterruptedException {
            Task task = new Task(number);
            this.task = task;
            return task;
        }

        @Override
        public void run() {
            while (!finished) {
                if (null != this.task) {
                    this.task.runTask(this);
                    this.task.finish();
                    this.task = null;
                }

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public String getWorkName() {
            return name;
        }

        public void finish() {
            this.finished = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WorkThread workThreadA = new WorkThread("A");
        WorkThread workThreadB = new WorkThread("B");
        WorkThread workThreadC = new WorkThread("C");

        workThreadA.start();
        workThreadB.start();
        workThreadC.start();

        for (int i = 1; i <= 100; i++) {
            WorkThread chooseThread = null;

            if (i % 3 == 0) {
                chooseThread = workThreadA;
            }
            else if (i % 5 == 0) {
                chooseThread = workThreadB;
            }
            else {
                chooseThread = workThreadC;
            }

            Task task = chooseThread.addTask(i);

            while (!task.thisTaskFinished()) {
                Thread.sleep(10);
            }
        }

        workThreadA.finish();
        workThreadB.finish();
        workThreadC.finish();
    }
}
