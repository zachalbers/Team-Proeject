// This class stores all of the building objects.
// It can return a building object from a name entered in.

// each point is 10 meters


public class AllBuildings {
// Creating Buildings

        String [] buildingNames = {"Science A", "Science B", "Mac Hall", "MacEwan Student Centre", "Kinesiology A", "Kinesiology B",
          "Hotel Alma", "Olympic Oval", "Calgary Centre for Innovative Technology", "Schulich School of Engineering A-G",
          "Information and Communication Technologies", "Earth Science", "Math Science", "Science Theatres", "Social Science",
          "Administration", "Professional Faculties", "Education Classroom Block", "Education Tower"};

        public Building buildings(String name) {

                // Default building if there is an error
                Building Default = new Building();


                // Creating all the buildings

                Building Science_B = new Building();
                Science_B.setCoordinates(80, 49);
                Science_B.setBuildingName("Science B");
                Science_B.setConnections("Mac Hall,Science A,Earth Science");
                Science_B.setWidth(8);
                Science_B.setLength(10);
                Science_B.setAbbreviation("SB");

                Building Mac_Hall = new Building();
                Mac_Hall.setCoordinates(70, 41);
                Mac_Hall.setBuildingName("Mac Hall");
                Mac_Hall.setConnections("MacEwan Student Centre,Science B");
                Mac_Hall.setWidth(8);
                Mac_Hall.setLength(5);
                Mac_Hall.setAbbreviation("MC");

                Building MacEwan_Student_Centre = new Building();
                MacEwan_Student_Centre.setCoordinates(57, 37);
                MacEwan_Student_Centre.setBuildingName("MacEwan Student Centre");
                MacEwan_Student_Centre.setConnections("Mac Hall,Kinesiology B");
                MacEwan_Student_Centre.setWidth(17);
                MacEwan_Student_Centre.setLength(5);
                MacEwan_Student_Centre.setAbbreviation("MSC");

                Building Kinesiology_B = new Building();
                Kinesiology_B.setCoordinates(38, 34);
                Kinesiology_B.setBuildingName("Kinesiology B");
                Kinesiology_B.setConnections("MacEwan Student Centre,Kinesiology A,Olympic Oval");
                Kinesiology_B.setWidth(17);
                Kinesiology_B.setLength(8);
                Kinesiology_B.setAbbreviation("KNB");

                Building Kinesiology_A = new Building();
                Kinesiology_A.setCoordinates(44, 27);
                Kinesiology_A.setBuildingName("Kinesiology A");
                Kinesiology_A.setConnections("Kinesiology B,Hotel Alma");
                Kinesiology_A.setWidth(16);
                Kinesiology_A.setLength(8);
                Kinesiology_A.setAbbreviation("KNA");

                Building Hotel_Alma = new Building();
                Hotel_Alma.setCoordinates(46, 16);
                Hotel_Alma.setBuildingName("Hotel Alma");
                Hotel_Alma.setConnections("Kinesiology A");
                Hotel_Alma.setWidth(3);
                Hotel_Alma.setLength(13);
                Hotel_Alma.setAbbreviation("HA");

                Building Olympic_Oval = new Building();
                Olympic_Oval.setCoordinates(18, 25);
                Olympic_Oval.setBuildingName("Olympic Oval");
                Olympic_Oval.setConnections("Kinesiology B");
                Olympic_Oval.setWidth(12);
                Olympic_Oval.setLength(15);
                Olympic_Oval.setAbbreviation("OO");

                Building Calgary_Centre_for_Innovative_Technology = new Building();
                Calgary_Centre_for_Innovative_Technology.setCoordinates(40, 60);
                Calgary_Centre_for_Innovative_Technology.setBuildingName("Calgary Centre for Innovative Technology");
                Calgary_Centre_for_Innovative_Technology.setConnections("Schulich School of Engineering A-G");
                Calgary_Centre_for_Innovative_Technology.setWidth(4);
                Calgary_Centre_for_Innovative_Technology.setLength(10);
                Calgary_Centre_for_Innovative_Technology.setAbbreviation("CCIT");

                Building Schulich_School_of_Engineering_A_G = new Building();
                Schulich_School_of_Engineering_A_G.setCoordinates(55, 59);
                Schulich_School_of_Engineering_A_G.setBuildingName("Schulich School of Engineering A-G");
                Schulich_School_of_Engineering_A_G.setConnections("Calgary Centre for Innovative Technology,Information and Communication Technologies");
                Schulich_School_of_Engineering_A_G.setWidth(15);
                Schulich_School_of_Engineering_A_G.setLength(19);
                Schulich_School_of_Engineering_A_G.setAbbreviation("ENG A-G");

                Building Information_and_Communication_Technologies = new Building();
                Information_and_Communication_Technologies.setCoordinates(72, 57);
                Information_and_Communication_Technologies.setBuildingName("Information and Communication Technologies");
                Information_and_Communication_Technologies.setConnections("Schulich School of Engineering A-G,Earth Science");
                Information_and_Communication_Technologies.setWidth(6);
                Information_and_Communication_Technologies.setLength(5);
                Information_and_Communication_Technologies.setAbbreviation("ICT");

                Building Earth_Science = new Building();
                Earth_Science.setCoordinates(84, 58);
                Earth_Science.setBuildingName("Earth Science");
                Earth_Science.setConnections("Information and Communication Technologies,Science B,Math Science");
                Earth_Science.setWidth(6);
                Earth_Science.setLength(7);
                Earth_Science.setAbbreviation("ES");

                Building Science_A = new Building();
                Science_A.setCoordinates(93, 54);
                Science_A.setBuildingName("Science A");
                Science_A.setConnections("Science B,Science Theatres");
                Science_A.setWidth(5);
                Science_A.setLength(12);
                Science_A.setAbbreviation("SA");

                Building Math_Science = new Building();
                Math_Science.setCoordinates(96, 55);
                Math_Science.setBuildingName("Math Science");
                Math_Science.setConnections("Earth Science,Science Theatres");
                Math_Science.setWidth(3);
                Math_Science.setLength(9);
                Math_Science.setAbbreviation("MS");

                Building Science_Theatres = new Building();
                Science_Theatres.setCoordinates(102, 51);
                Science_Theatres.setBuildingName("Science Theatres");
                Science_Theatres.setConnections("Math Science,Science A,Social Science");
                Science_Theatres.setWidth(5);
                Science_Theatres.setLength(13);
                Science_Theatres.setAbbreviation("ST");

                Building Social_Science = new Building();
                Social_Science.setCoordinates(105, 46);
                Social_Science.setBuildingName("Social Science");
                Social_Science.setConnections("Science Theatres,Science A,Administration");
                Social_Science.setWidth(3);
                Social_Science.setLength(5);
                Social_Science.setAbbreviation("SS");

                Building Administration = new Building();
                Administration.setCoordinates(103, 37);
                Administration.setBuildingName("Administration");
                Administration.setConnections("Social Science,Professional Faculties");
                Administration.setWidth(5);
                Administration.setLength(8);
                Administration.setAbbreviation("AD");

                Building Professional_Faculties = new Building();
                Professional_Faculties.setCoordinates(106, 29);
                Professional_Faculties.setBuildingName("Professional Faculties");
                Professional_Faculties.setConnections("Administration,Education Classroom Block");
                Professional_Faculties.setWidth(4);
                Professional_Faculties.setLength(14);
                Professional_Faculties.setAbbreviation("PF");

                Building Education_Classroom_Block = new Building();
                Education_Classroom_Block.setCoordinates(109, 22);
                Education_Classroom_Block.setBuildingName("Education Classroom Block");
                Education_Classroom_Block.setConnections("Professional Faculties,Education Tower");
                Education_Classroom_Block.setWidth(2);
                Education_Classroom_Block.setLength(5);
                Education_Classroom_Block.setAbbreviation("EDC");

                Building Education_Tower = new Building();
                Education_Tower.setCoordinates(114, 26);
                Education_Tower.setBuildingName("Education Tower");
                Education_Tower.setConnections("Education Classroom Block");
                Education_Tower.setWidth(2);
                Education_Tower.setLength(3);
                Education_Tower.setAbbreviation("EDT");




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
                        case "Schulich School of Engineering A-G": return Schulich_School_of_Engineering_A_G;
                        case "Information and Communication Technologies": return Information_and_Communication_Technologies;
                        case "Earth Science" :return Earth_Science;
                        case "Math Science" :return Math_Science;
                        case "Science Theatres" :return Science_Theatres;
                        case "Social Science" :return Social_Science;
                        case "Administration" : return Administration;
                        case "Professional Faculties" : return Professional_Faculties;
                        case "Education Classroom Block" : return Education_Classroom_Block;
                        case "Education Tower" : return Education_Tower;
                        default:
                                return Default;
                }




        }
}
