// import java.io.*;
// import java.util.*;
//
// public class BuildingFile {
//
//
//         private Scanner parser;
//
//         public void openFile(){
//           try{
//             parser = new Scanner(new File("config.txt"));
//           }
//           catch(Exception e){
//             System.out.println("no file");
//           }
//         }
//         public void readFile(){
//           while(parser.hasNext()){
//             String a = parser.nextLine();
//             double b = parser.nextDouble();
//             double c = parser.nextDouble();
//             String d = parser.nextLine();
//             String e = parser.nextLine();
//
//         System.out.println(a);
//         System.out.println(b);
//         System.out.println(c);
//         System.out.println(d);
//         System.out.println(e);
//
// //            String lineRead = parser.nextLine();
// //            String[] lineReadSplit = lineread.split("\n");
//
//             Building buildingObj = new Building();
//             String a;setCoordinates(b, c);
//             String a;setBuildingName(d);
//             String a;setConnections(e);
//
//           }
//         }
//
//
//         public void closeFile(){
//           parser.close();
//         }
//
//
//           }
