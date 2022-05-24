package com.example.cumminsnavigator;

import java.util.ArrayList;

/**
 * 6
 * 0: Comp and E&TC
 * 1: IT
 * 2: Mech
 * 3: MBA
 * 4: Canteen
 * 5: Instru 1 ie near main gate
 * 6: Instru 2 ie near canteen
 * 7: Mechatronics
 * 8: Main Gate
 * 9: Back Gate to lane 1
 * 10: Back gate to lane 2
 */
public class MakeMap extends map { // hardcoding data

    public void create() {
        for (int i = 0; i < 11; i++)
            graph.add(new ArrayList<node>());

        // adjacent nodes of vertex 0 ie comp building
        graph.get(0).add(new node(1, 45));// IT
        graph.get(0).add(new node(2, 90));// Mech
        graph.get(0).add(new node(3, 60));// MBA
        graph.get(0).add(new node(4, 70));// Canteen
        graph.get(0).add(new node(5, 10));// Instru 1
        // graph.get(0).add(new node(6, 40));//Instru 2
        graph.get(0).add(new node(8, 40));// Main gate

        for (node n : graph.get(0)) {
            n.name = "Main-Building";
        }

        // adjacent nodes of vertex 1 ie IT building
        graph.get(1).add(new node(0, 45));// comp
        graph.get(1).add(new node(2, 40));// mech
        graph.get(1).add(new node(3, 50));// mba
        graph.get(1).add(new node(4, 40));// canteen
        // graph.get(1).add(new node(5, 50));//instru 1
        graph.get(1).add(new node(6, 60));// instru 2
        // graph.get(1).add(new node(8, 60));//main gate

        for (node n : graph.get(1)) {
            n.name = "IT-Building";
        }

        // adjacent nodes of vertex 2 ie mech building
        graph.get(2).add(new node(0, 90));// comp
        graph.get(2).add(new node(1, 40));// it
        graph.get(2).add(new node(3, 65));// mba
        graph.get(2).add(new node(4, 100));// canteen
        graph.get(2).add(new node(5, 100));// instru 1
        graph.get(2).add(new node(6, 90));// instru 2
        graph.get(2).add(new node(8, 110));// main gate

        for (node n : graph.get(2)) {
            n.name = "Mechanical-Building";
        }

        // adjacent nodes of vertex 3 ie mba building
        graph.get(3).add(new node(0, 60));// comp
        graph.get(3).add(new node(1, 50));// it
        graph.get(3).add(new node(2, 65));// mech
        graph.get(3).add(new node(4, 10));// canteen
        graph.get(3).add(new node(5, 60));// instru 1
        graph.get(3).add(new node(6, 20));// instru 2
        graph.get(3).add(new node(8, 90));// main gate

        for (node n : graph.get(3)) {
            n.name = "MBA-Building";
        }

        // adjacent nodes of vertex 4 ie canteen
        graph.get(4).add(new node(0, 70));// comp
        graph.get(4).add(new node(1, 40));// it
        graph.get(4).add(new node(2, 100));// mech
        graph.get(4).add(new node(3, 10));// mba
        graph.get(4).add(new node(5, 60));// instru 1
        graph.get(4).add(new node(6, 10));// instru 2
        graph.get(4).add(new node(8, 100));// main gate

        for (node n : graph.get(4)) {
            n.name = "Canteen";
        }

        // adjacent nodes of vertex 5 ie instru front gate
        graph.get(5).add(new node(0, 10));// comp
        graph.get(5).add(new node(1, 50));// it
        graph.get(5).add(new node(2, 100));// mech
        graph.get(5).add(new node(3, 60));// mba
        graph.get(5).add(new node(4, 60));// canteen
        graph.get(5).add(new node(6, 10));// instru 2
        graph.get(5).add(new node(8, 40));// main gate

        for (node n : graph.get(5)) {
            n.name = "Instrumentation-Building";
        }
        // adjacent nodes of vertex 6 ie instru back gate
        // graph.get(6).add(new node(0, 10));//comp
        graph.get(6).add(new node(1, 60));// it
        graph.get(6).add(new node(2, 90));// mech
        graph.get(6).add(new node(3, 20));// mba
        graph.get(6).add(new node(4, 10));// canteen
        graph.get(6).add(new node(5, 10));// instru 1
        // graph.get(6).add(new node(5, 10));//main gate
        for (node n : graph.get(6)) {
            n.name = "Instrumentation-Building(Back-Gate)";
        }

        graph.get(7).add(new node(0, 0));
        graph.get(7).get(0).name = "Mechatronics";

        // adjacent nodes of node 8 ie main gate
        graph.get(8).add(new node(0, 40));// comp
        // graph.get(8).add(new node(1, 60));//it
        graph.get(8).add(new node(2, 110));// mech
        graph.get(8).add(new node(3, 90));// mba
        graph.get(8).add(new node(4, 100));// canteen
        graph.get(8).add(new node(5, 40));// instru 1
        // graph.get(8).add(new node(0, 40));//instru 2

        for (node n : graph.get(8)) {
            n.name = "Main-Gate";
        }
        // adjacent nodes for node 9 ie back gate to lane 1
        graph.get(9).add(new node(0, 110));// comp
        graph.get(9).add(new node(2, 40));// mech back gate

        for (node n : graph.get(9)) {
            n.name = "Lane1-Gate";
        }

        // adjacent nodes to vertex 10 ie back gate to lane 2
        graph.get(10).add(new node(2, 100));// mech
        graph.get(10).add(new node(3, 70));// mba
        graph.get(10).add(new node(4, 70));// canteen
        graph.get(10).add(new node(0, 160));// comp
        graph.get(10).add(new node(1, 100));// it

        for (node n : graph.get(10)) {
            n.name = "Lane2-Gate";
        }
    }

    public void addRooms() {

        for (node n : graph.get(0)) {
            // ground floor
            n.rooms.get(0).add("OOP Lab");
            n.rooms.get(0).add("Software Lab 2");
            n.rooms.get(0).add("Software Lab 5");

            // 1st floor
            n.rooms.get(1).add("Accounts and Admin Section");
            n.rooms.get(1).add("Reception");
            n.rooms.get(1).add("Principals Cabin");
            n.rooms.get(1).add("Classroom 7");
            n.rooms.get(1).add("Classroom 6");
            n.rooms.get(1).add("Classroom 5");
            n.rooms.get(1).add("Classroom 4");
            n.rooms.get(1).add("Classroom 3");
            n.rooms.get(1).add("Classroom 2");
            n.rooms.get(1).add("Classroom 1");
            n.rooms.get(1).add("Dean academics");

            // 2nd floor

            n.rooms.get(2).add("Classroom 9");
            n.rooms.get(2).add("Classroom 8");
            n.rooms.get(2).add("CT Lab");
            n.rooms.get(2).add("Classroom 10");
            n.rooms.get(2).add("Classroom 11");
            n.rooms.get(2).add("Classroom 12");
            n.rooms.get(2).add("Classroom 13");
            n.rooms.get(2).add("Classroom 14");

            // 3rd floor
            n.rooms.get(3).add("Stationary");
            n.rooms.get(3).add("Reading Hall");
            n.rooms.get(3).add("Discussion Zone");
            n.rooms.get(3).add("Hardware Laboratory 1");
            n.rooms.get(3).add("Computer Networks Laboratory");
            n.rooms.get(3).add("Library");

            // 4th floor
            n.rooms.get(4).add("Computer lab 1");
            n.rooms.get(4).add("Computer lab 2");
            n.rooms.get(4).add("Computer lab 3");
            n.rooms.get(4).add("Computer lab 4");
            n.rooms.get(4).add("Project Lab");
            n.rooms.get(4).add("Basic Electronics Lab");
            n.rooms.get(4).add("Analog Electronics Lab");
            n.rooms.get(4).add("Power Electronics Lab");
            n.rooms.get(4).add("Communication Lab");
            n.rooms.get(4).add("Fibre Optic Communication Lab");

            //5th floor
            n.rooms.get(5).add("Software Lab 4");
            n.rooms.get(5).add("Multimedia Lab");
            n.rooms.get(5).add("Hardware Lab 2");
            n.rooms.get(5).add("Software Lab 3");
            n.rooms.get(5).add("Data Structures Lab");
            n.rooms.get(5).add("Software Lab 1");
        }

        // IT building
        for (node n : graph.get(1)) {
            // ground floor`
            n.rooms.get(0).add("Room 23");
            n.rooms.get(0).add("Career Guidance Cell");
            n.rooms.get(0).add("Lab IX-FPL Lab");
            n.rooms.get(0).add("KB Joshi Auditorium");

            // first floor
            n.rooms.get(1).add("Training and Placement Cell");

            // second floor
            n.rooms.get(2).add("Examination Department");
            n.rooms.get(2).add("Geoinformatics Lab");
            n.rooms.get(2).add("Room 19");
            n.rooms.get(2).add("Room 20");

            // third floor
            n.rooms.get(3).add("Room 21");
            n.rooms.get(3).add("Lab 1");
            n.rooms.get(3).add("Lab 2");
            n.rooms.get(3).add("Lab 3");
            n.rooms.get(3).add("Lab 4");
            n.rooms.get(3).add("Department Library IT");

            // fourth floor
            n.rooms.get(4).add("Lab 5");
            n.rooms.get(4).add("Lab 6");
            n.rooms.get(4).add("Lab 7");
            n.rooms.get(4).add("Lab 8");
            n.rooms.get(4).add("Room 24");
            n.rooms.get(4).add("Room 25");

        }

        // mech building
        for (node n : graph.get(2)) {
            // ground floor
            n.rooms.get(0).add("Workshop");

            // first floor
            n.rooms.get(1).add("Tut Room 7");
            n.rooms.get(1).add("Metrology and Quality Control Lab");
            n.rooms.get(1).add("Fluid Mechanics Lab");
            n.rooms.get(1).add("Center of Research and Intellectual Entrepreneurship");
            n.rooms.get(1).add("Turbomachines Lab");
            n.rooms.get(1).add("Refrigeration and AC Lab");

            // second floor
            n.rooms.get(2).add("M1");
            n.rooms.get(2).add("M2");
            n.rooms.get(2).add("M3");
            n.rooms.get(2).add("M4");
            n.rooms.get(2).add("M5");
            n.rooms.get(2).add("Student Common Room");
            n.rooms.get(2).add("Department of Mechanical Engineering and office and library");

            // third floor
            n.rooms.get(3).add("Conference Hall");
            n.rooms.get(3).add("LME-13 Project Centre");
            n.rooms.get(3).add("Mech Auditorium");
            n.rooms.get(3).add("M6");
            n.rooms.get(3).add("M7");
            n.rooms.get(3).add("M8");

            // fourth floor
            n.rooms.get(4).add("Chemistry Lab");
            n.rooms.get(4).add("Physics Lab");
            n.rooms.get(4).add("Mechanical Vibrations Lab");
            n.rooms.get(4).add("Computer Center");

            // fifth floor
            n.rooms.get(5).add("Engineering Graphics Lab");
            n.rooms.get(5).add("Heat Transfer and Thermodynamics Lab");

        }

        // instru 1 ie near main gate
        for (node n : graph.get(5)) {
            // groound floor
            n.rooms.get(0).add("Administration Student Section");
            n.rooms.get(0).add("Administration Personnel Section");
            n.rooms.get(0).add("Instru Auditorium");
            n.rooms.get(0).add("Seminar Hall");

            // first floor
            n.rooms.get(1).add("Instrumentation Projects Lab");
            n.rooms.get(1).add("Tut Room 9");
            n.rooms.get(1).add("PG Lab 1");
            n.rooms.get(1).add("Classroom 1");

            // second floor
            n.rooms.get(2).add("Bhaskaracharya Lab or Bio Medical Instrumentation Lab");
            n.rooms.get(2).add("Tut Room 10");
            n.rooms.get(2).add("Language Lab");
            n.rooms.get(2).add("Classroom 2");

            // third floor
            n.rooms.get(3).add("Project Engineering and Management Lab");
            n.rooms.get(3).add("Automation and Control Lab");
            n.rooms.get(3).add("Rigid Body Dynamics or Analysis and Synthesis of Mechanisms Lab");
            n.rooms.get(3).add("Robocon Room");
        }

        // instru 2 ie near canteen
        for (node n : graph.get(6)) {
            // ground floor
            n.rooms.get(0).add("Process Instrumentation Labs");
            n.rooms.get(0).add("Automation Center");
            n.rooms.get(0).add("Sports Office");
            n.rooms.get(0).add("NSS Program Office");
            n.rooms.get(0).add("Alumnae Association Office");

            // first floor
            n.rooms.get(1).add("Heinrich Hertz Lab");
            n.rooms.get(1).add("CV Raman Lab");
            n.rooms.get(1).add("Dark Room");
            n.rooms.get(1).add("Embedded Systems Lab");
            n.rooms.get(1).add("DSP Lab");
            n.rooms.get(1).add("Department Library Instru");
        }

        // mechatronics
        for (node n : graph.get(7)) {
            n.rooms.get(0).add("Mechatronics Garage");
        }
    }

    public ArrayList getBuilding(String room) {

        int reqDest = 0;
        ArrayList al = new ArrayList();
        for (int i = 0; i < 10; i++) {
            node n1 = graph.get(i).get(0);
            for (ArrayList<String> floor : n1.rooms) {
                for (String r1 : floor) {
                    if (r1.equals(room)) {
                        String buildingName = n1.name;
                        int floorNum = n1.rooms.indexOf(floor);
                        int buildingNum = graph.indexOf(graph.get(i));
                        al.add(buildingName);
                        al.add(floorNum);
                        al.add(buildingNum);
                        break;
                    }
                }
            }
        }
        return al;
    }

    public int getBuildingNum(String b){
        int buildingNum=0;
        for (int i = 0; i < 11; i++) {
            if (graph.get(i).get(0).name.equals(b)) {
                buildingNum = i;
            }
        }
        return buildingNum;
    }
}


