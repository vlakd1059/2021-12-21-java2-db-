package DB;


import java.util.ArrayList;
import java.util.Scanner;

public class loginMethod {

	public static void db() {
		Scanner sc = new Scanner(System.in);
		DBDAO dao = new DBDAO();
		int exit = 0;

		System.out.print(
				"\t\t\t\t" + " || " + "\t" + "  1. GAME START " + "\t" + " || " + "\t" + "  2. EXIT " + "\t" + " || ");
		int sel = sc.nextInt();

		if (sel == 1) {
			System.out.println(

					" () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () ()");
			System.out.println("                                             \r\n"
					+ "        ___         ___         ___                \r\n"
					+ "      //   ) )    //   ) )    //   ) )    /_  /    \r\n"
					+ "       ___/ /    //   / /      ___/ /      / /     \r\n"
					+ "     / ____/    //   / /     / ____/      / /      \r\n"
					+ "    / /____    ((___/ /     / /____      / /       ");

			System.out.println("\t                                                     \r\n"
					+ "                                                      \r\n"
					+ "                           / ____      ___        __        ___        ___    \r\n"
					+ "                         //�� ��     //   ) )   //  ) )   //___) )   //   ) ) \r\n"
					+ "                        //  �� ��   //   / /   //        //         //   / /  \r\n"
					+ "                       //    �� �� ((___/ /   //        ((____     ((___( (   \t ");

			// System.out.println();
			System.out.println("                                                                          \r\n"
					+ "                                                                          \r\n"
					+ "                                                                          \r\n"
					+ "                                            ___                    __                ( )              ___       //  \r\n"
					+ "                                          ((   ) )   //   / /    //  ) )  ||  / /   / /   ||  / /   //   ) )   //   \r\n"
					+ "                                           ����      //   / /    //        || / /   / /    || / /   //   / /   //    \r\n"
					+ "                                        //___) )   ((___( (    //         ||/ /   / /     ||/ /   ((___( (   //     ");

			System.out.println();
			System.out.println();
			System.out.println(

					" () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () ()");

			while (true) {
				if (exit != 0) {
					break;
				}
				System.out.println();
				System.out.println();
				System.out.print("\t\t\t" + " 1.[�α���] 2.[ȸ������] 3.[��������] 4.[ȸ����Ϻ���] 5.[ȸ��Ż��] 6. [����] 7.[����]");
				int choice = sc.nextInt();
				System.out.println();
				System.out.println();
				if (choice == 1) {

					System.out.println(

							" () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () ()");

					System.out.println();
					System.out.println();
					System.out.println("\t\t\t\t\t\t" + "[�α���]");
					System.out.print("\t\t\t\t\t\t" + "���̵� �Է� : ");
					String id = sc.next();
					System.out.print("\t\t\t\t\t\t" + "��й�ȣ �Է� : ");
					String pw = sc.next();
					String nick = dao.login(id, pw);

					if (nick != null) {
						System.out.println("\t\t\t\t\t\t" + nick + "�� ȯ���մϴ�!");
//					
//					int a = 0;
//					String name;
//					
//					if(a == 0) {
//						name = "����";
//					}else if(a == 1) {
//						name = "����";
//					}else{
//						name = "�θ޻��";
//					}
//					
//					String month = "4";
//					
//					//nick�� �α��ν� ���� ���̵��� �г���.
//					dao.ranking(nick,name,month);

						exit++;
						if (id.equals("admin")) {
							System.out.println("1.ȸ���������� 2.ȸ������");
							choice = sc.nextInt();

							if (choice == 1) {
								System.out.println("[������ ȸ����������]");
								System.out.print("���̵� �Է� : ");
								String change_id = sc.next();
								System.out.print("������ �г��� �Է� : ");
								String change_nick = sc.next();

								int cnt = dao.adminUpdate(change_id, change_nick);
								if (cnt > 0) {
									System.out.println("ȸ������ ���� �Ϸ�");
								} else {
									System.out.println("ȸ������ ���� ����");
								}

							} else if (choice == 2) {
								System.out.println("[������ ȸ������]");

								ArrayList<MemberDTO> list = dao.selectAll();
								int cnt = 1;
								for (int i = 0; i < list.size(); i++) {
									MemberDTO m = list.get(i);
									if (!m.getId().equals("admin")) {
										System.out.println(cnt + "." + m.getId());
										cnt++;
									}
								}
								System.out.println("������ ���̵� �Է� : ");
								String removeId = sc.next();
								if (!removeId.equals("admin")) {
									int result = dao.deleteId(removeId);
									if (result > 0) {
										System.out.println("���̵� ���� �Ϸ�");
									} else {
										System.out.println("���̵� ���� ����");
									}
								} else {
									System.out.println("������ �� �����ϴ�");
								}
							}
							break;
						}

					} else {
						System.out.println("\t\t\t\t\t\t" + "[Server] �α��� ����");
					}
				} else if (choice == 2) {

					System.out.println("\t\t\t\t\t\t" + "[ȸ������]");
					System.out.print("\t\t\t\t\t\t" + "���̵� �Է� : ");
					String id = sc.next();
					System.out.print("\t\t\t\t\t\t" + "��й�ȣ �Է� : ");
					String pw = sc.next();
					System.out.print("\t\t\t\t\t\t" + "�г��� �Է� : ");
					String nick = sc.next();
					int cnt = dao.join(id, pw, nick);
					if (cnt > 0) {
						System.out.println("\t\t\t\t\t\t" + "ȸ������ ����");
					} else {
						System.out.println("\t\t\t\t\t\t" + "�г����� �ߺ��Դϴ�.");
						System.out.println("\t\t\t\t\t\t" + "ȸ������ ����");
					}

				} else if (choice == 3) {
					System.out.println("\t\t\t\t\t\t" + "[���� ����]");
					ArrayList<MemberDTO> list = dao.selectAll();
					
				} else if (choice == 4) {
					System.out.println("\t\t\t\t\t\t" + "[ȸ����Ϻ���]");
					ArrayList<MemberDTO> list = dao.selectAll();
					int cnt = 1;
					System.out.println("\t\t\t\t\t\t" + "[���̵�]  [�г���]");
					for (int i = 0; i < list.size(); i++) {
						MemberDTO m = list.get(i);
						System.out.print("\t\t\t\t\t\t" + cnt + ". " + m.getId() + " - ");
						System.out.println(m.getNick());
						cnt++;
					}
				} else if (choice == 5) {
					System.out.println("\t\t\t\t\t\t" + "[ȸ��Ż��]");
					System.out.print("\t\t\t\t\t\t" + "���̵� �Է� : ");
					String id = sc.next();
					System.out.print("\t\t\t\t\t\t" + "��й�ȣ �Է� : ");
					String pw = sc.next();

					int cnt = dao.delete(id, pw);

					if (cnt > 0) {
						System.out.println("\t\t\t\t\t\t" + "ȸ������ �Ϸ�");
					} else {
						System.out.println("\t\t\t\t\t\t" + "ȸ������ ����");
					}
				} else if (choice == 6) {
					System.out.println("\t\t\t\t\t\t" + "[����]");
//					while(true) {
//					
//					System.out.println("���� ����");
//					System.out.println("1���� ��â,2���� ���,3���� ũ��������,"+"\n"
//							+ "4�븻 �л�,5�븻 �,6�븻 ��ȣ��,7����ũ�� ����"+"\n"
//							+ "8��忣�� �ڷγ�,9��忣�� ���̹��̷���,10 ��忣�� ����"+"\n"
//							+ "11.���� ���ڿ� , 12 ��� , 13 ������ ,100 = �н�");
//					int x = in.nextInt();
//					onlyend(x);
//					fun.timelate(2);
//					if(x==100) {
//						break;
//					}
//				}
				// System.out.println("������!");
				} else if (choice == 7) {
					System.out.println("\t\t\t\t\t\t" + "�����մϴ�...");
					break;
				}
			}
			
		}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		DBDAO dao = new DBDAO();
//		System.out.println("2021 ���ѹα� ��Ƴ���");
//		Controllor con = new Controllor();
//		while (true) {
//
//			System.out.println("1.[�α���] 2.[ȸ������] 3.[��������] 4.[ȸ����Ϻ���] 5.[ȸ��Ż��] 6.[����]");
//			int choice = sc.nextInt();
//
//			if (choice == 1) {
//				
//				System.out.println("====�α���====");
//				System.out.print("���̵� �Է� : ");
//				String id = sc.next();
//				System.out.print("��й�ȣ �Է� : ");
//				String pw = sc.next();
//				String nick = dao.login(id, pw);
//				
//				if (nick != null) {
//					System.out.println(nick + "�� ȯ���մϴ�!");
//
//					if (id.equals("admin")) {
//						System.out.println("1.ȸ���������� 2.ȸ������");
//						choice = sc.nextInt();
//
//						if (choice == 1) {
//							System.out.println("====������ ȸ����������====");
//							System.out.print("���̵� �Է� : ");
//							String change_id = sc.next();
//							System.out.print("������ �г��� �Է� : ");
//							String change_nick = sc.next();
//
//							int cnt = dao.adminUpdate(change_id, change_nick);
//							if (cnt > 0) {
//								System.out.println("ȸ������ ���� �Ϸ�");
//							} else {
//								System.out.println("ȸ������ ���� ����");
//							}
//
//						} else if (choice == 2) {
//							System.out.println("====������ ȸ������====");
//
//							ArrayList<MemberDTO> list = dao.selectAll();
//							int cnt = 1;
//							for (int i = 0; i < list.size(); i++) {
//								MemberDTO m = list.get(i);
//								if (!m.getId().equals("admin")) {
//									System.out.println(cnt + "." + m.getId());
//									cnt++;
//								}
//							}
//							System.out.println("������ ���̵� �Է� : ");
//							String removeId = sc.next();
//							if (!removeId.equals("admin")) {
//								int result = dao.deleteId(removeId);
//								if (result > 0) {
//									System.out.println("���̵� ���� �Ϸ�");
//								} else {
//									System.out.println("���̵� ���� ����");
//								}
//							} else {
//								System.out.println("������ �� �����ϴ�");
//							}
//						}
//						break;
//					}
//
//				} else {
//					System.out.println("[Server] �α��� ����");
//				}
//				
//				while (true) {
//					con.timelate(2);
//					System.out.println("��ȣ�� - ü�� 100 �鿪�� 25");
//					con.timelate(2);
//					System.out.println("����� - ü�� 120 �鿪�� 10");
//					con.timelate(2);
//					System.out.println("�л� - ü�� 100 �鿪�� 10");
//					con.timelate(2);
//					System.out.println("������ ����ּ���");
//					System.out.print("1.[��ȣ��] 2.[�����] 3.[�л�]");
//					choice = sc.nextInt();
//					
//					if(choice == 1) {
//					} else if (choice == 2) {
//					} else if (choice == 3) {
//					}
//				
//				}
//				
//			} else if (choice == 2) {
//
//				System.out.println("====ȸ������====");
//				System.out.print("���̵� �Է� : ");
//				String id = sc.next();
//				System.out.print("��й�ȣ �Է� : ");
//				String pw = sc.next();
//				System.out.print("�г��� �Է� : ");
//				String nick = sc.next();
//				int cnt = dao.join(id, pw, nick);
//				if (cnt > 0) {
//					System.out.println("ȸ������ ����");
//				} else {
//					System.out.println("�г����� �ߺ��Դϴ�.");
//					System.out.println("ȸ������ ����");
//				}
//
//			} else if (choice == 3) {
//				System.out.println("====���� ����====");
//				
//			} else if (choice == 4) {
//				System.out.println("====ȸ����Ϻ���====");
//				ArrayList<MemberDTO> list = dao.selectAll();
//				int cnt = 1;
//				System.out.println("===���̵�===�г���===");
//				for (int i = 0; i < list.size(); i++) {
//					MemberDTO m = list.get(i);
//					System.out.print(cnt + ". " + m.getId() + " - ");
//					System.out.println(m.getNick());
//					cnt++;
//				}
//			} else if (choice == 5) {
//				System.out.println("====ȸ��Ż��====");
//				System.out.print("���̵� �Է� : ");
//				String id = sc.next();
//				System.out.print("��й�ȣ �Է� : ");
//				String pw = sc.next();
//
//				int cnt = dao.delete(id, pw);
//
//				if (cnt > 0) {
//					System.out.println("ȸ������ �Ϸ�");
//				} else {
//					System.out.println("ȸ������ ����");
//				}
//			} else if (choice == 6) {
//				System.out.println("�����մϴ�...");
//				break;
//			}
//		}
//
//	}
//
	}
}
