import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        QueueStudent q = new QueueStudent();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for(int t=0;t<n;t++){
            String input = sc.nextLine();
            // System.out.println(input);
            String[] event = input.split("\\s+");
            // printString(event);
            if(event[0].equals("SERVED")){
                q.dequeue();
            }
            else{
                q.insert(event[1],Float.parseFloat(event[2]),Integer.parseInt(event[3]));
            }
        }
        for(Student cur=q.head;cur!=null;cur=cur.next){
            System.out.println(cur.name + " " + cur.cgpa + " " + cur.token);
        }
    }
    static void printString(String[] event){
        for(int i = 0;i<event.length;i++){
            System.out.print(event[i]+" ");
        }
        System.out.println();
    }
}

class Student{
    String name;
    int token;
    float cgpa;
    Student next;
    Student prev;

    Student(String name, float cgpa, int token){
        this.name = name;
        this.cgpa = cgpa;
        this.token = token;
    }
    Student(){
    }
}

class QueueStudent{
    Student head;
    Student tail;

    void insert(Student student){
        if(head==null){
            head = student;
            tail = student;
            return;
        }
        for(Student cur = tail; cur!=null;){
            if(student.cgpa>cur.cgpa){
                cur = cur.prev;
                continue;
            }
            else if(student.cgpa==cur.cgpa){
                int nameComparison = student.name.compareTo(cur.name);
                if(nameComparison<0){
                    cur = cur.prev;
                    continue;
                }
                else if(nameComparison==0){
                    if(student.token<cur.token){
                        cur = cur.prev;
                        continue;
                    }
                    else{
                        insertAfter(cur, student);
                        return;
                    }
                }
                else{
                    insertAfter(cur, student);
                    return;
                }
            }
            else{
                insertAfter(cur, student);
                return;
            }  
        }
        student.next = head;
        student.prev = null;
        head.prev = student;
        head = student;
    }

    void insertAfter(Student cur, Student student){
        //cur can't be null
        student.next = cur.next;
        student.prev = cur;
        cur.next = student;
        if(student.next==null){
            tail = student;
        }
        else{
            student.next.prev = student;
        }
    }

    Student dequeue(){
        if(head==null){
            return null;
        }
        Student toReturn = head;
        head = head.next;
        if(head==null){
            tail=null;
        }
        else{
            head.prev=null;
        }
        return toReturn;
    }
    void insert(String name, float cgpa, int token){
        insert(new Student(name, cgpa, token));
    }

}