// This class stores all of the building objects.
// It can return a building object from a name entered in.

// each point is 10 meters


public class AllBuildings {
// Creating Buildings

        public Building buildings(String name) {

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
                Kinesiology_B.setConnections("MacEwan Student Centre,Kinesiology A,Olympic Oval");

                Building Kinesiology_A = new Building();
                Kinesiology_A.setCoordinates(1331, 772);
                Kinesiology_A.setBuildingName("Kinesiology A");
                Kinesiology_A.setConnections("Kinesiology B,Hotel Alma");

                Building Hotel_Alma = new Building();
                Hotel_Alma.setCoordinates(1329, 761);
                Hotel_Alma.setBuildingName("Hotel Alma");
                Hotel_Alma.setConnections("Kinesiology A");

                Building Olympic_Oval = new Building();
                Olympic_Oval.setCoordinates(1357, 770);
                Olympic_Oval.setBuildingName("Olympic Oval");
                Olympic_Oval.setConnections("Kinesiology B");

                Building Calgary_Centre_for_Innovative_Technology = new Building();
                Calgary_Centre_for_Innovative_Technology.setCoordinates(0,0);
                Calgary_Centre_for_Innovative_Technology.setBuildingName("Calgary Centre for Innovative Technologie");
                Calgary_Centre_for_Innovative_Technology.setConnections("Schulich School of Engineering A-G");

                Building Schulich_School_of_Engineering_A_G = new Building();
                Schulich_School_of_Engineering_A_G.setCoordinates(0,0);
                Schulich_School_of_Engineering_A_G.setBuildingName("Schulich School of Engineering A-G");
                Schulich_School_of_Engineering_A_G.setConnections("Calgary Centre for Innovative Technologie,Information & Communication Technologies");

                Building Information_and_Communication_Technologies = new Building();
                Information_and_Communication_Technologies.setCoordinates(0,0);
                Information_and_Communication_Technologies.setBuildingName("Information & Communication Technologies");
                Information_and_Communication_Technologies.setConnections("Schulich School of Engineering A-G,Earth Science");

                Building Earth_Science = new Building();
                Earth_Science.setCoordinates(0,0);
                Earth_Science.setBuildingName("Earth Science");
                Earth_Science.setConnections("Information & Communication Technologies,Science B Building, Math Science");

                Building Math_Science = new Building();
                Math_Science.setCoordinates(0,0);
                Math_Science.setBuildingName("Math Science");
                Math_Science.setConnections("Earth Science,Science Theatres");

                Building Science_Theatre = new Building();
                Science_Theatre.setCoordinates(0,0);
                Science_Theatre.setBuildingName("Science Theatre");
                Science_Theatre.setConnections("Math Science,Science A Building,Social Science, Biological Science");

                Building Social_Science = new Building();
                Social_Science.setCoordinates(0,0);
                Social_Science.setBuildingName("Social Science");
                Social_Science.setConnections("Science Theatre,Science A Building,Biological Science, Administration");

                Building Administration = new Building();
                Administration.setCoordinates(0,0);
                Administration.setBuildingName("Administration");
                Administration.setConnections("Social Science,Professional Faculties");

                Building Professional_Faculties = new Building();
                Professional_Faculties.setCoordinates(0,0);
                Professional_Faculties.setBuildingName("Professional Faculties");
                Professional_Faculties.setConnections("Administration,Education Classroom Block");

                Building Education_Classroom_Block = new Building();
                Education_Classroom_Block.setCoordinates(0,0);
                Education_Classroom_Block.setBuildingName("Education Classroom Block");
                Education_Classroom_Block.setConnections("Professional Faculties,Education Tower");

                Building Education_Tower = new Building();
                Education_Tower.setCoordinates(0,0);
                Education_Tower.setBuildingName("Education Tower");
                Education_Tower.setConnections("Education Classroom Block,Scurfield Hall");




                // returning an object based on the input
                switch (name) {
                        case "Science A": return Science_A;
                        case "Science B": return Science_B;
                        case "Mac Hall": return Mac_Hall;
                        case "MacEwan Student Centre": return MacEwan_Student_Centre;
                        case "Kinesiology A": return Kinesiology_A;
                        case "Kinesiology B": return Kinesiology_B;
                        case "Hotel Alma": return Hotel_Alma;
                        case "Olympic Oval": return Olympic_Oval;
                        case "Calgary Centre for Innovative Technology": return Calgary_Centre_for_Innovative_Technology;
                        case "Schulich_School_of_Engineering_A_G": return Schulich_School_of_Engineering_A_G;
                        case "Information_and_Communication_Technologies": return Information_and_Communication_Technologies;
                        case "Earth_Science" :return Earth_Science;
                        case "Math_Science" :return Math_Science;
                        case "Science_Theatre" :return Science_Theatre;
                        case "Social_Science" :return Social_Science;
                        case "Administration" : return Administration;
                        case "Professional_Faculties" : return Professional_Faculties;
                        case "Education_Classroom_Block" : return Education_Classroom_Block;
                        case "Education_Tower" : return Education_Tower;
                        default:
                                return Default;
                }




        }
}
