package CollectionsInterview;

import java.util.LinkedList;
import java.util.Queue;
 
public class QueueQues {
 public static void main(String... args) {
  Queue q = new LinkedList();
  q.add("Delhi");
  q.add("Mumbai");
  q.add("Pune");
  show(q);
 }
 
 public static void show(Queue q) {
  q.add(new Integer(100));
  while (!q.isEmpty())
   System.out.print(q.poll() + " ");
 }
}