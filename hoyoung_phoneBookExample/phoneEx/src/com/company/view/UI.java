package com.company.view;

import java.util.List;
import java.util.Scanner;

import com.company.domain.Contact;
import com.company.domain.Status;
import com.company.exception.InvalidMenuSelect;
import com.company.service.ContactService;
import com.company.service.StatusService;

public class UI {
	private Scanner sc = new Scanner(System.in);
	private ContactService service = new ContactService();
	public void mainUI() {
		try {
			boolean isMainEnd = false;
			while(!isMainEnd) {
				int menu = 0;
				System.out.println("===========================================================");
				System.out.println("1. register   2. delete   3. find   4. list   5. exit");
				System.out.println("===========================================================");
				System.out.print(">>");
				menu = sc.nextInt();
				switch (menu) {
					case 1 : {
						isMainEnd = true;
						StatusService.setCurrentStatus(Status.REGISTER);
						break;
					}
					case 2 : {
						isMainEnd = true;
						StatusService.setCurrentStatus(Status.DELETE);
						break;
					}
					case 3 : {
						isMainEnd = true;
						StatusService.setCurrentStatus(Status.FIND);
						break;
					}
					case 4 : {
						isMainEnd = true;
						StatusService.setCurrentStatus(Status.LIST);
						break;
					}
					case 5 : {
						isMainEnd = true;
						StatusService.setCurrentStatus(Status.END);
						break;
					}
					default: {
						throw new InvalidMenuSelect();

					}
				}

				if (isMainEnd) {
					System.out.println("cur : " + StatusService.getCurrent());
					break;
				}
			}

		} catch (InvalidMenuSelect e) {
			System.out.println("다시 입력 해 주세요");
		}
	}

	public void registerUI() {
		try {
			boolean isMainEnd = false;
			while(!isMainEnd) {
				String name = "";
				String address = "";
				String number = "";
				System.out.println("===========================================================");
				System.out.println("1. REGISTER PAGE");
				System.out.println("===========================================================");
				System.out.print("enter name >>");
				name = sc.next();
				System.out.print("enter address >>");
				address = sc.next();
				System.out.print("enter phone number >>");
				number = sc.next();
				Contact contact = new Contact(name, address, number);
				service.save(contact);
				isMainEnd = true;
				StatusService.setCurrentStatus(Status.MAIN);
			}

		} catch (Exception e) {
			System.out.println("다시 입력 해 주세요");
		}
	}

	public void deleteUI() {
		try {
			boolean isMainEnd = false;
			while(!isMainEnd) {
				String name = "";

				System.out.println("===========================================================");
				System.out.println("2. DELETE PAGE");
				System.out.println("===========================================================");
				System.out.print("enter name >>");
				name = sc.next();

				Contact contact = service.find(name);
				System.out.println("===========================================================");
				System.out.println("are you sure delete " + contact + "?");
				System.out.println("===========================================================");
				service.delete(name);
				isMainEnd = true;
				StatusService.setCurrentStatus(Status.MAIN);
			}

		} catch (Exception e) {
			System.out.println("다시 입력 해 주세요");
		}
	}

	public void findUI() {
		try {
			boolean isMainEnd = false;
			while(!isMainEnd) {
				String name = "";
				String address = "";
				String number = "";
				System.out.println("===========================================================");
				System.out.println("3. FIND PAGE");
				System.out.println("===========================================================");
				System.out.print("enter name >>");
				name = sc.next();
				Contact contact = service.find(name);
				System.out.println("===========================================================");
				System.out.println("here you are : " + contact + "?");
				System.out.println("===========================================================");
				isMainEnd = true;
				StatusService.setCurrentStatus(Status.MAIN);
			}

		} catch (Exception e) {
			System.out.println("다시 입력 해 주세요");
		}
	}

	public void listUI() {
		try {
			boolean isMainEnd = false;
			while(!isMainEnd) {
				System.out.println("===========================================================");
				System.out.println("4. LIST PAGE");
				System.out.println("===========================================================");
				System.out.println(service.findAll());
				System.out.println("===========================================================");
				isMainEnd = true;
				StatusService.setCurrentStatus(Status.MAIN);
			}

		} catch (Exception e) {
			System.out.println("다시 입력 해 주세요");
		}
	}

	public void eopUI() {
		System.out.println("Bye!!");
		StatusService.setCurrentStatus(Status.END);
	}
}
