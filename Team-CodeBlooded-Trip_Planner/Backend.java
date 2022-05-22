package trip;

import java.sql.*;

import java.util.*;

public class Backend {

	Scanner scn = new Scanner(System.in);
	Connection conn = null;//
	Statement stmt = null;//
	PreparedStatement p = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	String USER = "root";//
	String PASS = "root123";//
	String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";//
	String DB_URL = "jdbc:mysql://localhost:3306/trip_planner?autoReconnect=true&useSSL=false";
	App a = new App();//Creating object of App class
	
	void call() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();

			System.out.format("\t%1$60s","TRIP_PLANNER\n");
			String q = "Select * from Connloc";
			p = conn.prepareStatement(q);
			rs = p.executeQuery();
			//Creating map of trip spots
			while (rs.next()) {
				int u = rs.getInt("city_idx");
				int v = rs.getInt("conn_idx");
				int w = rs.getInt("dist");
				a.g.addRoute(u, v, w);
			}

			boolean c = true;
			//MAIN MENU
			while (c) {
				System.out.format("%1$105s","******************************************************************************************");
				System.out.println();
				System.out.println("\t\t\t\t\t\t\t  HOME");
				System.out.format("%1$90s","**********************************************************");
				System.out.println();
				System.out.println("\t\t\t\t\t\t\t  1.Signup");
				System.out.println("\t\t\t\t\t\t\t  2.Login");
				System.out.println("\t\t\t\t\t\t\t  3.Exit");
				
				System.out.format("%1$105s","******************************************************************************************"); 
				System.out.println();
				System.out.println("\t\t\t\t\t\t  Enter your choice: ");
				System.out.print("\t\t\t\t\t\t\t  ");
				int ch = scn.nextInt();
				switch (ch) {
				case 1:
					//SIGNUP WINDOW
					a.signup();
					String q1 = "insert into user values ('" + a.u.user_name + "','" + a.u.mail_id + "','"
							+ a.u.password + "')";
					//CHECKING USER VALIDITY
					try {
						stmt.executeUpdate(q1);
						System.out.println("\t\t\t\t\t\t Signed up successfully!!\n");
					}
					catch(SQLException d) {
						System.out.println("\t\t\t\t\t\t User already exists!!\n");
					}
					
					break;
				case 2:
					//LOGIN WINDOW
					a.login();
					String q2 = "select * from user where mail_id ='" + a.user.mail_id + "'";

					p = conn.prepareStatement(q2);
					rs2 = p.executeQuery();
					//REDIRECTING UNREGISTERED USER TO SIGNUP WINDOW
					if (!rs2.next()) {

						System.out.println(
								"User not registered\nDo you wish to register?\nIf yes enter 1\n If no enter 2");
						int cho = scn.nextInt();
						System.out.println();
						if (cho == 1) {
							a.signup();
						} else {
							return;
						}
					} else {
						//CHECKING CREDENTIALS VALIDITY
						String ps = "";
						ps = rs2.getString("password");
						String un = "";
						un = rs2.getString("user_name");
						if (!ps.equals(a.user.password) || !un.equals(a.user.user_name)) {
							System.out.println("\t\t\t\t\t\t Wrong credentials!!");
							break;
						} else {
							System.out.println("\t\t\t\t\t\t Successfully Logged in!!");
							scn.nextLine();
							//GETTING CURRENT LOCATION OF USER
							System.out.println();
							System.out.print("\t\t\t\t\t\t Enter your location: ");
							String l = scn.nextLine();
							System.out.println();
							a.user.city = l;
							int src = -1, dest = 0;
							boolean d = true;
							a.g.display(1);
							//DISPLAY CITIES
							System.out.println("\t\t\t\t\t\t Trip Spots to visit");
							for (int i = 0; i < a.g.all.size()/2; i++) {
								q = "Select city_name from Location where city_idx=" + a.g.all.get(i);
								q2 = "Select city_name from Location where city_idx="+a.g.all.get(24-i);
								p = conn.prepareStatement(q);
								rs = p.executeQuery();
								String city = " ";
								while (rs.next()) {
									city = rs.getString("city_name");
								}
								p = conn.prepareStatement(q2);
								rs = p.executeQuery();
								String city1 = " ";
								while (rs.next()) {
									city1 = rs.getString("city_name");
								}
								//System.out.println(city+"\t\t\t\t\t\t\t   "+city1);
								System.out.print("\t\t\t\t");
								System.out.printf("%20s %20s",city,city1);
								System.out.println();
							}
							a.g.all.clear();
							while (d) {
								//NAVIGATION MENU
								System.out.format("%1$90s","**********************************************************");
								System.out.println();
								System.out.println("\t\t\t\t\t\t 1.Find your destination");
								System.out.println("\t\t\t\t\t\t 2.See recommended trip spots");
								System.out.println("\t\t\t\t\t\t 3.logout");
								System.out.format("%1$90s","**********************************************************");
								System.out.println();
								System.out.print("\t\t\t\t\t\t Enter your choice: ");
								//System.out.print("\t\t\t\t\t\t");
								int choice = scn.nextInt();
								System.out.println();
								System.out.println();
								
								if (choice == 1) {
									System.out.format("%1$90s","**********************************************************");
									System.out.println();
									System.out.println("\t\t\t\t\t\t Do you want to continue with your current location");
									System.out.println("\t\t\t\t\t\t 1.Yes");
									System.out.println("\t\t\t\t\t\t 2.No");
									System.out.format("%1$90s","**********************************************************");
									System.out.println();
									System.out.print("\t\t\t\t\t\t Enter your choice: ");
//									System.out.print("\t\t\t\t\t\t");
									int chs = scn.nextInt();
									scn.nextLine();
									System.out.println();
									switch (chs) {
									case 1:
										//NAVIGATING FROM CURRENT LOCATION TO SPECIFIED DESTINATION
										System.out.print("\t\t\t\t\t\t Enter your destination: ");
										String destination = scn.nextLine();
										System.out.println();
										q1 = "select city_idx from location where city_name = '" + destination + "'";
										q2 = "select city_idx from location where city_name = '" + l + "'";
										p = conn.prepareStatement(q2);
										rs = p.executeQuery();
										while (rs.next()) {
											src = rs.getInt("city_idx");
										}

										p = conn.prepareStatement(q1);
										rs = p.executeQuery();
										while (rs.next()) {
											dest = rs.getInt("city_idx");
										}
										//USING DJIKSTRA ALGORITHM TO GET SHORTEST PATH
										a.g.dijkstra(a.g.graph, src, dest);
										a.g.dijkstras(a.g.graph, src,dest);
//										System.out.println("size = "+a.g.parent.length);
										System.out.print("\t\t\t\t");
										for (int i = 0; i < a.g.path.size(); i++) {
											q = "Select city_name from Location where city_idx=" + a.g.path.get(i);
											p = conn.prepareStatement(q);
											rs = p.executeQuery();
											String city = " ";
											while (rs.next()) {
												city = rs.getString("city_name");
											}
											System.out.print(city+" => ");
										}
										a.g.path.clear();
										System.out.println();
										System.out.print("\t\t\t\t");
										System.out.println(
												String.format("Distance from %s to %s is %s km with cost %s rupees", l,
														destination, a.g.dist, a.g.total_cost));
										break;
									case 2:
										//NAVIGATING FROM SPECIFIED LOCATION TO SPECIFIED DESTINATION
										System.out.print("\t\t\t\t\t\t Enter starting location: ");
										String source = scn.nextLine();
										System.out.println();
										System.out.print("\t\t\t\t\t\t Enter your destination: ");
										destination = scn.nextLine();
										System.out.println();
										q1 = "select city_idx from location where city_name = '" + destination + "'";
										q2 = "select city_idx from location where city_name = '" + source + "'";
										p = conn.prepareStatement(q2);
										rs = p.executeQuery();
										while (rs.next()) {
											src = rs.getInt("city_idx");
										}

										p = conn.prepareStatement(q1);
										rs = p.executeQuery();
										while (rs.next()) {
											dest = rs.getInt("city_idx");
										}
										//USING DJIKSTRA ALGORITHM TO GET SHORTEST PATH
										a.g.dijkstra(a.g.graph, src, dest);
										//System.out.println(a.g.path);
										a.g.dijkstras(a.g.graph, src,dest);
//										System.out.println("size = "+a.g.parent.length);
										System.out.print("\t\t\t\t");
										for (int i = 0; i < a.g.path.size(); i++) {
											q = "Select city_name from Location where city_idx=" + a.g.path.get(i);
											p = conn.prepareStatement(q);
											rs = p.executeQuery();
											String city = " ";
											while (rs.next()) {
												city = rs.getString("city_name");
											}
											System.out.print(city+" => ");
										}
										a.g.path.clear();
										System.out.println();
										System.out.print("\t\t\t\t");
										System.out.println(
												String.format("Distance from %s to %s is %s km with cost %s rupees",
														source, destination, a.g.dist, a.g.total_cost));
										break;

									}
								} else if (choice == 2) {
									//NEARBY PLACES FOR EXPLORATION USING BFS
									q = "Select city_idx from Location where city_name='" + l + "'";
									p = conn.prepareStatement(q);
									rs = p.executeQuery();
									while (rs.next()) {
										src = rs.getInt("city_idx");
									}
									a.g.BFS_List(src);
									System.out.println("\t\t\t\t\t\t Places near " + l + " =>");
									for (int i = 0; i < a.g.cl.size(); i++) {
										q = "Select city_name from Location where city_idx=" + a.g.cl.get(i);
										p = conn.prepareStatement(q);
										rs = p.executeQuery();
										String city = " ";
										while (rs.next()) {
											city = rs.getString("city_name");
										}
										System.out.println("\t\t\t\t\t\t"+city);
									}
									a.g.cl.clear();
								} else {
									System.out.println("\t\t\t\t\t\t Logged Out Successfully!!");
									d = false;
								}

							}
						}

					}
					break;
				case 3:
					System.out.println("\t\t\t\t\t\t Thank you!!");
					c = false;
					break;
				}
			}

		} catch (ClassNotFoundException e) {
			System.out.println("\t\t\t\t\t\t Executed!!");
		} catch (SQLException se) {
			System.out.println("\t\t\t\t\t\t SQL Exception!!");
		}
	}

}
