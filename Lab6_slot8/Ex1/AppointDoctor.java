package Lab6_slot8.Ex1;

import java.util.PriorityQueue;
public class AppointDoctor {
    public AppointDoctor() {

    }
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        Doctor Cardiologist = new Doctor("Casuality",1);
        Doctor Gynecologist = new Doctor("Surgery", 2);
        Doctor Paediatric = new Doctor("Routine Chek-up", 3);

        pq.offer(Cardiologist);
        pq.offer(Gynecologist);
        pq.offer(Paediatric);

        while (!pq.isEmpty()){
            System.out.println("\nApplicating doctors based on their prioryties: ");
            System.out.println("****************************************************************");

            Doctor doctor = ((Doctor) pq.remove());

            System.out.println(doctor.toString());
        }
    }
}
