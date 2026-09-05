package oop.class_problems;
public class HostelAllocation {
    static class HostelRoom {String roomNo;int beds,occupied;HostelRoom(String r,int b,int o){roomNo=r;beds=b;occupied=o;}void allot(String name){if(occupied<beds){occupied++;System.out.println(name+" allotted to room "+roomNo);}}}
    static HostelRoom findAvailableRoom(HostelRoom[] rooms){for(HostelRoom r:rooms)if(r!=null&&r.occupied<r.beds)return r;return null;}
    static void safeAllot(HostelRoom[] rooms,String studentName){HostelRoom r=findAvailableRoom(rooms);if(r==null)System.out.println("No rooms available for "+studentName);else r.allot(studentName);}
    public static void main(String[]a){HostelRoom[] r={new HostelRoom("C-214",3,2),new HostelRoom("C-507",2,2)};safeAllot(r,"Divya");safeAllot(r,"Divya");}
}