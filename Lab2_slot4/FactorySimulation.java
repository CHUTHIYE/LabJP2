package Lab2_slot4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FactorySimulation {
    public static void main(String[] args) {
        BlockingQueue<String> taskList = new LinkedBlockingQueue<>();
        ManagerThread manager = new ManagerThread(taskList);
        manager.start();

        int numWorkers = 5;
        List<WorkerThread> workers = new ArrayList<>();
        for (int i = 0; i < numWorkers; i++) {
            WorkerThread worker = new WorkerThread(taskList);
            worker.start();
            workers.add(worker);
        }
    }
}

class ManagerThread extends Thread {
    private BlockingQueue<String> taskList;

    public ManagerThread(BlockingQueue<String> taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                String newTask = generateNewTask();
                taskList.put(newTask);
                System.out.println("Manager added task: " + newTask);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateNewTask() {
        int taskNum = (int) (Math.random() * 10) + 1;
        return "Task " + taskNum;
    }
}

class WorkerThread extends Thread {
    private BlockingQueue<String> taskList;

    public WorkerThread(BlockingQueue<String> taskList) {
        this.taskList = taskList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String task = taskList.take();
                System.out.println("Worker " + this.getId() + " took task: " + task);
                carryOutTask(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void carryOutTask(String task) {
        try {
            Thread.sleep(3000);
            System.out.println("Worker " + this.getId() + " completed task: " + task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
