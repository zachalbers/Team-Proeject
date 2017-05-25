// This class stores all of the building objects.
// It can return a building object from a name entered in.



public class AllBuildings {
// Creating Buildings

        public static Building buildings(String name) {

                // Default building if there is an error
                Building Default = new Building();


                // Creating all the buildings
                Building Science_A = new Building();
                Science_A.setCoordinates(1282, 799 );
                Science_A.setBuildingName("Science A");
                Science_A.setConnections("Science B");

                Building Science_B = new Building();
                Science_B.setCoordinates(1295, 794);
                Science_B.setBuildingName("Science B");
                Science_B.setConnections("Mac Hall,Science A");

                Building Mac_Hall = new Building();
                Mac_Hall.setCoordinates(1305, 786 );
                Mac_Hall.setBuildingName("Mac Hall");
                Mac_Hall.setConnections("MacEwan Student Centre,Science B");

                Building MacEwan_Student_Centre = new Building();
                MacEwan_Student_Centre.setCoordinates(1318, 782);
                MacEwan_Student_Centre.setBuildingName("MacEwan Student Centre");
                MacEwan_Student_Centre.setConnections("Mac Hall,Kinesiology B");

                Building Kinesiology_B = new Building();
                Kinesiology_B.setCoordinates(1337, 779);
                Kinesiology_B.setBuildingName("Kinesiology B");
                Kinesiology_B.setConnections("MacEwan Student Centre,Kinesiology A");

                Building Kinesiology_A = new Building();
                Kinesiology_A.setCoordinates(1331, 772);
                Kinesiology_A.setBuildingName("Kinesiology A");
                Kinesiology_A.setConnections("Kinesiology B,Hotel Alma");

                Building Hotel_Alma = new Building();
                Hotel_Alma.setCoordinates(1329, 761);
                Hotel_Alma.setBuildingName("Hotel Alma");
                Hotel_Alma.setConnections("Kinesiology A");




                // returning an object based on the input
                switch (name) {
                        case "Science A": return Science_A;
                        case "Science B": return Science_B;
                        case "Mac Hall": return Mac_Hall;
                        case "MacEwan Student Centre": return MacEwan_Student_Centre;
                        case "Kinesiology A": return Kinesiology_A;
                        case "Kinesiology B": return Kinesiology_B;
                        case "Hotel Alma": return Hotel_Alma;
                        default:
                                return Default;
                }




        }
}
