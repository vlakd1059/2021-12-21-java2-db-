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
					+ "                         //＼ ＼     //   ) )   //  ) )   //___) )   //   ) ) \r\n"
					+ "                        //  ＼ ＼   //   / /   //        //         //   / /  \r\n"
					+ "                       //    ＼ ＼ ((___/ /   //        ((____     ((___( (   \t ");

			// System.out.println();
			System.out.println("                                                                          \r\n"
					+ "                                                                          \r\n"
					+ "                                                                          \r\n"
					+ "                                            ___                    __                ( )              ___       //  \r\n"
					+ "                                          ((   ) )   //   / /    //  ) )  ||  / /   / /   ||  / /   //   ) )   //   \r\n"
					+ "                                           ＼＼      //   / /    //        || / /   / /    || / /   //   / /   //    \r\n"
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
				System.out.print("\t\t\t" + " 1.[로그인] 2.[회원가입] 3.[명예의전당] 4.[회원목록보기] 5.[회원탈퇴] 6. [엔딩] 7.[종료]");
				int choice = sc.nextInt();
				System.out.println();
				System.out.println();
				if (choice == 1) {

					System.out.println(

							" () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () () ()");

					System.out.println();
					System.out.println();
					System.out.println("\t\t\t\t\t\t" + "[로그인]");
					System.out.print("\t\t\t\t\t\t" + "아이디 입력 : ");
					String id = sc.next();
					System.out.print("\t\t\t\t\t\t" + "비밀번호 입력 : ");
					String pw = sc.next();
					String nick = dao.login(id, pw);

					if (nick != null) {
						System.out.println("\t\t\t\t\t\t" + nick + "님 환영합니다!");
//					
//					int a = 0;
//					String name;
//					
//					if(a == 0) {
//						name = "수도";
//					}else if(a == 1) {
//						name = "지방";
//					}else{
//						name = "두메산골";
//					}
//					
//					String month = "4";
//					
//					//nick은 로그인시 사용된 아이디의 닉네임.
//					dao.ranking(nick,name,month);

						exit++;
						if (id.equals("admin")) {
							System.out.println("1.회원정보수정 2.회원삭제");
							choice = sc.nextInt();

							if (choice == 1) {
								System.out.println("[관리자 회원정보수정]");
								System.out.print("아이디 입력 : ");
								String change_id = sc.next();
								System.out.print("변경할 닉네임 입력 : ");
								String change_nick = sc.next();

								int cnt = dao.adminUpdate(change_id, change_nick);
								if (cnt > 0) {
									System.out.println("회원정보 수정 완료");
								} else {
									System.out.println("회원정보 수정 실패");
								}

							} else if (choice == 2) {
								System.out.println("[관리자 회원삭제]");

								ArrayList<MemberDTO> list = dao.selectAll();
								int cnt = 1;
								for (int i = 0; i < list.size(); i++) {
									MemberDTO m = list.get(i);
									if (!m.getId().equals("admin")) {
										System.out.println(cnt + "." + m.getId());
										cnt++;
									}
								}
								System.out.println("삭제할 아이디 입력 : ");
								String removeId = sc.next();
								if (!removeId.equals("admin")) {
									int result = dao.deleteId(removeId);
									if (result > 0) {
										System.out.println("아이디 삭제 완료");
									} else {
										System.out.println("아이디 삭제 실패");
									}
								} else {
									System.out.println("삭제할 수 없습니다");
								}
							}
							break;
						}

					} else {
						System.out.println("\t\t\t\t\t\t" + "[Server] 로그인 실패");
					}
				} else if (choice == 2) {

					System.out.println("\t\t\t\t\t\t" + "[회원가입]");
					System.out.print("\t\t\t\t\t\t" + "아이디 입력 : ");
					String id = sc.next();
					System.out.print("\t\t\t\t\t\t" + "비밀번호 입력 : ");
					String pw = sc.next();
					System.out.print("\t\t\t\t\t\t" + "닉네임 입력 : ");
					String nick = sc.next();
					int cnt = dao.join(id, pw, nick);
					if (cnt > 0) {
						System.out.println("\t\t\t\t\t\t" + "회원가입 성공");
					} else {
						System.out.println("\t\t\t\t\t\t" + "닉네임이 중복입니다.");
						System.out.println("\t\t\t\t\t\t" + "회원가입 실패");
					}

				} else if (choice == 3) {
					System.out.println("\t\t\t\t\t\t" + "[명예의 전당]");
					ArrayList<MemberDTO> list = dao.selectAll();
					
				} else if (choice == 4) {
					System.out.println("\t\t\t\t\t\t" + "[회원목록보기]");
					ArrayList<MemberDTO> list = dao.selectAll();
					int cnt = 1;
					System.out.println("\t\t\t\t\t\t" + "[아이디]  [닉네임]");
					for (int i = 0; i < list.size(); i++) {
						MemberDTO m = list.get(i);
						System.out.print("\t\t\t\t\t\t" + cnt + ". " + m.getId() + " - ");
						System.out.println(m.getNick());
						cnt++;
					}
				} else if (choice == 5) {
					System.out.println("\t\t\t\t\t\t" + "[회원탈퇴]");
					System.out.print("\t\t\t\t\t\t" + "아이디 입력 : ");
					String id = sc.next();
					System.out.print("\t\t\t\t\t\t" + "비밀번호 입력 : ");
					String pw = sc.next();

					int cnt = dao.delete(id, pw);

					if (cnt > 0) {
						System.out.println("\t\t\t\t\t\t" + "회원삭제 완료");
					} else {
						System.out.println("\t\t\t\t\t\t" + "회원삭제 실패");
					}
				} else if (choice == 6) {
					System.out.println("\t\t\t\t\t\t" + "[엔딩]");
//					while(true) {
//					
//					System.out.println("엔딩 고르기");
//					System.out.println("1히든 헬창,2히든 백신,3히든 크리스마스,"+"\n"
//							+ "4노말 학생,5노말 운동,6노말 간호사,7오미크론 등장"+"\n"
//							+ "8배드엔드 코로나,9배드엔드 변이바이러스,10 배드엔드 과로"+"\n"
//							+ "11.히든 알코올 , 12 고라 , 13 대유행 ,100 = 패스");
//					int x = in.nextInt();
//					onlyend(x);
//					fun.timelate(2);
//					if(x==100) {
//						break;
//					}
//				}
				// System.out.println("끝나면!");
				} else if (choice == 7) {
					System.out.println("\t\t\t\t\t\t" + "종료합니다...");
					break;
				}
			}
			
		}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		DBDAO dao = new DBDAO();
//		System.out.println("2021 대한민국 살아남기");
//		Controllor con = new Controllor();
//		while (true) {
//
//			System.out.println("1.[로그인] 2.[회원가입] 3.[명예의전당] 4.[회원목록보기] 5.[회원탈퇴] 6.[종료]");
//			int choice = sc.nextInt();
//
//			if (choice == 1) {
//				
//				System.out.println("====로그인====");
//				System.out.print("아이디 입력 : ");
//				String id = sc.next();
//				System.out.print("비밀번호 입력 : ");
//				String pw = sc.next();
//				String nick = dao.login(id, pw);
//				
//				if (nick != null) {
//					System.out.println(nick + "님 환영합니다!");
//
//					if (id.equals("admin")) {
//						System.out.println("1.회원정보수정 2.회원삭제");
//						choice = sc.nextInt();
//
//						if (choice == 1) {
//							System.out.println("====관리자 회원정보수정====");
//							System.out.print("아이디 입력 : ");
//							String change_id = sc.next();
//							System.out.print("변경할 닉네임 입력 : ");
//							String change_nick = sc.next();
//
//							int cnt = dao.adminUpdate(change_id, change_nick);
//							if (cnt > 0) {
//								System.out.println("회원정보 수정 완료");
//							} else {
//								System.out.println("회원정보 수정 실패");
//							}
//
//						} else if (choice == 2) {
//							System.out.println("====관리자 회원삭제====");
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
//							System.out.println("삭제할 아이디 입력 : ");
//							String removeId = sc.next();
//							if (!removeId.equals("admin")) {
//								int result = dao.deleteId(removeId);
//								if (result > 0) {
//									System.out.println("아이디 삭제 완료");
//								} else {
//									System.out.println("아이디 삭제 실패");
//								}
//							} else {
//								System.out.println("삭제할 수 없습니다");
//							}
//						}
//						break;
//					}
//
//				} else {
//					System.out.println("[Server] 로그인 실패");
//				}
//				
//				while (true) {
//					con.timelate(2);
//					System.out.println("간호사 - 체력 100 면역력 25");
//					con.timelate(2);
//					System.out.println("운동선수 - 체력 120 면역력 10");
//					con.timelate(2);
//					System.out.println("학생 - 체력 100 면역력 10");
//					con.timelate(2);
//					System.out.println("직업을 골라주세요");
//					System.out.print("1.[간호사] 2.[운동선수] 3.[학생]");
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
//				System.out.println("====회원가입====");
//				System.out.print("아이디 입력 : ");
//				String id = sc.next();
//				System.out.print("비밀번호 입력 : ");
//				String pw = sc.next();
//				System.out.print("닉네임 입력 : ");
//				String nick = sc.next();
//				int cnt = dao.join(id, pw, nick);
//				if (cnt > 0) {
//					System.out.println("회원가입 성공");
//				} else {
//					System.out.println("닉네임이 중복입니다.");
//					System.out.println("회원가입 실패");
//				}
//
//			} else if (choice == 3) {
//				System.out.println("====명예의 전당====");
//				
//			} else if (choice == 4) {
//				System.out.println("====회원목록보기====");
//				ArrayList<MemberDTO> list = dao.selectAll();
//				int cnt = 1;
//				System.out.println("===아이디===닉네임===");
//				for (int i = 0; i < list.size(); i++) {
//					MemberDTO m = list.get(i);
//					System.out.print(cnt + ". " + m.getId() + " - ");
//					System.out.println(m.getNick());
//					cnt++;
//				}
//			} else if (choice == 5) {
//				System.out.println("====회원탈퇴====");
//				System.out.print("아이디 입력 : ");
//				String id = sc.next();
//				System.out.print("비밀번호 입력 : ");
//				String pw = sc.next();
//
//				int cnt = dao.delete(id, pw);
//
//				if (cnt > 0) {
//					System.out.println("회원삭제 완료");
//				} else {
//					System.out.println("회원삭제 실패");
//				}
//			} else if (choice == 6) {
//				System.out.println("종료합니다...");
//				break;
//			}
//		}
//
//	}
//
	}
}
